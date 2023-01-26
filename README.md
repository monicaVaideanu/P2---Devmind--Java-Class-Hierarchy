# P2---Devmind--Java-Class-Hierarchy
P2 - Java Class Hierarchy
ARHITECTURA:
                                                                    1. Tipuri de surprize

Fiecare surpriză va implementa următoarea interfață, ce permite „deschiderea“ surprizei: 
public interface ISurprise {
 
  // Opens the surprise and enjoys it
  void enjoy();
}

Tipurile de surprize sunt următoarele:

* FortuneCookie -> Reprezintă o surpriză de tipul Fortune Cookie în care persoana va primi un mesaj simbolic, care să o călăuzească în viitor. (Clasa primește mesajul (i.e. String) la construcția obiectului. 
Acesta va fi afișat la output în momentul „deschiderii surprizei“.)
* Candies -> Surpriza conține un număr aleator de bomboane, de un anumit tip. (Constructorul clasei va primi numărul de bomboane și tipul acestora. La execuția surprizei se va afișa un mesaj relevant, 
în funcție de starea internă a obiectului-surpriză.)
* MinionToy -> Surpriza va fi o jucărie Minion. (Clasa primește la crearea obiectelor numele minionului. La deschiderea surprizei, se va afișa un mesaj sugestiv la output, ce include detaliile jucăriei primite.)

Fiecare dintre cele trei clase va trebui să implementeze metoda toString(), iar pentru implementarea metodei enjoy() se va afișa un mesaj corespunzator, descris în tabelul de mai jos.
FortuneCookie	enjoy():	Se vor afișa două linii, pe prima linie mesajul You got a fortune cookie! pe cea de-a doua linie, între ghilimele, citatul corespunzător
FortuneCookie	toString():	Se va afișa header-ul [FortuneCookie] message = , urmat de valoarea câmpului message.
Candies	enjoy():	Metoda va afișa mesajul You received $num $type candies, unde $num și $type vor fi înlocuite de valorile variabilelor din clasă
Candies	toString():	Se va afișa mesajul [Candies] number = $num, type = $type, unde $num și $type vor fi înlocuite de valorile variabilelor din clasă
MinionToy	enjoy():	Se va afișa mesajul: You got a minion named $name!, unde $name reprezintă valoarea variabilei name
MinionToy	toString():	Se va afișa header-ul [Minion] name = , urmat de valoarea câmpului name

Fiecare clasă-surpriză va conține și o metodă statică generate(), care va crea o surpriză de tipul respectiv. Pentru fiecare tip de surpriză, detaliile algoritmului de generare sunt:
Surpriză	                                    Algoritm de generare
FortuneCookie ->	Clasa va conține un vector de minim 20 de zicale (+ autorul acestora) la alegere. Poți lua colecția de zicale de pe un site de specialitate.
La apelul metodei generate(), metoda va genera un număr aleator și va alege elementul din array în consecință. Ulterior, va crea o (nouă) surpriză corespunzător.
Candies ->	Clasa va menține intern o colecție de tipuri de bomboane. De exemplu: [chocolate, jelly, fruits, vanilla].
La generarea unei noi surprize, metoda va genera 2 numere aleatoare, pentru a decide tipul bomboanelor (i.e. o surpriză conține un singur tip de bomboane) și respectiv numărul acestora. Ulterior, va crea o (nouă) surpriză corespunzător.
MinionToy -> Clasa va stoca o colecție de nume de minioni. De exemplu: [Dave, Carl, Kevin, Stuart, Jerry, Tim].
La generarea unei noi surprize, se va alege în ordine următorul tip de minion, conform colecției ordonate prezentate anterior. Concret, prima surpriză generată va oferi un minion Dave, următoarea un Carl, ș.a.m.d.
→ Hint: vei avea nevoie de un contor intern pentru a reține ultimul minion oferit.

                                                                2. Depozitarea surprizelor

Toate surprizele vor fi depozitate în diverse tipuri de containere, care vor dicta modul de stocare și mai ales ordinea în care surprizele vor fi împărțite. Deoarece dorim să operăm cu orice tip de container într-un mod transparent, independent de implementare, vom utiliza o interfață ce va defini protocolul concret de comunicare. Astfel:

Implementare: fiecare container va implementa interfața comună.
Utilizare: fiecare entitate-utilizator va folosi un container din perspectiva interfeței, utilizând implicit numai metodele definite de acea interfață.
Interfața va defini următoarele metode:
public interface IBag {
 
  // adds a surprise in the bag
  void put(ISurprise newSurprise);
 
  // adds all the surprises from another IBag
  //   -> the 'bagOfSurprises' will be empty() afterwards
  void put(IBag bagOfSurprises);
 
  // removes a surprise from the bag and returns it
  ISurprise takeOut();
 
  // Checks if the bag is empty or not
  boolean isEmpty();
 
  // Returns the number of surprises
  int size();
}

Se implementează următoarele tipuri de „tolbe de surprize“:

O tolbă care va da cadourile din interior într-o ordine aleatoare
O tolbă care va da cadourile în ordinea în care acestea au fost introduse (strategie numită FIFO)
O tolbă care va da cadourile în ordinea inversă introducerii (strategie numită LIFO)

                                                                    3. Crearea surprizelor

Pentru a genera un set de surprize aleatoare, vom implementa o clasă „specială“, GatherSurprises, care va conține:

o metodă statică, gather(int n), ce primește un număr întreg n și returnează un array conținând n surprize.
o metodă statică, gather(), care va returna o singură surpriză.
Observații:

Deși intern metodele generează aleator surprizele, aceasta simbolizează acțiunea reală de a colecta surprizele pregătite de oameni darnici pentru cei mici (i.e. în preajma sărbătorilor).
Deoarece fiecare om pregătește ce surpriză dorește, colecția / surpriza întoarsă va fi de fiecare dată diferită.
Se utilizează 2 mecanisme de generare aleatoare:
cel implementat deja, prin care se generează aleator o surpriză aparținând unui anumit tip.
un număr random pentru a se alege tipul de surpriză generată, la fiecare pas.
Specificații
Prin definiție, clasa GatherSurprises nu ar trebui să permită crearea instanțelor și nici moștenirea, deoarece implementarea sa este definitivă și toate metodele sale sunt statice. Deși Java nu permite marcarea unei clase static, putem recurge la următoarele artificii:

instanțiere: putem crea un (singur) constructor, de formă, pe care să îl marcăm private.
Obs: Într-un astfel de caz, trebuie să avem grijă ca toate entitățile clasei să fie statice, altfel acestea nu vor putea fi accesate vreodată.
moștenire: ce keyword folosim pentru a împiedica extinderea clasei?

                                                                    4. Crearea containerelor
                                                                
Deoarece există mai multe tipuri de containere, ne dorim implementarea unui mecanism unic prin care să generăm un nou container (gol). Un astfel de șablon de programare (eng: design pattern) este unul des utilizat în programare și se numește Factory Pattern.

Interfața comună pentru crearea de containere va fi (în cazul de față):
public interface IBagFactory {
 
  // Create a new container, according to the specified type
  IBag makeBag(String type);
}

În funcție de valoarea String-ului, se va crea o nouă colecție. Tipurile posibile corespund containerelor definite în secțiunea anterioară:

"RANDOM"
"FIFO"
"LIFO"
Existența unei interfețe pentru crearea de obiecte-container permite definirea mai multor „fabrici“ de tipuri de bag-uri, care pot fi optimizate pentru diverse constrângeri (i.e. viteza de acces, spațiul de stocare etc.). De exemplu, putem defini 2 tipuri de fabrici de obiecte:

class BagFactoryOptimizeStorage implements IBagFactory: care va construi containere optimizate pentru stocare.
class BagFactoryOptimizeAccess implements IBagFactory: care va construi containere optimizate pentru viteza de accesare a elementelor.
Implementare
În cadrul aplicației, crearea bag-ului se va face prin intermediul unei instanțe a clasei care implementează IBagFactory. Este suficient să avem un singur tip de Factory deoarece avem o singură categorie de stocare (i.e. cea bazată pe ArrayList).

                                                                    5. Împărțirea surprizelor

        5.1. Împărțirea surprizelor - mecanism abstract
În cadrul acestui task, vom implementa un mecanism de a împărți surprizele, utilizându-ne de funcționalitatea implementată anterior. Pentru aceasta, se definește clasa abstractă AbstractGiveSurprises, conform următoarelor specificații:

class AbstractGiveSurprises


Câmp	                                Descriere
un container (i.e. tolbă)	Va avea tipul în conformitate cu parametrul primit (la construire).
int waitTime	            Un timp de așteptare între distribuirea surprizelor, dat ca număr de secunde.


Constructor	                            Descriere
(…)	Constructorul va primi 2 parametri:
1. tipul containerului (i.e. unul dintre tipurile de containere definite anterior - "RANDOM", "FIFO" sau "LIFO"). Parametrul are tipul String.
2. un timp de așteptare. Utilizarea concretă a acestuia va fi explicată în continuare.

                    Funcționalitate
Metodă	                               Descriere
void put(ISurprise newSurprise)	    Adaugă o nouă surpriză în container.
void put(IBag surprises)	    Mută toate surprizele din container-ul parametru în acest container.
give()	                        Oferă o surpriză.
giveAll()	                    Oferă toate surprizele din tolbă, pe rând.
După fiecare surpriză oferită, se așteaptă un interval de timp corespunzător waitTime.
boolean isEmpty()	            Întoarce true dacă tolba este goală, false altfel.
abstract void giveWithPassion()	O metodă abstractă, care ține locul unei acțiuni ce va fi efectuată după dăruirea fiecărei surprize (ex: aplauze, o îmbrățișare etc.).
        5.2. Împărțirea surprizelor - moduri posibile
Clasa abstractă va fi extinsă de 3 tipuri de clase normale, după cum urmează:

Clasă	Detalii de moștenire
GiveSurpriseAndApplause	Va implementa metoda abstractă, afișând mesajul : Loud applause to you… For it is in giving that we receive.
GiveSurpriseAndSing	Va implementa metoda abstractă, afișând mesajul  : Singing a nice song, full of joy and genuine excitement…
GiveSurpriseAndHug	Va implementa metoda abstractă, afișând mesajul  : Warm wishes and a big hug!
