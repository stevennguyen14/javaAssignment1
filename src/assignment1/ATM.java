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
public class ATM extends Account{
    
    public void withdrawMoney(Account account){
        Boolean bExitLoop = false;
        int withdrawAmount;
        
        while(bExitLoop == false){
            withdrawAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount you want to withdraw"));
            
            if(withdrawAmount <= account.m_balance){
                //checks if the withdraw amount is below the withdraw limit
                if(withdrawAmount <= account.m_withdrawLimit){
                    //checks to see if the withdraw amount can be divided by 20 (20, 100 dollar notes)
                    if(((withdrawAmount - 50) % 20 == 0  && withdrawAmount > 50) || (withdrawAmount % 50) == 0  || (withdrawAmount % 20) == 0)
                    {
                        account.m_withdrawLimit -= withdrawAmount;
                        account.m_balance -= withdrawAmount;
                        JOptionPane.showMessageDialog(null, "Money succesfully withdrawn, your new balance is: " + account.m_balance
                        + " and your new withdrawal limit for today is: " + account.m_withdrawLimit);
                        bExitLoop = true;
                    }
                    
                    else{
                        //else output message telling user to re-enter withdraw amount
                        JOptionPane.showMessageDialog(null, "Please enter a value that supports Australian Currency ($20, $50, $100)");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You have reached your withdraw limit!");
                    bExitLoop = true;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You don't have enough balance to withdraw this certain amount. You balance is: " + this.m_balance);
                bExitLoop = true;
            }
        }
    }
        
    public void depositMoney(Account account){
        int money;
        //assign money to whatever the user enters
        money = Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount you would like to deposit"));
        //add the deposited money into the account balance
        account.m_balance += money;
        JOptionPane.showMessageDialog(null, "Money deposited, new balance is: " + account.m_balance);
    }
    
    public void checkBalance(Account account){
        JOptionPane.showMessageDialog(null, "Your balance is: " + account.m_balance);
    }
    
    //feed the account into run atm, this will run all the other functions using the account type
    public void runATM(Account account){
        this.m_balance = account.m_balance;
        this.m_withdrawLimit = account.m_withdrawLimit;
        //create array of options
        String[] atmOption = {"Withdraw Money","Deposit Money", "Check balance"};
        
        //Ask user to select option
        String atmChoice = (String) JOptionPane.showInputDialog(null, "What would you like to do?", "Select Option", 
        JOptionPane.QUESTION_MESSAGE, null, atmOption, atmOption[0]);
        
        //if selection is withdraw money
        if(atmChoice == atmOption[0])
        {
            withdrawMoney(account);
        }
        //if selection is deposit money
        else if(atmChoice == atmOption[1])
        {
            depositMoney(account);
        }
        //if selection is to check balnce
        else if(atmChoice == atmOption[2])
        {
            checkBalance(account);
        }
    }
}
