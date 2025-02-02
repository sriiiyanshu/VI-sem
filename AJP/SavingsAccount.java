/*SavingsAccount:
•⁠  ⁠Has an additional variable interestRate (double).
•⁠  ⁠Overrides the deposit method to add interest to the balance.
•⁠  ⁠Withdrawals are allowed only if the balance remains above a certain minimum (e.g., 500).
*/

import java.util.Scanner;

class SavingsAccount extends BankAccount {
        double interestRate;
        void deposit(double amount)
        {
            balance=balance+amount+interest;
        }
        
        void withdraw(double amount)
        {
            if(balance-amount>=500)
            {

            }
        }
}
