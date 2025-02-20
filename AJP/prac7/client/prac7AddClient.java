import java.io.*;
import java.net.*;

public class prac7AddClient {
    public static void main(String[] args) {
        try{
            Socket socket=new Socket("localhost",5000);
            System.out.println("Connected to Server!");

            BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter First Number: ");
            int num1=Integer.parseInt(userInput.readLine());
            System.out.print("Enter Second Number: ");
            int num2=Integer.parseInt(userInput.readLine());

            out.println(num1);
            out.println(num2);

            int sum=Integer.parseInt(in.readLine());
            System.out.println("Sum received from server: "+sum);

            userInput.close();
            out.close();
            in.close();
            socket.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
