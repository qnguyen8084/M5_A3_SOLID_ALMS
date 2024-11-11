# SOLID ESSAY


## PLAN

To start of with the refactoring effort to make the code base more SOLID, I will start with first reading
the guidelines from the book Adaptive Code by Gary McLean Hall. This would allow me to have a better
understanding of the SOLID design principles as well as be able to leverage the examples given in the
book and apply those techniques to our code base. Before making any changes we will have to get a framework
in place where we can check if our application still functions and there are no unexpected side effects
from our code changes. This is where our unit tests will play a big role. We will first have to evaluate
the unit tests and see if they are comprehensive and provides enough coverage.

Single Responsibility Principle
Understand the importance of single responsibility
Identify classes with too many responsibilities
Refactor those classes into smaller classes with single responsibilities with the use of design patterns
Use of decorator and Composite

Open/Closed Principle
Understand the importance of open/closed
open for extension, closed for modification
identifying areas that may be changed in the future
don't bother with effort if it may never be extended in the future
abstract classes and interfaces to separate client from ...
template method pattern used
interface > implementation inheritance = more adaptability
composition over inheritance

Liskov substitution principle
Rule broken if new subclass requires changes to any client of the base class or interface
If no changes to interface there should ne no need to change any existing code
LSP enforces SRP and OCP
*If S is subT of T, then obj of type T may be replaced with object of type S*
Base type: type(T) the clients have reference to. Clients call various mehthods and subtype of T
may override these methods if specialization needed
Subtype: Client should not know specifics about subtype and should behave the same no matter what
subtype instance that is given.
Context: The way the client interacts with the subtype.

LSP rules
 




Golden master test

TODO: Add error handling and consistency in user prompts (Slighlty detracts from overall quality)
TODO: Incorporating error handling within the methods—for instance, notifying users of any mistakes when they enter an invalid book ID or member ID, rather than allowing the program to crash.
TODO: minor issues with variable naming inconsistencies
TODO: areas where modularity could be enhanced

Changes made so far

Consolidated Employee and Member classes into User class file
Consolidate Book and Magazine classes into LibraryItem class file
Remove FetchId interface from User.java
Add id variables to User and have Member and Employee override getId() methods

Separate database operations from business logic for SRP
Broke down transactions interface into seperate interfaces