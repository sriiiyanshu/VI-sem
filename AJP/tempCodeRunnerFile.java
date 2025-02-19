import java.util.Scanner;

class prac3 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int l,u;
        System.out.println("Enter upper and lower bound of range");
        l=sc.nextInt();
        u=sc.nextInt();
        for(int n=l;n<=u;n++)
        {
            int flag=0;
            if(n==1)
            {
                System.out.println("Not Prime");
                continue;
            }
            for(int i=2;i<=Math.sqrt(n);i++)
            {
            if(n%i==0)
            {
                flag=1;
                break;
            }
            }
            if(flag==0)
            System.out.println("Prime");
            else
            System.out.println("Not Prime");
    }
    sc.close();
}
}