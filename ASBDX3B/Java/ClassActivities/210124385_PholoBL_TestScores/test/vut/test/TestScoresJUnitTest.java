package vut.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vut.data.TestScores;

/**
 *
 * @author benny
 */
public class TestScoresJUnitTest {

    @Test
    public void testConstructor906555() {
        TestScores testScores = new TestScores(90, 65, 55);
        assertEquals(90, testScores.getTestScore1(), 0.0);
        assertEquals(65, testScores.getTestScore2(), 0.0);
        assertEquals(55, testScores.getTestScore3(), 0.0);
    }

    @Test
    public void testConstructor559065() {
        TestScores testScores = new TestScores(55, 90, 65);
        assertEquals(55, testScores.getTestScore1(), 0.0);
        assertEquals(90, testScores.getTestScore2(), 0.0);
        assertEquals(65, testScores.getTestScore3(), 0.0);
    }

    @Test
    public void testConstructor655590() {
        TestScores testScores = new TestScores(65, 55, 90);
        assertEquals(65, testScores.getTestScore1(), 0.0);
        assertEquals(55, testScores.getTestScore2(), 0.0);
        assertEquals(90, testScores.getTestScore3(), 0.0);
    }

    @Test
    public void testMutator906555() {
        TestScores testScores = new TestScores();
        testScores.setTestScore(90, 65, 55);
        assertEquals(90, testScores.getTestScore1(), 0.0);
        assertEquals(65, testScores.getTestScore2(), 0.0);
        assertEquals(55, testScores.getTestScore3(), 0.0);

    }

    @Test
    public void testMutator559065() {
        TestScores testScores = new TestScores();
        testScores.setTestScore(55, 90, 65);
        assertEquals(55, testScores.getTestScore1(), 0.0);
        assertEquals(90, testScores.getTestScore2(), 0.0);
        assertEquals(65, testScores.getTestScore3(), 0.0);
    }

    @Test
    public void testMutator655590() {
        TestScores testScores = new TestScores();
        testScores.setTestScore(65, 55, 90);
        assertEquals(65, testScores.getTestScore1(), 0.0);
        assertEquals(55, testScores.getTestScore2(), 0.0);
        assertEquals(90, testScores.getTestScore3(), 0.0);
    }

    public void test906555() {
        TestScores testScores = new TestScores(90, 65, 55);
        testScores.setTestScore(1, testScores.getTestScore1());
        testScores.setTestScore(2, testScores.getTestScore2());
        testScores.setTestScore(3, testScores.getTestScore3());
        assertEquals(55, testScores.getSmallest(), 0.0);
        assertEquals(65, testScores.getMiddle(), 0.0);
        assertEquals(90, testScores.getLargest(), 0.0);
    }

    @Test
    public void test559065() {
        TestScores testScores = new TestScores(55, 90, 65);
        testScores.setTestScore(3, testScores.getTestScore1());
        testScores.setTestScore(2, testScores.getTestScore3());
        testScores.setTestScore(1, testScores.getTestScore2());
       
        assertEquals(55, testScores.getSmallest(), 0.0);
        assertEquals(65, testScores.getMiddle(), 0.0);
        assertEquals(90, testScores.getLargest(), 0.0);
    }

}
