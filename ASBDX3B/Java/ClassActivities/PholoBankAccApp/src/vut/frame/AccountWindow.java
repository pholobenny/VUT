/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.frame;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import vut.data.BankAccount;

/**
 *
 * @author Pholo Benny (210124385)
 */
public class AccountWindow extends javax.swing.JFrame {

    public Connection conn;
    public BankAccount ba;
    public int pos = 0;

    /**
     * Creates new form AccountWindow
     */
    public AccountWindow() {
        initComponents();
        //hideTrasactionPanel(); (No button to unhide the panel)
        try {
            initConnection();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void hideTrasactionPanel(){
        pnlTrasaction.setVisible(false);
    }
    
    public void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/bankaccountdb";
        String username = "vut";
        String password = "";
        conn = (Connection) DriverManager.getConnection(url, username, password);
    }

    public void addNewAccount() {
        String line = "INSERT INTO accountstbl Values (" + ba.getAccount_number() + ",\'"
                + ba.getAccount_owner() + "\',\'" + ba.getAccount_Type() + "\',\'"
                + ba.getContact_number() + "\'," + ba.getAmount() + ")";
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(line);
            JOptionPane.showMessageDialog(null, "Successfull Added: " + ba.getAccount_owner());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error trying to add new account\n "
                    + ex.getMessage());
        }
    }

    public List<BankAccount> getRecords() {
        String line = "SELECT * FROM accountstbl";
        List<BankAccount> listBa = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(line);
            while (rs.next()) {
                ba = new BankAccount(rs.getDouble("Account_Balance"),
                        rs.getInt("Account_number"), rs.getString("Account_Owner"),
                        BankAccount.accountType.valueOf(rs.getString("Account_Type")),
                        rs.getString("Contact_Number"));
                listBa.add(ba);
            }
            return listBa;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    public void displayOnTextBoxes(int index) {
        txtAccountNo.setText(String.valueOf(getRecords().get(index).getAccount_number()));
        txtAccountOwner.setText(getRecords().get(index).getAccount_owner());
        txtAccountType.setText(getRecords().get(index).getAccount_Type().toString());
        txtContactNumber.setText(getRecords().get(index).getContact_number());
        txtAccountBalance.setText(Double.toString(getRecords().get(index).getAmount()));
    }

    public void deposit(int accNo, double depAmnt) {
        //get the balance and add new deposited balance 
        try {
            String bal = "Select Account_Balance FROM accountstbl WHERE Account_number =" + accNo + ";";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(bal);
            double balance = 0;
            while (rs.next()) {
                balance = rs.getDouble("Account_Balance") + depAmnt;
            }
            JOptionPane.showMessageDialog(null, balance);
            bal = "UPDATE accountstbl set Account_Balance=" + balance + "WHERE Account_number=" + accNo + ";";
            stmt.executeUpdate(bal);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void withDraw(int accNo, double withdrawAmt) {
        try {
            String bal = "Select Account_Balance FROM accountstbl WHERE Account_number =" + accNo + ";";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(bal);
            double balance = 0;
            while (rs.next()) {
                if (rs.getDouble("Account_Balance") < withdrawAmt) {
                    throw new IllegalArgumentException("Insufficeant amount");
                }
                balance = rs.getDouble("Account_Balance") - withdrawAmt;
            }
            bal = "UPDATE accountstbl set Account_Balance=" + balance + "WHERE Account_number=" + accNo + ";";
            stmt.executeUpdate(bal);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public BankAccount accountHolder(int accNo) {
        try {
            String line = "SELECT * FROM accountstbl WHERE Account_number=" + accNo + ";";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(line);
            BankAccount ba2 = null;
            while (rs.next()) {
                ba2 = new BankAccount(rs.getDouble("Account_Balance"),
                        rs.getInt("Account_number"), rs.getString("Account_Owner"),
                        BankAccount.accountType.valueOf(rs.getString("Account_Type")),
                        rs.getString("Contact_Number"));
            }
            return ba2;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewAccount = new javax.swing.JButton();
        btnDeposit = new javax.swing.JButton();
        btnWithdraw = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pnlTrasaction = new javax.swing.JPanel();
        lblAccountOwner = new javax.swing.JLabel();
        lblAccountType = new javax.swing.JLabel();
        txtAccountOwner = new javax.swing.JTextField();
        txtAccountType = new javax.swing.JTextField();
        lblAccountNo = new javax.swing.JLabel();
        txtAccountNo = new javax.swing.JTextField();
        lblAccountBalance = new javax.swing.JLabel();
        txtAccountBalance = new javax.swing.JTextField();
        lblContactNumber = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        btnViewAccounts = new javax.swing.JButton();
        btnUpdateAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNewAccount.setText("New Account");
        btnNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAccountActionPerformed(evt);
            }
        });

        btnDeposit.setText("Deposit");
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });

        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        pnlTrasaction.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "View Transaction", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlTrasaction.setToolTipText("View Transactions");

        lblAccountOwner.setText("Account Owner");

        lblAccountType.setText("Account Type");

        txtAccountOwner.setEditable(false);

        lblAccountNo.setText("Account No");

        txtAccountNo.setEditable(false);

        lblAccountBalance.setText("Account Balance");

        txtAccountBalance.setEditable(false);

        lblContactNumber.setText("Contact Number");

        btnViewAccounts.setText("View Accounts");
        btnViewAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAccountsActionPerformed(evt);
            }
        });

        btnUpdateAccount.setText("Update Account");
        btnUpdateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTrasactionLayout = new javax.swing.GroupLayout(pnlTrasaction);
        pnlTrasaction.setLayout(pnlTrasactionLayout);
        pnlTrasactionLayout.setHorizontalGroup(
            pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrasactionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblAccountOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAccountType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblAccountNo)
                    .addComponent(lblAccountBalance)
                    .addComponent(lblContactNumber))
                .addGap(27, 27, 27)
                .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAccountType)
                    .addComponent(txtAccountNo)
                    .addComponent(txtAccountOwner)
                    .addComponent(txtAccountBalance, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewAccounts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTrasactionLayout.setVerticalGroup(
            pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrasactionLayout.createSequentialGroup()
                .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTrasactionLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAccountOwner)
                            .addComponent(txtAccountOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAccountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAccountType)))
                    .addGroup(pnlTrasactionLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnViewAccounts)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountNo)
                    .addComponent(txtAccountNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountBalance)
                    .addComponent(txtAccountBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateAccount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTrasactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContactNumber)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNewAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWithdraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlTrasaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTrasaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeposit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWithdraw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnViewAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAccountsActionPerformed
        pos++;
        if (pos < getRecords().size()) {
            displayOnTextBoxes(pos);
        } else {
            pos = 0;
            displayOnTextBoxes(pos);
        }
    }//GEN-LAST:event_btnViewAccountsActionPerformed

    private void btnUpdateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAccountActionPerformed
        try {
            int accNo = Integer.parseInt(txtAccountNo.getText());
            String accOwner = txtAccountOwner.getText();
            String accType = txtAccountType.getText().toUpperCase();
            String contactNo = txtContactNumber.getText();
            double accBalance = Double.parseDouble(txtAccountBalance.getText());

            //validate before you update
            BankAccount ba = new BankAccount(accBalance, accNo, accOwner, BankAccount.accountType.valueOf(accType), contactNo);
            String line = "UPDATE accountstbl set Account_Type =\'" + ba.getAccount_Type()
                    + "\',Contact_Number=" + ba.getContact_number() + " WHERE Account_number =" + ba.getAccount_number() + ";";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(line);
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_btnUpdateAccountActionPerformed

    private void btnNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAccountActionPerformed
        AccountTransactionWindow atw = new AccountTransactionWindow();
        atw.setVisible(true);
        atw.newAccDisableButtons();

    }//GEN-LAST:event_btnNewAccountActionPerformed

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        AccountTransactionWindow atw = new AccountTransactionWindow();
        atw.setVisible(true);
        atw.depositDisableButtons();
    }//GEN-LAST:event_btnDepositActionPerformed

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        AccountTransactionWindow atw = new AccountTransactionWindow();
        atw.setVisible(true);
        atw.withdrawalDisableButtons();
    }//GEN-LAST:event_btnWithdrawActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountWindow().setVisible(true);
            }
        });
    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNewAccount;
    private javax.swing.JButton btnUpdateAccount;
    private javax.swing.JButton btnViewAccounts;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JLabel lblAccountBalance;
    private javax.swing.JLabel lblAccountNo;
    private javax.swing.JLabel lblAccountOwner;
    private javax.swing.JLabel lblAccountType;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JPanel pnlTrasaction;
    private javax.swing.JTextField txtAccountBalance;
    private javax.swing.JTextField txtAccountNo;
    private javax.swing.JTextField txtAccountOwner;
    private javax.swing.JTextField txtAccountType;
    private javax.swing.JTextField txtContactNumber;
    // End of variables declaration//GEN-END:variables
}
