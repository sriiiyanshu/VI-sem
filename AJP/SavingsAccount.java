/*  ⁠Create an abstract class BankAccount with the following:
a)	An accountNumber (String) and balance (double) as instance variables.
b)	A constructor to initialize the account number and balance.
c)	Abstract methods:
•⁠  ⁠deposit(double amount)
•⁠  ⁠withdraw(double amount)
d)	Create two subclasses:
SavingsAccount:
•⁠  ⁠Has an additional variable interestRate (double).
•⁠  ⁠Overrides the deposit method to add interest to the balance.
•⁠  ⁠Withdrawals are allowed only if the balance remains above a certain minimum (e.g., 500).
CurrentAccount:
•⁠  ⁠Has an additional variable overdraftLimit (double).
•⁠  ⁠Overrides the withdraw method to allow overdraft up to the specified limit.
*/

class SavingsAccount extends BankAccount
{
    double interestRate;
    SavingsAccount(){}
    SavingsAccount(String accountNumber, double balance, double ir)
    {
        super(accountNumber, balance);
        interestRate = ir;
    }

    public void deposit(double amount)
    {
        if(amount>0)
        {
            balance += amount;
            balance += balance*(interestRate/100);
            System.out.println("Deposit successful. New Balance: "+balance);
        }
        else
        {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw(double amount)
    {
        if(balance-amount>500)
        {
            balance -= amount;
            System.out.println("Amount withdrawn: "+amount);
            System.out.println("Balance amount is: "+balance);
        }
        else
        {
            System.out.println("Insufficient Balance");
        }
    }
}

