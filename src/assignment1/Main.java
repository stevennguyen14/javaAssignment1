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
public class Main {
    public static void main(String[] args){
     //Create all the class instances here. 
     //Don't want to be creating them in the loop because that will always create a new instance,
     //which means the variables will always reset (balance, withdraw limits, etc)
     SavingsAccount savingsAccount = new SavingsAccount();
     NetSavingsAccount netSavingsAccount = new NetSavingsAccount();
     ChequeAccount chequeAccount = new ChequeAccount();
     FixedAccount fixedAccount = new FixedAccount();
     
     Boolean exit = false;
     String[] choice = {"ATM", "WebBased", "Exit"};
     String[] accountChoice = {"Savings Account", "Net Savings Account", "Cheque Account", "Fixed Account"};
     
     
     while (!exit){
     
         //ask user to choose either atm, web based or to exit the program
        String input = (String) JOptionPane.showInputDialog(null, "Please select an option", 
                "Select Service type", JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
        
        //if select ATM then
        if(input == choice[0])
        {    
            //create atm instance
            ATM atm = new ATM();
            //let the user know they have seleted ATM
            JOptionPane.showMessageDialog(null, "ATM has been selected");  
            
            //ask user to select an account
            String accountType = (String) JOptionPane.showInputDialog(null, "Please select your account", "Select Account",
                    JOptionPane.QUESTION_MESSAGE, null, accountChoice, accountChoice[0]);
            
            //run the atm and feed the account types 
            //run atm function has all the withdraw, deposit, check balance functions within it
            if(accountType == accountChoice[0]){
                atm.runATM(savingsAccount);
            }
            if(accountType == accountChoice[1]){
                atm.runATM(netSavingsAccount);
            }
            if(accountType == accountChoice[2]){
                atm.runATM(chequeAccount);
            }
            if(accountType == accountChoice[3]){
                atm.runATM(fixedAccount);
            }
        }
        //if select web based interface
        else if(input == choice[1]){
           WebBased webBased = new WebBased(); 
            webBased.runWebBased(savingsAccount, netSavingsAccount, chequeAccount, fixedAccount);
            }
        else if(input == choice[2]){
            exit = true;
        }
        
        
        }        
      
    }
}
