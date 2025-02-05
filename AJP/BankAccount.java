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
abstract class BankAccount {

    String accountNumber;
    double balance;
    
    BankAccount(){}
    BankAccount(String a, double b)
    {
        accountNumber=a;
        balance=b;
    }
    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    public void disp()
    {
        System.out.println("Account number: "+accountNumber);
        System.out.println("Balance: "+balance);
        System.out.println();
    }
}
