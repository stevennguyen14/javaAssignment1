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
public class FixedAccount extends Account{
    
    int fixedContract;
    int withdrawDate;
    boolean bWithdrawBeforeContract;
    
    FixedAccount(){
        this.m_accountName= "steven";
        fixedContract = 6;
        this.m_interestRate = 0.2;
        bWithdrawBeforeContract = true;
        this.m_balance = 3000;
        this.m_withdrawLimit = Double.POSITIVE_INFINITY;
    }
    
    @Override
    public void calculateInterestEarned() {
        if(withdrawDate < fixedContract){
            bWithdrawBeforeContract = false;
        }
        if(bWithdrawBeforeContract == false){
            this.m_interestEarned = m_balance * (this.m_interestRate);
            this.m_balance += m_interestEarned;
            JOptionPane.showMessageDialog(null, "Interest earned is: " + m_interestEarned);
        }
        
    }
    
    
    
    
}
