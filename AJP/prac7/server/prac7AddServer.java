/* Write a client server based program in java
 * a. a client sneds 2 numbers, server reads, adds and returns sum to the client
 * b. client requests for a particular file, if this file exists in current folder of the server then server sends this file to the client
 */

import java.io.*;       
import java.net.*;

public class prac7AddServer
{
    public static void main(String args[]){
        try{
            ServerSocket serverSocket= new ServerSocket(5000);
            System.out.println("Server is waiting for client.....");

            Socket socket=serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

            int num1 = Integer.parseInt(in.readLine());
            int num2 = Integer.parseInt(in.readLine());
            int sum = num1+num2;

            out.println(sum);

            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}