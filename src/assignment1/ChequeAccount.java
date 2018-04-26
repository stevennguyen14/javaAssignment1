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
public class ChequeAccount extends Account{
    
    ChequeAccount(){
        this.m_withdrawLimit = Double.POSITIVE_INFINITY;
    }

    @Override
    public void calculateInterestEarned() {
        this.m_interestRate = 0; 
    }
    
}
