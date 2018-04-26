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
public class Test {
    public static void main(String[] args){
     /*   ATM atm = new ATM();
        SavingsAccount savingsAccount = atm.opeAccount(SAVINGS, User);
        savingsAccount.deposit(234234);
        savingsAccount.getBalance();
        savingsAccount.withdraw(20);
        savingsAccount.getBalance();
*/
      SavingsAccount savingsAccount = new SavingsAccount();
      savingsAccount.setAccountNumber();
      String accountNum = Integer.toString(savingsAccount.getAccountNumber());
      JOptionPane.showMessageDialog(null, "Account number is: " + accountNum);
        
      
    }
}
