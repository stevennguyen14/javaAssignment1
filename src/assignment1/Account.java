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
    protected double m_interestEarned;
    
    //set the accound name
    public void setAccountName(String name){
        this.m_accountName = name;
    }
    
    //get acount name
    public String getAccountName(){
        return this.m_accountName;
    }
    
    //set accout number with random number generation
    public void setAccountNumber(){
        Random rand = new Random();
        this.m_accountNumber = rand.nextInt(99999999) + 10000000;
    }
    //get account number
    public int getAccountNumber(){
        return m_accountNumber;
    }
    //get account balance
    public double getAccountBalance(){
        return m_balance;
    }
    //calculate interest earned 
    public void calculateInterestEarned(){
        this.m_interestEarned *= m_interestRate;
        JOptionPane.showMessageDialog(null, "Interest earned is: " + m_interestEarned);
    }
    
}
