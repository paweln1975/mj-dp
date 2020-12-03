# mj-dp
Mastering Java - Design Patterns

# SOLID Design Principles

The object-oriented design principles are also called SOLID. These principles are a set of rules that can be applied
when designing and developing software, in order to create programs that are easy to maintain and develop. They were
first introduced by Robert C. Martin, and they are part of the agile software-development process. The SOLID principles
include:
1. Single responsibility principle
2. Open/closed principle
3. Liskov Substitution Principle
4. Interface Segregation Principle
5. Dependency inversion principle.

## SRP - Single Responsibility Principle
* A principle that states that every module, class or function in a computer program should have responsibility over a single part of that program's functionality, which it should encapsulate.
* A class should have only one reason to change (when writing Java code, we will apply this to classes)
* E.g. do not mix the business logic of a class and logic related with persistence of the objects

## OPEN - CLOSED Principle
* Modules, classes, and functions should be open for extension but closed for modifications.
* For this reason, best practice is to try to keep modules unchanged once finished and to add new functionality by extending them using inheritance and polymorphism.
* Changing already developed code cost many resources in order to test it

## LSP
* Derived types must be completely substitutable for their base types. The Liskov Substitution Principle (LSP) is strongly related to subtyping polymorphism.
* When the derived type is substituted with its supertype, the rest of the code will operate with it as it is the subtype. From this point of view, the derived type should behave as its supertype and should not break its behavior. This is called strong behavioral subtyping.
* Zasada podstawiania jest dość prosta: ZAWSZE możesz podstawić obiekt pochodny w miejsce obiektu bazowego. Innymi słowami: obiekt pochodny musi z logicznego punktu widzenia być szczególnym przypadkiem obiektu bazowego.
* Aby dziedziczenie było dobre, klasy pochodne nie powinny nadpisywać metod klas bazowych. Natomiast można je rozszerzyć, poprzez wywołanie metody z klasy bazowej, czyli klasa pochodna powinna rozszerzać klasę bazową bez wpływania na jej działanie.

## ISP
* "Clients should not be forced to depend upon interfaces that they don't use." Absolute minimum of methods in the interface.
* If the principle is broken and clients are forced to depend on interfaces they don't use, the code becomes so tightly coupled that it's almost impossible to add new functionality to it.
* Zasada mówi żeby tworzone przez programistę interfejsy były odpowiedzialne za jak najmniejsza funkcjonalność. Użytkownik chcąc zaimplementować taki interfejs nie powinien pisać metod, których nie potrzebuje. Jeśli znajdują się w nim niepotrzebne metody to wtedy nazywamy go interfejsem “fat” lub “polluted”.
*  Prawidłowe rozwiązanie polega na rozdzieleniu interfejsu na kilka części.
