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
     String[] webBasedOption = {"Set Withdraw Limit", "Transfer funds between accounts", "Calculate interest"};
     
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
            //create web based instance
            WebBased webBased = new WebBased();
            //notify user web based has been selected
            JOptionPane.showMessageDialog(null, "Web Based interface has been selected");
            
            //ask user to select which account
            String accountType = (String) JOptionPane.showInputDialog(null, "Please select your account", "Select Account",
                    JOptionPane.QUESTION_MESSAGE, null, accountChoice, accountChoice[0]);
            //select what the user would like to do with the account?
            //savings account
            if(accountType == accountChoice[0]){
                String webBasedChoice = (String) JOptionPane.showInputDialog(null, "Would you like to set withdraw limit or transfer funds to another account or calculate interest?",
                        "Select Option", JOptionPane.QUESTION_MESSAGE, null, webBasedOption, webBasedOption[0]);
                //if choice is set withdraw limit         
                if(webBasedChoice == webBasedOption[0]){
                    //ask user to enter withdraw limit
                    double withdrawLimit = Double.parseDouble(JOptionPane.showInputDialog("Please enter the new withdraw limit"));
                    //set new withdraw limit
                    savingsAccount.setWithdrawLimit(withdrawLimit);
                }
                //if choice is to transfer funds
                else if(webBasedChoice == webBasedOption[1]){
                    String account = (String) JOptionPane.showInputDialog(null, "Which account do you want to transfer funds to?",
                        "Select option", JOptionPane.QUESTION_MESSAGE, null, accountChoice, accountChoice [1]);
                    //if trying to transfer to same account, throw error
                    if(account == accountChoice[0]){
                        JOptionPane.showMessageDialog(null, "You cannot transfer to the same account");
                    }
                    //net savings account
                    else if(account == accountChoice[1]){
                        webBased.transferBalance(savingsAccount, netSavingsAccount);
                    }
                    //cheque account
                    else if(account == accountChoice[2]){
                        webBased.transferBalance(savingsAccount, chequeAccount);
                    }
                    //fixed account
                    else if (account == accountChoice[3]){
                        webBased.transferBalance(savingsAccount, fixedAccount);
                    } 
                }
                //if choice is calculate interest earned
                else if (webBasedChoice == webBasedOption[2]){
                    //calculate savings account interest
                    savingsAccount.calculateInterestEarned();
                }
            }
            //if account choice is net savings account
            else if(accountType == accountChoice[1]){
                //
                String webBasedChoice = (String) JOptionPane.showInputDialog(null, "transfer funds to another account or calculate interest?",
                        "Select Option", JOptionPane.QUESTION_MESSAGE, null, webBasedOption, webBasedOption[0]);
                //net savings account cant set withdraw limit, so give error message
                if(webBasedChoice == webBasedOption[0]){
                    JOptionPane.showMessageDialog(null, "You cannot set withdraw limit for net savings account");
                }
                else if(webBasedChoice == webBasedOption[1]){
                //ask user which account to send funds to
                String account = (String) JOptionPane.showInputDialog(null, "Which account do you want to transfer funds to?",
                        "Select option", JOptionPane.QUESTION_MESSAGE, null, accountChoice, accountChoice [0]);
                    //if account to transfer to is savings account
                    if(account == accountChoice[0]){
                       webBased.transferBalance(netSavingsAccount, savingsAccount); 
                    }
                    // if same account chosen then send error
                    else if(account == accountChoice[1]){
                        JOptionPane.showMessageDialog(null, "You cannot transfer to the same account");
                    }
                    //if account = cheque account
                    else if(account == accountChoice[2]){
                        webBased.transferBalance(netSavingsAccount, chequeAccount);
                    }
                    //fixed account
                    else if (account == accountChoice[3]){
                        webBased.transferBalance(savingsAccount, fixedAccount);
                    } 
                }
                //else calculate interest
                else 
                    netSavingsAccount.calculateInterestEarned();
            }
            //cheque account
            else if (accountType == accountChoice[2]){
                String webBasedChoice = (String) JOptionPane.showInputDialog(null, "transfer funds to another account or calculate interest?",
                        "Select Option", JOptionPane.QUESTION_MESSAGE, null, webBasedOption, webBasedOption[0]);
                if(webBasedChoice == webBasedOption[0]){
                    JOptionPane.showMessageDialog(null, "You cannot set withdraw limit for cheque account");
                }
                if(webBasedChoice == webBasedOption[1]){
                String account = (String) JOptionPane.showInputDialog(null, "Which account do you want to transfer funds to?",
                        "Select option", JOptionPane.QUESTION_MESSAGE, null, accountChoice, accountChoice [0]);
                    if(account == accountChoice[0]){
                       webBased.transferBalance(chequeAccount, savingsAccount); 
                    }
                    else if(account == accountChoice[1]){
                       webBased.transferBalance(chequeAccount, netSavingsAccount);
                    }
                    else if(account == accountChoice[2]){
                        JOptionPane.showMessageDialog(null, "You cannot transfer to the same account");
                    }
                    else if (account == accountChoice[3]){
                        webBased.transferBalance(chequeAccount, fixedAccount);
                    } 
                }
                if(webBasedChoice == webBasedOption[2]){
                    JOptionPane.showMessageDialog(null, "cheque account has no interest");
                }
            }
            else if(accountType == accountChoice[3]){
                
                String webBasedChoice = (String) JOptionPane.showInputDialog(null, "transfer funds to another account or calculate interest?",
                        "Select Option", JOptionPane.QUESTION_MESSAGE, null, webBasedOption, webBasedOption[0]);
                
                String account = (String) JOptionPane.showInputDialog(null, "Which account do you want to transfer funds to?",
                        "Select option", JOptionPane.QUESTION_MESSAGE, null, accountChoice, accountChoice [0]);
                
                if(webBasedChoice == webBasedOption[0]){
                    JOptionPane.showMessageDialog(null, "Fixed account doesn't offer a withdraw limit");
                }
                else if(webBasedChoice == webBasedOption[1]){
                    if(account == accountChoice[0]){
                       webBased.transferBalance(fixedAccount, savingsAccount); 
                    }
                    else if(account == accountChoice[1]){
                       webBased.transferBalance(fixedAccount, netSavingsAccount);
                    }
                    else if(account == accountChoice[2]){
                       webBased.transferBalance(fixedAccount, chequeAccount);
                    }
                    else if (account == accountChoice[3]){
                        JOptionPane.showMessageDialog(null, "You cannot transfer to the same account");
                    } 
                }
                else
                    fixedAccount.calculateInterestEarned();
            }
        }
        else if(input == choice[2]){
            exit = true;
        }
        
        
        }        
      
    }
}
