/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author Cindyng
 */
public class NetSavingsAccount extends Account{
    
    NetSavingsAccount(){
        this.m_withdrawLimit = 2000;
        this.m_interestRate = 0.01;
        this.m_balance = 4000;
    }

    @Override
    public void calculateInterestEarned() {
        this.m_balance *= (1 + this.m_interestRate);
    }    
   
    
}
