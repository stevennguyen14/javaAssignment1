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
public class WebBased extends Account{
    
    public void transferBalance(Account account1, Account account2){
        double transferAmount = Double.parseDouble(JOptionPane.showInputDialog("How much do you want to transfer to this account?"));
        
        //transfer balance between accounts 
        account1.m_balance -= transferAmount;
        account2.m_balance += transferAmount;
        
        //output new balance for each account
        JOptionPane.showMessageDialog(null, "New balance for first account is " + account1.getAccountBalance());
        JOptionPane.showMessageDialog(null, "New balance for second account is " + account2.getAccountBalance());
    }
    
    public void runWebBased(SavingsAccount savingsAccount, NetSavingsAccount netSavingsAccount, ChequeAccount chequeAccount, FixedAccount fixedAccount){
        String[] accountChoice = {"Savings Account", "Net Savings Account", "Cheque Account", "Fixed Account"};
        String[] webBasedOption = {"Set Withdraw Limit", "Transfer funds between accounts", "Calculate interest"};
        
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
                        transferBalance(savingsAccount, netSavingsAccount);
                    }
                    //cheque account
                    else if(account == accountChoice[2]){
                        transferBalance(savingsAccount, chequeAccount);
                    }
                    //fixed account
                    else if (account == accountChoice[3]){
                        transferBalance(savingsAccount, fixedAccount);
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
                       transferBalance(netSavingsAccount, savingsAccount); 
                    }
                    // if same account chosen then send error
                    else if(account == accountChoice[1]){
                        JOptionPane.showMessageDialog(null, "You cannot transfer to the same account");
                    }
                    //if account = cheque account
                    else if(account == accountChoice[2]){
                        transferBalance(netSavingsAccount, chequeAccount);
                    }
                    //fixed account
                    else if (account == accountChoice[3]){
                        transferBalance(savingsAccount, fixedAccount);
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
                       transferBalance(chequeAccount, savingsAccount); 
                    }
                    else if(account == accountChoice[1]){
                       transferBalance(chequeAccount, netSavingsAccount);
                    }
                    else if(account == accountChoice[2]){
                        JOptionPane.showMessageDialog(null, "You cannot transfer to the same account");
                    }
                    else if (account == accountChoice[3]){
                        transferBalance(chequeAccount, fixedAccount);
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
                       transferBalance(fixedAccount, savingsAccount); 
                    }
                    else if(account == accountChoice[1]){
                       transferBalance(fixedAccount, netSavingsAccount);
                    }
                    else if(account == accountChoice[2]){
                       transferBalance(fixedAccount, chequeAccount);
                    }
                    else if (account == accountChoice[3]){
                        JOptionPane.showMessageDialog(null, "You cannot transfer to the same account");
                    } 
                }
                else
                    fixedAccount.calculateInterestEarned();
            }
    }
   
}
