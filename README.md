*Băroiu Andrei 322CB 2022-2023*

# README PROIECT POO

## Design Patterns implementate:
   * Singleton
   * Factory
   * Facade
   * Command
   * Iterator

## Explicare structura program:
    * ProiectPOO.main face apeluri doar la metodele din clasa Facade
    * Parser face parsarea din fisierul de comenzi
    * Database este clasa Singleton care contine toate datele din program
    * RequestHandler este clasa care realizeaza operatiile cerute de comenzi
    * Parser creeaza prin factory comenzile si le trimite la Facade
    * Facade executa comenzile
    * Comenzile prin execute apeleaza metodele din RequestHandler


## Explicare implementare design patterns:
    * Singleton
        > Am optat să folosesc Singleton pentru Database, RequestHandler, Facade, Parser
        deoarece nu am nevoie de mai mult de un obiect din fiecare tip

    * Facade
        > Am folosit Facade pentru a ascunde complexitatea programului
        > Clasa Facade realizeaza legatura dintre Parser si RequestHandler prin
        apelul comenzilor stocare ca lista in aceasta clasa.

    * Command
        > Deoarece programul se bazează pe input-ul primit sub formă de
        comandă, am considerat că acest design pattern este cel mai potrivit pentru
        crearea unei structuri clare în program.
        > Parser este client, Facade este invoker iar RequestHandler este receiver

    * Factory
        > Am folosit Factory pentru a crea obiectele de tip Command

    * Iterator
        > La task-urile cu recommend și surprise am considerat că utilizarea unui iterator
        pentru a traversa map-urile în ordinea dorită este cea mai potrivită soluție.



