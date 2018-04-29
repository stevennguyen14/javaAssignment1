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
    
    public double getAccountBalance(){
        return m_balance;
    }
    
    public void calculateInterestEarned(){
        this.m_balance *= (1 + m_interestRate);
    }
    
}
