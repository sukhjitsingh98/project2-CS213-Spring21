/**
 CompanyTest class is a JUnit test class which tests the add(), remove(), and setHours() methods found in the Company class.
 The return values of the classes can be compared using assertTrue() and assertFalse().
 @author German Munguia, Sukhjit Singh
 */


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

    @Test
    void testAdd() {
        Company company = new Company();
        Employee e1 = new Employee("Last,First", "CS", "01/22/1999");
        assertTrue(company.add(e1));    //Add test case #1: Add an employee into an empty company.
        assertFalse(company.add(e1));   //Add Test case #2: Add an already existing Employee.
        Employee e2 = new Employee("First,Last", "IT", "12/12/2012");
        Employee e3 = new Employee("My,Name", "IT", "12/12/2012");
        Employee e4 = new Employee("G,M", "CS", "04/28/1999");
        Employee e5 = new Employee("S,S", "ECE", "01/01/2000");
        Employee e6 = new Employee("Last,First", "CS", "04/26/2000");
        company.add(e2);
        company.add(e3);
        company.add(e4);
        assertTrue(company.add(e5));   //Add Test case #3: Add an Employee once the initial capacity has been reached and the grow() method is called.
        //Add Test Case #4: Add employee with the same name and department as e1 but different date hired.
        assertTrue(company.add(e6));
        Employee e7 = new Management("some,Name", "ECE", "10/12/2021", "45000","2");
        assertTrue( company.add(e7)); //Add Test case #4: Add an normal Employee of Management instance type.

        Employee e8 = new Fulltime("myLast, myFirst", "CS", "11/1/2021", "1000000");
        assertTrue(company.add(e7)); //Add Test case #4: Add an normal Employee of Fulltime instance type.
    }

    @Test
    void testRemove() {
        Company company = new Company();
        Employee e1 = new Employee("Last,First", "CS", "01/22/1999");
        assertFalse(company.remove(e1)); //Remove Test Case #1: Remove when there are no employees.
        company.add(e1);
        assertFalse(company.add(e1));
        assertTrue(company.remove(e1)); //Remove Test Case #2: Remove an existing employee.
        assertFalse(company.remove(e1)); //Remove Test Case #3: Attempt to remove the same employee twice.

        Employee e2 = new Employee("Last,First", "CS", "04/26/2000");
        company.add(e2);
        //Remove Test Case #4: Remove employee with the same name and department as e1 but different date hired.
        assertTrue(company.remove(e2));
    }

    @Test
    void testSetHours() {
        Company company = new Company();
        Employee e1 = new Parttime("Last,First", "CS", "01/22/1999","10","0");
        assertFalse(company.setHours(e1)); //SetHours Test Case #1: Attempt to setHours of an non-existing employee.

        company.add(e1);
        assertTrue(company.setHours(e1)); //SetHours Test Case #2: Set the hours to the minimum value.

        Employee e2 = new Parttime("L,F", "CS", "01/22/1999","10","-1");
        company.add(e2);
        assertFalse(company.setHours(e2)); //SetHours Test Case #3: Set the hours below the minimum value.

        Employee e3 = new Parttime("G,M", "CS", "01/22/1999","10","100");
        company.add(e3);
        assertTrue(company.setHours(e3)); //SetHours Test Case #4: Set the hours to the maximum value.

        Employee e4 = new Parttime("S,S", "CS", "01/22/1999","10","101");
        company.add(e4);
        assertFalse(company.setHours(e4)); //SetHours Test Case #5: Set the hours above the maximum value.
    }
}
