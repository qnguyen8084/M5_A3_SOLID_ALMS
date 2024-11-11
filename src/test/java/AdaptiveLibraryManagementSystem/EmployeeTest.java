package AdaptiveLibraryManagementSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The EmployeeTest class contains unit tests for the Employee class.
 * It verifies the behavior of Employee constructors and methods such as getId() and getName().
 */
class EmployeeTest {

    /**
     * Test the Employee constructor that only accepts a name, and ensure the ID defaults to 0.
     */
    @Test
    void testEmployeeIdWithConstructor1() {
        Employee employee = new Employee("TestUser");  // Create an Employee with name only
        assertEquals(0, employee.getId());  // Verify the ID is 0 (default)
    }

    /**
     * Test the Employee constructor that accepts both an employee ID and a name, 
     * and ensure the ID is set correctly.
     */
    @Test
    void testEmployeeIdWithConstructor2() {
        Employee employee = new Employee("TestUser", 10);  // Create an Employee with ID and name
        assertEquals(10, employee.getId());  // Verify the ID is correctly set to 10
    }

    /**
     * Test the Employee constructor that only accepts a name, and ensure the name is set correctly.
     */
    @Test
    void testEmployeeNameWithConstructor1() {
        Employee employee = new Employee("TestUser");  // Create an Employee with name only
        assertEquals("TestUser", employee.getName());  // Verify the name is correctly set to "TestUser"
    }

    /**
     * Test the Employee constructor that accepts both an employee ID and a name, 
     * and ensure the name is set correctly.
     */
    @Test
    void testEmployeeNameWithConstructor2() {
        Employee employee = new Employee("TestUser1", 10);  // Create an Employee with ID and name
        assertEquals("TestUser1", employee.getName());  // Verify the name is correctly set to "TestUser1"
    }
}
