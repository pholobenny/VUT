/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.JUnitTest;

import java.awt.image.BandCombineOp;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vut.data.BankAccount;

/**
 *
 * @author Pholo Benny (210124385)
 */
public class BankAccountTest {

    @Test
    public void testConstructor() {
        BankAccount ba = new BankAccount(5000, 1001, "Sipho Tree", BankAccount.accountType.CHECK, "0679990000");
        assertEquals(ba.getAmount(), 5000, 0.1);
        assertEquals(ba.getAccount_owner(), "Sipho Tree");
        assertEquals(ba.getAccount_Type(), ba.account_type.CHECK);
        assertEquals(ba.getContact_number(), "0679990000");
    }

    @Test
    public void testsetAccNoMutator1088() {
        BankAccount ba = new BankAccount();
        ba.setAccount_number(1088);
        assertEquals(ba.getAccount_number(), 1088);
    }

    @Test
    public void testsetAccNoMutator2001() {
        BankAccount ba = new BankAccount();
        ba.setAccount_number(2001);
        assertEquals(ba.getAccount_number(), 2001);
    }

    @Test
    public void testsetAccNoMutator1015() {
        BankAccount ba = new BankAccount();
        ba.setAccount_number(1015);
        assertEquals(ba.getAccount_number(), 1015);
    }

    @Test
    public void testsetAccNameMutatorMduduzi_Nhlapo() {
        BankAccount ba = new BankAccount();
        ba.setAccount_owner("Mduduzi Nhlapo");
        assertEquals(ba.getAccount_owner(), "Mduduzi Nhlapo");
    }

    @Test
    public void testsetAccNameMutatorMduNhlapo() {
        BankAccount ba = new BankAccount();
        ba.setAccount_owner("Mdu Nhlapo");
        assertEquals(ba.getAccount_owner(), "Mdu Nhlapo");
    }

    @Test
    public void testsetAccNameMutatorMdu() {
        BankAccount ba = new BankAccount();
        ba.setAccount_owner("Mdu");
        assertEquals(ba.getAccount_owner(), "Mdu");
    }

    @Test
    public void testsetAccNameMutatorMduduziNhlapo() {
        BankAccount ba = new BankAccount();
        ba.setAccount_owner("MduduziNhlapo");
        assertEquals(ba.getAccount_owner(), "MduduziNhlapo");
    }

    @Test
    public void testsetAccContactNo0718976655() {
        BankAccount ba = new BankAccount();
        ba.setContact_number("0718976655");
        assertEquals(ba.getContact_number(), "0718976655");
    }

    @Test
    public void testsetAccContactNo2718976655() {
        BankAccount ba = new BankAccount();
        ba.setContact_number("2718976655");
        assertEquals(ba.getContact_number(), "2718976655");
    }

    @Test
    public void testsetAccContactNo07189766557() {
        BankAccount ba = new BankAccount();
        try {
            ba.setContact_number("07189766557");
        } catch (Exception ex) {
            assertEquals("Contact Number should have 10 digits", ex.getMessage());
        }
    }

    @Test
    public void testsetAccContactNo071897665() {
        BankAccount ba = new BankAccount();
        try {
            ba.setContact_number("071+897665");
        } catch (IllegalArgumentException ex) {
            assertEquals("Contact Number should have 10 digits", ex.getMessage());
        }
    }

}
