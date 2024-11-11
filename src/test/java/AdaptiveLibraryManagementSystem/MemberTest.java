package AdaptiveLibraryManagementSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    // Test case to verify the getName() method for a Member object
    @Test
    void testGetNameForMember() {
        Member member = new Member("John Doe"); // Creating a new member with the name "John Doe"
        assertEquals("John Doe", member.getName()); // Asserting that getName() returns the correct name
    }

    // Test case to verify the getId() method for a Member object initialized with an ID
    @Test
    void testGetIdForMemberWithId() {
        Member member = new Member("John Doe", 999); // Creating a new member with ID 999
        assertEquals(999, member.getId()); // Asserting that getId() returns the correct ID
    }

    // Test case to verify the getName() method for an Employee object
    @Test
    void testGetNameForEmployee() {
        Employee employee = new Employee("Jane Doe"); // Creating a new employee with the name "Jane Doe"
        assertEquals("Jane Doe", employee.getName()); // Asserting that getName() returns the correct name
    }

    // Test case to verify the getId() method for an Employee object initialized with an ID
    @Test
    void testGetIdForEmployeeWithId() {
        Employee employee = new Employee("Jane Doe", 999); // Creating a new employee with ID 999
        assertEquals(999, employee.getId()); // Asserting that getId() returns the correct ID
    }
}
