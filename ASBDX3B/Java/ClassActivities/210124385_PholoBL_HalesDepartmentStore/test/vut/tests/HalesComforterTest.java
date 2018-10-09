/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.tests;

import vut.data.HalesComforters;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the calculate method for cost
 *
 * @author 210124385 Pholo BL
 */
public class HalesComforterTest {

    @Test
    public void validCostTest() {
        HalesComforters halesComforter = new HalesComforters();
        halesComforter.setCost(100);
        assertEquals(100, halesComforter.getCost(), 0.0);
    }

    @Test
    public void invalidCostTest() {
        HalesComforters halesComforter = new HalesComforters();
        try {
            halesComforter.setCost(-100);
        } catch (Exception ex) {
            assertEquals("Inavalid cost, cost should be positive:-100.0", ex.getMessage());
        }
    }

    @Test
    public void validCalculateCostTest() {
        HalesComforters hc = new HalesComforters();
        HalesComforters.Comforters comfoters = HalesComforters.Comforters.TWIN;
        double cost = hc.calculateCost(comfoters, "no");
        assertEquals(450.0, cost, 0.0);
    }

    @Test
    public void invalidCalculateCostTest() {
        HalesComforters hc = new HalesComforters();
        HalesComforters.Comforters comfoters = HalesComforters.Comforters.KING;
        try {
            double cost = hc.calculateCost(comfoters, "");
        } catch (Exception e) {
            assertEquals("Pickup/Delevery is empty", e.getMessage());
        }

    }
}
