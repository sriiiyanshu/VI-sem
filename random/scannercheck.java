import java.util.Scanner;

public class scannercheck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(n);
        sc.nextLine(); //important to put to clear buffer
        String s=sc.nextLine();
        System.out.println(s);
        sc.close();
    }
}
