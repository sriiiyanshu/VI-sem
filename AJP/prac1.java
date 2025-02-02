//Accept an input range a and b. Print 'fizz' if number is divisible by 3, 'Buzz' if number is divisible by 5. 'Fizzbuzz' is number is divisble by 3 & 5 both, else print the number.
import java.util.Scanner;

class prac1
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int l,u;
        System.out.println("Enter upper and lower bound of range");
        l=sc.nextInt();
        u=sc.nextInt();
        for(int i=l;i<=u;i++)
        {
            if(i%15 == 0)
                System.out.println("FizzBuzz");
            else if(i%3==0)
                System.out.println("Fizz");
            else if(i%5==0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
        sc.close();
    }
}