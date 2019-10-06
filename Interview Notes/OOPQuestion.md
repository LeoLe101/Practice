# OOP INTERVIEW NOTE
## Interview Questions for OOP
1. What is a Class?
    - A Class is a representation of a type of object. It is the blueprint/plan/template that describe the details of an object.

1. What is an Object?
    - Object is termed as an instance of a class, and it has its own state, behaviour and identity

1. What is Encapsulation?
    - Encapsulation is an attribute of an object, and it contains all data which is hidden. That hidden data can be restricted to the members of that class. (For Ex: Banking System want to hide Card number of the amount of money inside of the owner account from other people)
    - Levels: Public, Private, Protected.









<!-- ########### UNDERSTANDING OOP ########### -->
# Basic concepts of Object Oriented Programming:
## Abstraction:
- Abstraction enable to use multiple inheritance, with the access of abstraction can hide important data and show only important data to show user.

## Polymorphism:
Use one form into multiple forms.

## Encapsulation:
- Encapsulation is a subset of abstraction that can restrict user to show data with the use of encapsulation.

## Inheritance:
- While we are using inheritance, there are two main parts one is derived class and other one is base class. Inheritance provides to capable our application to reuse code and reduce code size.

## Difference between Private, Protect, Public:
- Private: Private can only be used in the current Class where it is initialized. All
  other functions from the current class can call these Private variables/methods. Other classes/packages cannot call the Private variables/methods from this class.

- Public: Public variable is available for every single class/packages/world/sub-class from a different package, as well 
  as sub-class in the same package.

- Protected: Protected variables/methods are almost similar to what the Public variables/methods are. However, Protected
  variables/methods are not available for World (which is other people from outside the project)

## What is Static Keyword:
- Usually mean relating to the type itself, rather than an instance of that type
- If it is a static class then it cannot be instantiated and can only contain static member in the class.
- Static class always derive from object, can't specify a different base type
- Static calss cannot implement an interface
- Static class cannot instance members
- Static class cannot declare constructor and compiler doesn't create a default constructor by default
- Static class is implicitly an abstract class
- Static class can be generic, nested in either non-static or static classes

# Reference: 
- OOP for C# https://www.code-sample.com/2015/04/oops-concepts-object-oriented.html
- OOP concepts https://beginnersbook.com/2013/03/oops-in-java-encapsulation-inheritance-polymorphism-abstraction/
- Interface vs Abstract in Java https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/
- Multiple inheritances in Java https://beginnersbook.com/2013/05/java-inheritance-types/
- Developement Environment setup for Mac https://sourabhbajaj.com/mac-setup/References/
- 