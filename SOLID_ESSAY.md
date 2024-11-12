# Quy Nguyen
# CS635 - Advanced Object-Oriented Design & Programming
# Dr. Magda Tsintsadze
# Module 5 Assignment: Assignment 3: SOLID Principle Application


## SOLID ESSAY

### Single Responsibility Principle
There are several classes in my project that demonstrate the Single Responsibility Principle. DBBookManager,
DBUserManager, and DBLoanManager classes are responsible for managing operations such as adding, removing,
listing, and searching for books, users, or loans respectively.
DBConsoleAdapter is a class has the single responsibility for adapting the console operations to database operations.

### Open/Closed Principle
My project demonstrates the Open/Closed Principle by having classes that are open for extension but closed for
modification. These abstract classes are User and LibraryItem. They can be extended to add new types of Users
and LibraryItems with new attributes and methods without modifying the base classes themselves. This allows
for extensibility of the code.
My project also demonstrates the Open/Closed Principle by having interfaces that are open for extension but closed
for modification. The existing interfaces can be implemented by new classes to add new functionality without
changing the existing code, promoting extensibility.

### Liskov Substitution Principle
This project demonstrates the Liskov Substitution Principle with the ability to substitute a base class with a derived
class as well as the being able to substitute an interface with a class that implements that interface.
In my project the base classes User and LibraryItem may be substituted wherever a derived class is expected if they
weren't defined as abstract classes.

The interfaces in my project; BookOperations, MemberOperations, LoanOperations, HistoryOperations, and SearchOperations
implemented by concrete classes BookConsoleAdapter, MemberConsoleAdapter, LoanConsoleAdapter, HistoryConsoleAdapter,
and SearchConsoleAdapter. In my implementation the <class>ConsoleAdapter can be substituted wherever <class>Operations
is expected without affecting the behavior of the program demonstrating the Liskov Substitution Principle.

### Interface Segregation Principle
My project demonstrates the adherence to the Interface Segregation Principle by having many small interfaces
that are specific to a single client as well as general interfaces that are implemented by many classes.
Some of the general interfaces are Addable, Removable, Searchable, Listable. These interfaces are implemented
by DBBookManager, DBUserManager, and DBLoanManager classes. These small interfaces promoted decoupled code, 
testability, adaptability, and maintainability. This also allows classes/clients to only implement the methods
that they need.
The client specific interfaces in this project are BookOperations, MemberOperations, and LoanOperations.
The interfaces are specific and deal with class specific operations. This ensures that client classes do not
implement interfaces they don't need.

### Dependency Inversion Principle
The current version of my project demonstrates the Dependency Inversion Principle by the use of interfaces as well
as dependency injection.

My project defines many interfaces which are listed below:
BookOperations, MemberOperations, LoanOperations, HistoryOperations, SearchOperations
ConsoleBookOperations, ConsoleMemberOperations, ConsoleLoanOperations, ConsoleHistoryOperations, ConsoleSearchOperations
Addable, Removable, Searchable, Listable
These interfaces provide abstractions that are implemented concrete classes. The use on many interfaces promotes
decoupled code and allows for easier testing and maintenance.

Dependency injection is used in several classes to inject dependencies. You can see that in DBBookManager,
DBUserManager, and DBLoanManager classes were DBHistoryLogger is injected into the constructor promoting
testability and flexibility.
Dependency injection is also used in DBConsoleAdapter where BookOperations, MemberOperations, LoanOperations,
HistoryOperations, and SearchOperations are injected into the constructor adhering to the Dependency Inversion
Principle.

### Conclusion
When starting this assignment to refactor our previous project to adhere to SOLID principles I believed it
would not be so difficult. A lot of the program was already solid, however there were a few things lacking
such as error handling when receiving invalid user input, which has been added. I split up the Transactions
interface into four smaller interfaces to demonstrate the Interface Segregation Principle. I thought this was
completely unnecessary as the interface worked very well with our schema. 
It seemed like the more I worked on applying SOLID principles, the code became more complex and a bit more
difficult to follow. However, the changes promoted more decoupled code and adaptability. For example, you may
make changes to the History logger if you don't like the current implementation thanks to the use of 
dependency inversion principle.

The entirety of the project was not refactored completely to adhere to SOLID principles. I think I may have
already breached the threshold of complexity with some portions of the code. 