/**
 ManagementTest class is a JUnit test class which tests the calculatePayment() method found in the Management class.
 assertEquals() is used to test the expected value of the calculated payment which is returned through a getter.
 @author German Munguia, Sukhjit Singh
 */


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagementTest {

    @Test
    void calculatePayment() {
        Management m1 = new Management("Last,First", "CS", "1/01/2000","52000","1");
        m1.calculatePayment();
        //Test Case 1: Check the period payment of a manager with the director position with the accurate value.
        assertEquals("2192.31", String.format("%.2f", m1.getCompensationSum()));

        Management m2 = new Management("L,F", "CS", "1/01/2000","0","2");
        m2.calculatePayment();
        //Test Case 2: Check the period payment of a manager with the department head position with a salary of zero and only a bonus.
        assertEquals("365.38", String.format("%.2f", m2.getCompensationSum()));

        Management m3 = new Management("G,M", "CS", "1/01/2000","100000","3");
        m3.calculatePayment();
        //Test Case 3: Check the period payment of a manager with a director position with the accurate value.
        assertEquals("4307.69", String.format("%.2f", m3.getCompensationSum()));

    }
}