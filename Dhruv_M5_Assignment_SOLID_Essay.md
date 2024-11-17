


**Dhruv Sandip Shah**  

**CS635 - Advanced Object-Oriented Design & Programming**  

**Dr. Magda Tsintsadze**  

## Module 5 Assignment: Assignment 3: SOLID Principle Application  

# SOLID ESSAY 

### Single Responsibility Principle (SRP)  
The classes "DBBookManager", "DBUserManager", and "DBLoanManager each focus on specific responsibilities such as managing books, users, and loans. To further refine SRP, I split the "DBLoanManager" into two classes—"LoanService" and "LoanDAO". This separation ensures that business logic and database operations are handled independently, making the code more maintainable and focused.  

### Open/Closed Principle (OCP)  
I applied OCP by making the system extensible without modifying the core classes. Abstract classes like "User" and "LibraryItem" allow new subclasses to be added, extending their functionality without altering the existing codebase. Additionally, interfaces like "BookOperations" and "LoanOperations" provide a framework for implementing new operations without changing existing implementations.  

### Liskov Substitution Principle (LSP)  
The project adheres to LSP by ensuring that derived classes can be substituted wherever base classes are used. For example, "BookOperations" and "MemberOperations" are implemented by concrete classes such as "BookConsoleAdapter" and "MemberConsoleAdapter", allowing for seamless substitution without affecting program behavior.  

### Interface Segregation Principle (ISP)  
We followed ISP by creating smaller, client-specific interfaces. For instance, "Addable", "Removable", and "Searchable" interfaces are implemented by "DBBookManager", "DBUserManager", and "DBLoanManager". These interfaces are designed to handle specific needs, allowing clients to implement only the methods they require, which reduces unnecessary dependencies.  

### Dependency Inversion Principle (DIP)  
DIP was applied through the use of interfaces and dependency injection. By defining abstractions like "BookOperations", "LoanOperations", and "SearchOperations", and injecting them into classes such as "DBBookManager" and "DBConsoleAdapter", I decoupled the higher-level modules from the low-level modules. This makes the system more flexible and easier to test, as dependencies can be injected and modified without altering the core logic.  

### Challenges and Reflections  
Initially, We underestimated the complexity of refactoring the project to follow SOLID principles. While the code was functional, applying SOLID made the system more adaptable and modular but also more complex. We had to reconsider parts of the code, such as error handling and interface design. Splitting interfaces like Transaction into smaller ones initially seemed unnecessary, but it improved flexibility and maintainability. The separation of database and console operations, although not fully completed for all components, is an ongoing improvement that will further enforce SRP.  

While implementing SOLID principles improved code modularity and maintainability, it also increased complexity. For example, separating the database logic and implementing smaller interfaces made the code harder to follow initially. However, this approach promotes better decoupling, allowing for easier updates and more flexible code in the future. The main area for improvement is fully separating the business logic from database operations, which would further enhance SRP.  

### Conclusion  
Refactoring the system to adhere to SOLID principles significantly enhanced its maintainability, flexibility, and adaptability. The separation of concerns and clear abstractions provide a cleaner and more modular design, ensuring that future modifications can be made with minimal impact on the existing codebase.  

Although there is still work to be done, especially in separating business logic from database operations, the project is more robust and adaptable than before.  

Overall, the project functions like it did before with the added search functionality to search member by name, book by title, loan by loan id, improved error handling for invalid user input, more modularized, more decoupled, and more adaptive code while also adhering to SOLID design principles.
