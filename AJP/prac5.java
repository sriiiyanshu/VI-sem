/* Write a two thread based program in java where thread1 adds all even numbers and thread2 adds all odd numbers from a given file which had large number of positive integersq*/
import java.io.*;
import java.util.*;
public class prac5 extends Thread {

    String task;

    prac5(String task)
    {
        this.task=task;
    }


    public void Even()throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("nums.txt"));
        int evenSum=0;
        for(int i=0;i<10;i++)
        {
            int no=Integer.parseInt(br.readLine());
            if(no%2==0)
            {
            evenSum += no;
            }
        }
        System.out.println("Even addition= "+evenSum);
        br.close();
    }

    public void Odd()throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("nums.txt"));
        int oddSum=0;
        for(int i=0;i<10;i++)
        {
            int no=Integer.parseInt(br.readLine());
            if(no%2!=0)
            {
            oddSum += no;
            }
        }
        System.out.println("Odd addition= "+oddSum);
        br.close();
    }

    public void run()
    {
        try
        {
        if(task.equals("even"))
        Even();
        else if(task.equals("odd"))
        Odd();
        }
        catch(Exception e)
        {
        System.out.println("Error: "+ e.getMessage());
        }
    }

    public static void main(String args[])throws IOException, InterruptedException 
    {
        BufferedWriter bw= new BufferedWriter(new FileWriter("nums.txt"));
        Random r = new Random();
        for (int i=0;i<10;i++)
        {
            int no=r.nextInt(1000)+1;
            bw.write(no+"\n");
    }
    bw.close();

    prac5 ob1 = new prac5("even");
    prac5 ob2 = new prac5("odd");

    ob1.start();
    ob2.start();
    }
}

