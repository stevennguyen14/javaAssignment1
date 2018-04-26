/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Random;

/**
 *
 * @author Cindyng
 */
public class SavingsAccount extends Account{
    
    SavingsAccount(){
        this.m_interestRate = 0.001;
    }

    public void setWithdrawLimit(double withdrawLimit){
        this.m_withdrawLimit = withdrawLimit;
    }
    
    public double getWithdrawLimit(){
        return m_withdrawLimit;
    }
    
    public void calculateInterestEarned(){
        this.m_balance *= (1 + m_interestRate);
    }
    
        
    
}
