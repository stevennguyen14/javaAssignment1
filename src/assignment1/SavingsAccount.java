/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Cindyng
 */
public class SavingsAccount extends Account{
    
    //constructor 
    SavingsAccount(){
        this.m_interestRate = 0.001;
        this.m_withdrawLimit = 400;
        this.m_balance = 2300;
    }
    
    //set the withdraw limit
    public void setWithdrawLimit(double withdrawLimit){
        this.m_withdrawLimit = withdrawLimit;
    }
    
    //get withdraw limit
    public double getWithdrawLimit(){
        return m_withdrawLimit;
    }
    
    @Override
    public void calculateInterestEarned(){
        this.m_interestEarned = m_balance * (m_interestRate);
        JOptionPane.showMessageDialog(null, "Interest earned is: " + m_interestEarned);
    }
    
        
    
}
