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
public class FixedAccount extends Account{
    
    int fixedContract;
    int withdrawDate;
    boolean bWithdrawBeforeContract;
    
    FixedAccount(){
        fixedContract = 6;
        this.m_interestRate = 0.2;
        bWithdrawBeforeContract = true;
    }
    
    @Override
    public void calculateInterestEarned() {
        if(withdrawDate < fixedContract){
            bWithdrawBeforeContract = false;
        }
        
        if(bWithdrawBeforeContract == false){
            this.m_balance *= (1 + this.m_interestRate);
        
        }
    }
    
    
    
    
}
