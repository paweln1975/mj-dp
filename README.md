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
* allows constructing object piece by piece by providing special API (building object in several steps)
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
* possibilities of copying: via a deep copy (copy constructors) or via serialization

### Singleton
* motivation: it makes sense to have only one instance of a class within the systems e.g. Database, Object Factory 
* it could easily broken via reflection or serialization/deserialization 
* there are different possible implementation (based of double lock, with lazy initialization or by use of inner static class  ) 
* it's a good idea not to depend on a singleton, it's better to depend on abstraction

## Structural

### Adapter
* motivation: a construct which adapts in existing interface X to conform to the required interface Y
* adapter is a component which aggregates (has reference to...) the adaptee
* all is about is connecting two incompatible interfaces, converting call of one interface into another 
* there are two approaches – class adapter (use inheritance) and object adapter (use composition)
* if you implement an adapter pattern you probably create a bunch of temporary objects, to avoid extra generation of these objects implement a cache (performace optimization)

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
* exposing several components through a single interface (API)  
* provide a single API over set of classes

### Flyweight
* motivation: Avoid redundancy when storing data
* store the data externally and use pointers (index) or operate on ranges
* space optimization technique that let us use less memory by storing externally the data associated with similar objects

### Proxy
* motivation: an interface for accessing a particular resource
* proxy allows using the same interface but different behaviour
* communication proxy - accessing the remote resource
* proxy is a class that functions as interface to particular resource. That resource may be remote, expensive to construct, or may required logging or other added functionality
* proxy vs decorator: proxy provides an identical interface while decorator provides an enhanced interface, decorator aggregates (or has reference to) what it is decorating; proxy doesn't have to
* proxy has the same interface as underlying object

## Behavioral  

### Chain of Responsibility
* motivation: to have a chain of components which all get a chance to process command, query or event, optionally have a default processing implementation and ability to terminate the processing chain
* command - asking for action (changing sth), query - asking for information (getting values)
* Command Query Separation (CQS) - having separate means of sending commands and queries
* implemented as chain of references or as chain or centralized construct
* possible control of the object order in the chain or object removal from the chain (e.g. AutoClosable close())

### Command
* motivation: to have an object that represents an operation (instructions to perform a particular action)
* usage: GUI commands, undo/redo/macro recording
* encapsulation all details of an operation in a separate object
* define instructions for applying the command and optionally define instructions for undoing the command
* can create macros (composite commands)

### Interpreter
* motivation: a component that processes structured text data
* turning them into separate lexical tokens (lexing) and then interpreting sequences of said tokens (parsing)
* first stage is lexing stage: turning the text into set of tokens e.g. 3 * (3 + 5) --> Lit(3) LP Lit(3) Plus Lit(5) RP
* second stage is parsing tokens into a meaningful construct --> Multiplication(Integer(3), Addition(Integer(3), Integer(5)))

### Iterator
* helps to travers of data structures
* An Iterator is a class that facilitates the traversal
* Java has Iterator<T> and Iterable<T> (for loops), Iterator implements Iterator<T>, class of objects that meant to be iterable implements Iterable<T>
* Iterator cannot be recursive

### Mediator
* motivation: facilities communication between components without them being aware of each other or having direct references to each other
* e.g. users in a chat room
* all components have reference to some central component with help with the communications (they may go in or out of the system at any time)
* create a mediator and each object has reference to it
* engage the mediator in a bidirectional communication between connected components
* mediator has a function that components can call (broadcast)
* the components have a function that mediator can call (receive an event)
* e.g. use JavaRx library (reactive event extensions)

### Memento
* motivation: to keep a sort of token/handle (returned by a method) then to allow to return an object with particular state
* The token represents the system state and then allows us to roll back the state of the system to the moment when the token was generated
* May or may not directly expose state information (typically the token is immutable)
* generally used for the rollback the system changes by restoring the system state store in a memento token/handle
* a memento is not required to expose the system state
* could be used to implement undo/redo operation

### Null Object
* motivation: a non-operating object that replaces check of NULL object instance
* Instead of putting if check for a null value, Null Object reflects a "do nothing relationship"
* Such Null object can also be used to provide default behaviour in case data is not available
* implement an interface and implement methods with empty bodies, supply Null Object in place of an actual object

### Observer
* motivation: we need to be informed when certain things happen
* we want to listen to events and to be notified when they occur (typical Java pattern: addXXXListener())
* Java now has a functional objects: *Supplier\<T\>*, *Consumer\<T\>*, *Function\<T\>*
* An observer is an object that wishes to be informed about event, and an observable is an entitity generating event
* An observer must provide an event to subscribe (be carefull in mulitithreading)
* Observer and Observable are deprecated in Java, use RxJava library (very similiar)

### State
* motivation: object behaviour is determined by its state
* an object transitions from one state to the other (something triggers the transition)
* change can be explicit or in response to an event
* the construct which manages the state and transitions we call state machine
* define possible states and events/triggers (plus state entry, exit criteria, actions when a particular event causes transition, guard conditions enabling/disabling a transition, default transition when no action found for the event)

### Strategy
* motivation: define part of the system behavior (e.g. high level algorithm which can be reused) and the exact behavior may be defined at the run-time (dynamic) or compile-time (static)
* define an interface you expect each strategy will follow
* provide dynamic or either static strategy composition into the overall algorithm

### Template method
* motivation: algorithm can be composed into common parts + specifics, similar to Strategy pattern
* Template method pattern does a similar thing to Strategy pattern but through inheritance
* overall algorithm make use of abstract member and inheritors override the abstract methods
* allows to define the 'skeleton' of the algorithm (in an abstract class) with concrete implementations in the subclasses

### Visitor
* motivation: allows adding na extra behavior to the entire hierarchy of class
* we do not want to modify the whole hierarchy, we want to avoid type checks, we need access to non-common aspects of classes
* this is the pattern where a component (visitor) traverses the entire inheritance hierarchy
* implemented by propagating a single *accept(Visitor v)* method throughout the entire hierarchy
* create a visitor for each element in the hierarchy
* each *accept()* simply calls *visitor.visit(this)*
* possible different approaches of implementation: Intrusive, Reflective, Classic (Double Dispatch) and Acyclic (with ISP)
* Acyclic gives the greatest flexibility at a cost to performance (type checking of the visitor)

