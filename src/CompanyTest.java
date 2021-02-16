import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

    @Test
    void testAdd() {
        Company company = new Company();
        Employee e1 = new Employee("Last,First", "CS", "01/22/1999");
        assertTrue(company.add(e1));    //test case #1: Add an employee into an empty company.
        assertFalse(company.add(e1));   //Test case #2: Add an already existing Employee.
        Employee e2 = new Employee("First,Last", "IT", "12/12/2012");
        Employee e3 = new Employee("My,Name", "IT", "12/12/2012");
        Employee e4 = new Employee("G,M", "CS", "04/28/1999");
        Employee e5 = new Employee("S,S", "ECE", "01/01/2000");
        company.add(e2);
        company.add(e3);
        company.add(e4);
        assertTrue(company.add(e5));   //Test case #3: Add an Employee once the initial capacity has been reached and the grow() method is called.
    }

    @Test
    void testRemove() {
        Company company = new Company();
        Employee e1 = new Employee("Last,First", "CS", "01/22/1999");
        assertFalse(company.remove(e1)); //Test Case #4: Remove when there are no employees.
        company.add(e1);
        assertFalse(company.add(e1));
        assertTrue(company.remove(e1)); //Test Case #5: Remove an existing employee.
        assertFalse(company.remove(e1)); //Test Case #5: Attempt to remove the same employee twice.
    }

    @Test
    void testSetHours() {

    }
}