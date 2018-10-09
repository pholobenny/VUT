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
public class DuplicateExeption extends Exception {

    /**
     * Creates a new instance of <code>DuplicateExeption</code> without detail
     * message.
     */
    public DuplicateExeption() {
    }

    /**
     * Constructs an instance of <code>DuplicateExeption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DuplicateExeption(String msg) {
        super(msg);
    }
}
