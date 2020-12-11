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
5. Dependency Inversion Principle.

## SRP - Single Responsibility Principle
* A principle that states that every module, class or function in a computer program should have responsibility over a single part of that program's functionality, which it should encapsulate.
* A class should have only one reason to change (when writing Java code, we will apply this to classes)
* Different classes handle different independent tasks/problems
* E.g. do not mix the business logic of a class and logic related with persistence of the objects

## OPEN - CLOSED Principle
* Modules, classes, and functions should be open for extension but closed for modifications.
* For this reason, best practice is to try to keep modules unchanged once finished and to add new functionality by extending them using inheritance and polymorphism.
* Changing already developed code cost many resources in order to test it

## LSP
* Derived types must be completely substitutable for their base types. The Liskov Substitution Principle (LSP) is strongly related to subtyping polymorphism.
* When the derived type is substituted with its supertype, the rest of the code will operate with it as it is the subtype. From this point of view, the derived type should behave as its supertype and should not break its behavior. This is called strong behavioral subtyping.
* Można podstawić typ bazowy zamiast typu pochodnego. Innymi słowami: obiekt pochodny musi z logicznego punktu widzenia być szczególnym przypadkiem obiektu bazowego.
* Aby dziedziczenie było dobre, klasy pochodne nie powinny nadpisywać metod klas bazowych. Natomiast można je rozszerzyć, poprzez wywołanie metody z klasy bazowej, czyli klasa pochodna powinna rozszerzać klasę bazową bez wpływania na jej działanie.

## ISP
* "Clients should not be forced to depend upon interfaces that they don't use." Absolute minimum of methods in the interface.
* If the principle is broken and clients are forced to depend on interfaces they don't use, the code becomes so tightly coupled that it's almost impossible to add new functionality to it.
* Zasada mówi żeby tworzone przez programistę interfejsy były odpowiedzialne za jak najmniejsza funkcjonalność. Użytkownik chcąc zaimplementować taki interfejs nie powinien pisać metod, których nie potrzebuje. Jeśli znajdują się w nim niepotrzebne metody to wtedy nazywamy go interfejsem “fat” lub “polluted”.
*  Prawidłowe rozwiązanie polega na rozdzieleniu interfejsu na kilka części.

## DIP
* A. "High-level modules should not depend on low-level modules. Both should depend on abstractions (abstract class or interface)."
* B. "Abstractions should not depend on details. Details should depend on abstractions."
* Kod z warstw z wyższego poziomu nie powinien zależeć od kodu z niższych warstw. Obie warstwy za to powinny być zależne od abstrakcji. Abstrakcje nie powinny zależeć od szczegółów (konkretnej implementacji). Z kolei szczegóły (implementacja) powinna zależeć od abstrakcji.
* Najlepiej rozważyć to na przykładzie aplikacji enterprise. Kodem z niższej warstwy może być np. DAL (warstwa dostępu do danych) a  z wyższej – warstwa biznesowa. Według zasady, warstwa biznesowa nie może zawierać bezpośrednio referencji do DAL. Wyobraźmy sobie, że pewnego dnia zmienia się dostawca warstwy dostępowej (np. z Hibernate na inny Framework). Wtedy warstwa wyższego poziomu (biznesowa) musi również zostać zaktualizowana. Ponadto ze względu na zmianę kodu ponownie należy przetestować klasę. Zgodnie z zasadą kod powinien być zależny wyłącznie od abstrakcji a nie szczegółów.


# Design Patterns

# Creational 

### Builder
* motivation: creating object with 10 arguments constructor is not good idea
* allow constructing object piece by piece by providing special API (building object in several steps)
* examples in Java: StringBuilder
* ofter implemented with fluent interface by using method chaining (each Builder method returns the reference to the Builder itself)
* the object to be constructed has a private constructor available only for the builder
* A builder is a separate component for building an object
* Can either give builder a constructor or return it via static function
* To make a builder fluent return this
* Different facets of the objects can be built with different builders working in tandem via base class

### Factory
* motivation: object creation logic is too complicated
* cannot change the constructor name or overload it with the same arguments
* component responsible for whole object creation via single call (not piece by piece like Builder)
* Factory method (usually static that creates that object)
* separate class (Factory - external or inner class which has access to private members or constructors)
* can create a hierarchy of factories with Abstract Factory (to create a hierarchy of objects)

### Prototype
* motivation: object copying (clone) and customize
* an existing object is Prototype and via convenient API (e.g. Factory)
* possiblites of copying: deep copy (copy constructors) or via serialization

### Singleton
* motivation: it makes sense to have only one instance of a class within the systems e.g. Database, Object Factory 
* it could easily broken via reflection or serialization/deserialization 
* there are different possible implementation (based of double lock, with lazy initialization or by use of inner static class  ) 
* it's good idea not to depend on singleton, it's better to depend on abstraction

## Structural

### Adapter
* motivation: a construct which adapts in existing interface X to conform to the required interface Y
* adapter is a component which aggregates (has reference to...) the adaptee
* all is about is connecting two incompatible interfaces, converting call of one interface into another 
* there are two approaches – class adapter (use inheritance) and object adapter (use composition)
* if you implement an adapter pattern you probably create bunch of temporary objects, to avoid extra generation of these objects implement a cache (performace optimization)

### Bridge
* motivation: avoids entity explosion ('Cartesian product')
* decouples interface hierarchy from implementation hierarchy
* connecting components through abstraction
* it's stronger form of encapsulation

### Composite
* motivation: allows treating objects both scalar and composite in the same fashion
* it's composition of objects e.g. group of shapes made of several shapes
* Shape and List<Shape> have the same API
* Java gives container iteration with Iterable<T> interface (single objects return single element collection containing only this) 
 
### Decorator
* motivation: adding additional functionality (SRP) to an existing class without altering it (OCP)
* to be able to interact with existing structures (keeps the reference to decorated object)
* two option: inherit or build a decorator

### Facade
* motivation: many systems working together are hidden behind a simple and easy to use API 
* exposing several components through a single interface
* 

## Behavioral  
