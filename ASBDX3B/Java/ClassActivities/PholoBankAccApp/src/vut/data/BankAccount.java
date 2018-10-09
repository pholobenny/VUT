/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.data;

/**
 * This is the bank account class
 *
 * @author 210124385
 */
public class BankAccount {

    private double amount;
    private int account_number;
    private String account_owner;

    public enum accountType {
        SAVINGS, CHECK;
    }

    public accountType account_type;
    private String contact_number;

    /**
     * Bank account default constructor
     */
    public BankAccount() {
        this.amount = 0;
        this.account_number = 0;
        this.account_owner = "";
        this.account_type = accountType.CHECK;
        this.contact_number = "";
    }

    /**
     * Bank account overloaded constructor
     *
     * @param amount the total balance
     * @param account_number the account number
     * @param account_owner the account owner name
     * @param account_type the account type
     * @param contact_number the contact number
     */
    public BankAccount(double amount, int account_number, String account_owner, accountType account_type, String contact_number) {
        this.setAmount(amount);
        setAccount_number(account_number);
        setAccount_owner(account_owner);
        setContact_number(contact_number);
        setAccount_Type(account_type);
    }

    /**
     * Set the balance
     *
     * @param amount the balance
     * @exception throw exception if the amount is nagitive
     */
    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount, amount should not be nagative");
        } else {
            this.amount = amount;
        }
    }

    /**
     * Set account number
     *
     * @param account_number the account number
     */
    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    /**
     * set account holder name
     *
     * @param account_owner the account holder name
     */
    public void setAccount_owner(String account_owner) {
        this.account_owner = account_owner;
    }

    /**
     * Set the account type
     *
     * @param account_type
     */
    public void setAccount_Type(accountType account_type) {
//        for (accountType at : accountType.values()){
//            if (at.name().equals(account_type)){
        this.account_type = account_type;
//            }
//        }

    }

    /**
     * Set the contact number
     *
     * @param contact_number the contact number
     */
    public void setContact_number(String contact_number) {
        if (contact_number.matches("\\d{10}")) {
            this.contact_number = contact_number;
        } else {
            throw new IllegalArgumentException("Contact Number should have 10 digits");
        }
    }

    /**
     * Get the balance
     *
     * @return the balance
     */
    public double getAmount() {
        return amount;
    }

    /**
     * get account number
     *
     * @return the account number
     */
    public int getAccount_number() {
        return account_number;
    }

    /**
     * get the account owner
     *
     * @return the account owner
     */
    public String getAccount_owner() {
        return account_owner;
    }

    /**
     * get the account type
     *
     * @return the account type
     */
    public accountType getAccount_Type() {
        return account_type;
    }

    /**
     * Get the Contact Number
     *
     * @return the contact number
     */
    public String getContact_number() {
        return contact_number;
    }

    @Override
    public String toString() {
        return "Acc.No:" + account_number + "\nAcc.Owner:" + account_owner
                + "\nAcc.ContactNo:" + contact_number + "\nAcc.Type:" + account_type
                + "\nAcc.Bal:" + amount + "\n****************";
    }
}
