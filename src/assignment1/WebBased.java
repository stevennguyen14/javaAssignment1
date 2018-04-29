/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import javax.swing.JOptionPane;

/**
 *
 * @author Cindyng
 */
public class WebBased extends Account{
    
    public void transferBalance(Account account1, Account account2){
        double transferAmount = Double.parseDouble(JOptionPane.showInputDialog("How much do you want to transfer to this account?"));
        
        //transfer balance between accounts 
        account1.m_balance -= transferAmount;
        account2.m_balance += transferAmount;
        
        //output new balance for each account
        JOptionPane.showMessageDialog(null, "New balance for first account is " + account1.getAccountBalance());
        JOptionPane.showMessageDialog(null, "New balance for second account is " + account2.getAccountBalance());
    }
   
}
