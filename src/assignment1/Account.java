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
public abstract class Account {

    protected String m_accountName;
    protected int m_accountNumber;
    protected double m_balance;
    protected double m_withdrawLimit;
    protected double m_interestRate;
    
    public void setAccountName(String name){
        this.m_accountName = name;
    }
    
    public String getAccountName(){
        return this.m_accountName;
    }
    
    public void setAccountNumber(){
        Random rand = new Random();
        this.m_accountNumber = rand.nextInt(99999999) + 10000000;
    }
    
    public int getAccountNumber(){
        return m_accountNumber;
    }
    
    public void withdrawMoney(double withdrawAmount){
        //checks if the withdraw amount is below the withdraw limit
        if(withdrawAmount < this.m_withdrawLimit){
            //checks to see if the withdraw amount can be divided by 20 (20, 100 dollar notes)
            if(withdrawAmount % 20 == 0){
                this.m_withdrawLimit -= withdrawAmount;
                this.m_balance -= withdrawAmount;
            }
            //checks to see if the withdraw amount can be divide by 50 (50, 100 dollar notes)
            else if (withdrawAmount % 50 == 0){
                this.m_withdrawLimit -= withdrawAmount;
                this.m_balance -= withdrawAmount;
            }
            else
                //else output message telling user to re-enter withdraw amount
                JOptionPane.showMessageDialog(null, "Please enter a value that supports Australian Currency ($20, $50, $100)");
                
        }
        else{
            
            JOptionPane.showMessageDialog(null, "You have reached your withdraw limit!");
        }
    }
    
    public void depositMoney(double money){
        this.m_balance += money;
    }
    
    public void calculateInterestEarned(){
        this.m_balance *= (1 + m_interestRate);
    }
    
}
