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

OPEN - CLOSED Principle
* Modules, classes, and functions should be open for extension but closed for modifications.
* For this reason, best practice is to try to keep modules unchanged once finished and to add new functionality by extending them using inheritance and polymorphism.

