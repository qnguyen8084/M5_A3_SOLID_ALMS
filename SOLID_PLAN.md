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

Liskov substitution principleq





Golden master test

TODO: Add error handling and consistency in user prompts (Slighlty detracts from overall quality)
TODO: Incorporating error handling within the methods—for instance, notifying users of any mistakes when they enter an invalid book ID or member ID, rather than allowing the program to crash.
TODO: minor issues with variable naming inconsistencies
TODO: areas where modularity could be enhanced