/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vut.data.HalesComforters;

/**
 *
 * @author 210124385 Pholo BL
 */
public class HalesComfortersFrame extends javax.swing.JFrame {

    private Connection conn = null;
    HalesComforters hc;
    private int pos; 

    /**
     * Creates new form HalesComfortersForm
     */
    public HalesComfortersFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        btnUpdateTrasaction = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnDisplayCost = new javax.swing.JButton();
        lblCost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ckbPickUpInStore = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        rTwin = new javax.swing.JRadioButton();
        rFull = new javax.swing.JRadioButton();
        rQueen = new javax.swing.JRadioButton();
        rKing = new javax.swing.JRadioButton();
        pnlViewTransactions = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtComforterSize = new javax.swing.JTextField();
        txtAmountPaid = new javax.swing.JTextField();
        txtCustomerName = new javax.swing.JTextField();
        txtCellNumber = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnSale = new javax.swing.JButton();
        btnViewStData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hales Department Store");

        panel1.setBackground(java.awt.Color.orange);

        btnUpdateTrasaction.setText("Update Transaction");
        btnUpdateTrasaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTrasactionActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnDisplayCost.setText("Display cost");
        btnDisplayCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayCostActionPerformed(evt);
            }
        });

        lblCost.setFocusable(false);

        jLabel1.setText("Cost:");

        ckbPickUpInStore.setText("Pick up in store");
        ckbPickUpInStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbPickUpInStoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ckbPickUpInStore, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDisplayCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateTrasaction, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(lblCost))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ckbPickUpInStore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisplayCost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateTrasaction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(java.awt.Color.orange);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comfoter Size", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        buttonGroup1.add(rTwin);
        rTwin.setSelected(true);
        rTwin.setText("Twin");

        buttonGroup1.add(rFull);
        rFull.setText("Full");

        buttonGroup1.add(rQueen);
        rQueen.setText("Queen");

        buttonGroup1.add(rKing);
        rKing.setText("King");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rTwin)
                    .addComponent(rFull)
                    .addComponent(rQueen)
                    .addComponent(rKing))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rTwin)
                .addGap(18, 18, 18)
                .addComponent(rFull)
                .addGap(18, 18, 18)
                .addComponent(rQueen)
                .addGap(18, 18, 18)
                .addComponent(rKing)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlViewTransactions.setBackground(java.awt.Color.orange);

        jLabel2.setText("View Transactions");

        jPanel3.setBackground(java.awt.Color.orange);
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("comforter size");

        jLabel4.setText("Amount paid");

        jLabel5.setText("Customer name:");

        jLabel6.setText("Cell Number:");

        txtComforterSize.setEditable(false);

        txtAmountPaid.setEditable(false);

        txtCustomerName.setEditable(false);

        txtCellNumber.setEditable(false);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnSale.setText("Sale");
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });

        btnViewStData.setText("View Statustical Data");
        btnViewStData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(44, 44, 44)
                        .addComponent(txtComforterSize))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAmountPaid)
                            .addComponent(txtCustomerName)
                            .addComponent(txtCellNumber))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewStData, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPrevious))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtComforterSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCellNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSale)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewStData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlViewTransactionsLayout = new javax.swing.GroupLayout(pnlViewTransactions);
        pnlViewTransactions.setLayout(pnlViewTransactionsLayout);
        pnlViewTransactionsLayout.setHorizontalGroup(
            pnlViewTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewTransactionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlViewTransactionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        pnlViewTransactionsLayout.setVerticalGroup(
            pnlViewTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewTransactionsLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlViewTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlViewTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Comforter Size");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisplayCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayCostActionPerformed
        HalesComforters hc = new HalesComforters();
        HalesComforters.Comforters size = HalesComforters.Comforters.TWIN;;
        String pickUp;

        lblCost.setText("");

        if (rTwin.isSelected()) {
            size = HalesComforters.Comforters.TWIN;
        } else if (rKing.isSelected()) {
            size = HalesComforters.Comforters.KING;
        } else if (rQueen.isSelected()) {
            size = HalesComforters.Comforters.QUEEN;
        } else if (rFull.isSelected()) {
            size = HalesComforters.Comforters.FULL;
        }

        if (ckbPickUpInStore.isSelected()) {
            pickUp = "Yes";
        } else {
            pickUp = "No";
        }
        double cost = hc.calculateCost(size, pickUp);
        Locale locale = new Locale("en", "ZA");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        lblCost.setText(currencyFormatter.format(cost));
        String customerName = JOptionPane.showInputDialog("Please Enter Customer name");
        String cellNumber = JOptionPane.showInputDialog("Please Enter Cell Number");

        try {
            hc = new HalesComforters(cost, size, customerName, cellNumber);
            myJDBCConnection();
            addData(hc);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnDisplayCostActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void ckbPickUpInStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbPickUpInStoreActionPerformed

    }//GEN-LAST:event_ckbPickUpInStoreActionPerformed

    private void btnUpdateTrasactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTrasactionActionPerformed
        try {
            myJDBCConnection();
            getData();
            displayData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnUpdateTrasactionActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            myJDBCConnection();
            loadArrayList();
            pos++;
            if(pos<loadArrayList().size()){
                txtAmountPaid.setText(String.format("%2.2f",loadArrayList().get(pos).getCost()));
                txtComforterSize.setText(loadArrayList().get(pos).getComforterSize().toString());
                txtCustomerName.setText(loadArrayList().get(pos).getCustomerName());
                txtCellNumber.setText(loadArrayList().get(pos).getCellNumber());
                
            }else{
                pos = loadArrayList().size() -1;
                txtAmountPaid.setText(String.format("%2.2f",loadArrayList().get(pos).getCost()));
                txtComforterSize.setText(loadArrayList().get(pos).getComforterSize().toString());
                txtCustomerName.setText(loadArrayList().get(pos).getCustomerName());
                txtCellNumber.setText(loadArrayList().get(pos).getCellNumber());
                JOptionPane.showMessageDialog(null, "END");
            }} catch (SQLException ex) {
            Logger.getLogger(HalesComfortersFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HalesComfortersFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        try {
            myJDBCConnection();
            loadArrayList();
            pos--;
            if(pos>0){
                txtAmountPaid.setText(String.format("%2.2f",loadArrayList().get(pos).getCost()));
                txtComforterSize.setText(loadArrayList().get(pos).getComforterSize().toString());
                txtCustomerName.setText(loadArrayList().get(pos).getCustomerName());
                txtCellNumber.setText(loadArrayList().get(pos).getCellNumber());
                
            }else{
                pos = 0;
                txtAmountPaid.setText(String.format("%2.2f",loadArrayList().get(pos).getCost()));
                txtComforterSize.setText(loadArrayList().get(pos).getComforterSize().toString());
                txtCustomerName.setText(loadArrayList().get(pos).getCustomerName());
                txtCellNumber.setText(loadArrayList().get(pos).getCellNumber());
                JOptionPane.showMessageDialog(null, "END");
            }} catch (SQLException ex) {
            Logger.getLogger(HalesComfortersFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HalesComfortersFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String cellNumber =txtCellNumber.getText();
        String name =txtCustomerName.getText();
        String line = "DELETE FROM orders WHERE cellnumber ='"+cellNumber+"'";
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(line);
            JOptionPane.showMessageDialog(null, "Successfully deleted \n"+name+" order");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String cellNumber =txtCellNumber.getText();
        String name =txtCustomerName.getText();
        String amount = txtAmountPaid.getText();
        String size = txtComforterSize.getText();
               
        String line = "UPDATE orders SET amount ="+amount+",name=\'"+name+"\',size =\'"+size.toUpperCase()+"\' where cellnumber=\'"+cellNumber+"\'";
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(line);
            JOptionPane.showMessageDialog(null, "Successfully Update data");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        pnlViewTransactions.setVisible(false);
    }//GEN-LAST:event_btnSaleActionPerformed

    private void btnViewStDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStDataActionPerformed
        
        new ViewSalesFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnViewStDataActionPerformed
        
    
    
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void myJDBCConnection() throws SQLException, ClassNotFoundException {
        //Load the jdbc driver
        Class.forName("com.mysql.jdbc.Driver");
        //make connection to the db
        String url = "jdbc:mysql://localhost/haleComforters";
        String user = "vut";
        String password = "";
        conn = DriverManager.getConnection(url, user, password);
    }

    public void getData() {
        String line = "Select * from orders";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(line);
            while (rs.next()) {
                hc = new HalesComforters(rs.getDouble(2), HalesComforters.Comforters.valueOf(rs.getString(3)), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void displayData() {
        txtAmountPaid.setText(String.format("%2.2f", hc.getCost()));
        txtComforterSize.setText(hc.getComforterSize().toString());
        txtCustomerName.setText(hc.getCustomerName());
        txtCellNumber.setText(hc.getCellNumber());
    }

    public void addData(HalesComforters halesComforters) {
        String line = "Insert into orders values(null," + halesComforters.getCost()
                + ",\'" + halesComforters.getComforterSize() + "\',\'"
                + halesComforters.getCustomerName() + "\',\'" + halesComforters.getCellNumber() + "\')";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(line);
            JOptionPane.showMessageDialog(null, "Sucessfully Placed an order for "
                    + halesComforters.getCustomerName());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error trying to place an order\n" + ex.getMessage());
        }
    }

    public ArrayList<HalesComforters> loadArrayList() {     
        ArrayList<HalesComforters> data = new ArrayList<>();
        String line = "Select * from orders";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(line);            
            while (rs.next()) {
                hc = new HalesComforters(rs.getDouble(2), HalesComforters.Comforters.valueOf(rs.getString(3)), rs.getString(4), rs.getString(5));
                data.add(hc);
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return data;
    }

   

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
            java.util.logging.Logger.getLogger(HalesComfortersFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalesComfortersFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalesComfortersFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalesComfortersFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalesComfortersFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplayCost;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateTrasaction;
    private javax.swing.JButton btnViewStData;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox ckbPickUpInStore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lblCost;
    private java.awt.Panel panel1;
    private javax.swing.JPanel pnlViewTransactions;
    private javax.swing.JRadioButton rFull;
    private javax.swing.JRadioButton rKing;
    private javax.swing.JRadioButton rQueen;
    private javax.swing.JRadioButton rTwin;
    private javax.swing.JTextField txtAmountPaid;
    private javax.swing.JTextField txtCellNumber;
    private javax.swing.JTextField txtComforterSize;
    private javax.swing.JTextField txtCustomerName;
    // End of variables declaration//GEN-END:variables
}
