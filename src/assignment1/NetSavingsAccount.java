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
public class NetSavingsAccount extends Account{
    
    NetSavingsAccount(){
        this.m_accountName = "Steven";
        this.m_withdrawLimit = 2000;
        this.m_interestRate = 0.01;
        this.m_balance = 4000;
    }

    @Override
    public void calculateInterestEarned() {
        this.m_interestEarned = m_balance * (this.m_interestRate);
        this.m_balance += m_interestEarned;
        JOptionPane.showMessageDialog(null, "Interest earned is: " + m_interestEarned);
    }    
   
    
}
