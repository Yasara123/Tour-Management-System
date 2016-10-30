/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.im.model;

import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Yas
 */
public class DriverManipulationNGTest {
    
    public DriverManipulationNGTest() {
    }


    /**
     * Test of getDriver method, of class DriverManipulation.
     */
    @Test
    public void testGetDriver() {
        System.out.println("getDriver");
        String tourCode = "102";
        DriverManipulation instance = new DriverManipulation();
        List expResult = null;
        List result = instance.getDriver(tourCode);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoach method, of class DriverManipulation.
     */
    @Test
    public void testGetCoach() {
        System.out.println("getCoach");
        DriverManipulation instance = new DriverManipulation();
        List expResult = null;
        List result = instance.getCoach();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmTour method, of class DriverManipulation.
     */
    @Test
    public void testConfirmTour() {
        System.out.println("confirmTour");
        DriverManipulation instance = new DriverManipulation();
        instance.confirmTour();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTour method, of class DriverManipulation.
     */
    @Test
    public void testGetTour() {
        System.out.println("getTour");
        DriverManipulation instance = new DriverManipulation();
        List expResult = null;
        List result = instance.getTour();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
