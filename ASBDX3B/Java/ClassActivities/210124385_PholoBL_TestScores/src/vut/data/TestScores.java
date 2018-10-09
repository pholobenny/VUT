/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.data;

/**
 *
 * @author benny
 */
public class TestScores {

    private double testScore1;
    private double testScore2;
    private double testScore3;

    public TestScores() {
    }

    /**
     * Constructs an object that processes three scores.
     *
     * @param testScore1 the first test score to store
     * @param testScore2 the second test score to store
     * @param testScore3 the third test score to store
     */
    public TestScores(double testScore1, double testScore2, double testScore3) {
        this.setTestScore1(testScore1);
        this.setTestScore2(testScore2);
        this.setTestScore3(testScore3);
    }

    /**
     * Store a new testScore
     *
     * @param position The position of the score, 1, 2 or 3
     * @param The testScore to store
     */
    public void setTestScore(int position, double testScore) {
        System.out.println("Pos:"+position +" Score:"+testScore);
        
        if (position == 1) {
            testScore1 = testScore;
        } else if (position == 2) {
            testScore2 = testScore;
        } else {
            testScore3 = testScore;
        }
    }

    /**
     * Constructs an object that processes three scores.
     *
     * @param testScore1 the first test score to store
     * @param testScore2 the second test score to store
     * @param testScore3 the third test score to store
     */
    public void setTestScore(double testScore1, double testScore2, double testScore3) {
        this.testScore1 = testScore1;
        this.testScore2 = testScore2;
        this.testScore3 = testScore3;
    }

    public void setTestScore1(double testScore1) {
        this.testScore1 = testScore1;
    }

    public void setTestScore2(double testScore2) {
        this.testScore2 = testScore2;
    }

    public void setTestScore3(double testScore3) {
        this.testScore3 = testScore3;
    }

    /**
     * Return the first score stored
     *
     * @return the first score stored
     */
    public double getTestScore1() {
        return testScore1;
    }

    /**
     * Return the second test score stored
     *
     * @return the second test score stored
     */
    public double getTestScore2() {
        return testScore2;
    }

    /**
     * Return the third test score stored
     *
     * @return the third test score stored
     */
    public double getTestScore3() {
        return testScore3;
    }

    /**
     * Gets the smallest of the three numbers stored.
     *
     * @return the smallest of the three numbers stored.
     */
    public double getSmallest() {
        return testScore3;
    }

    /**
     * Gets the largest of the three test scores stored.
     *
     * @return the largest of three test scores
     */
    public double getLargest() {
        return testScore1;
    }

    /**
     * Gets the middle of the three test scores stored.
     *
     * @return the middle of the three test scores stored.
     */
    public double getMiddle() {
        return testScore2;
    }
}
