public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 1000, 5);
        System.out.println("\nSavings Account:");
        savingsAccount.disp();
        savingsAccount.deposit(500);
        savingsAccount.withdraw(200);
        savingsAccount.withdraw(1000);

        System.out.println();

        CurrentAccount currentAccount = new CurrentAccount("CA456", 2000, 1000);
        System.out.println("\nCurrent Account");
        currentAccount.disp();
        currentAccount.deposit(300);
        currentAccount.withdraw(2500); 
        currentAccount.withdraw(1000); 
    }
}
