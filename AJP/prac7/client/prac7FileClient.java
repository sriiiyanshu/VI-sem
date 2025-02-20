import java.io.*;
import java.net.*;

public class prac7FileClient {
    public static void main(String[] args)throws IOException {
            Socket socket=new Socket("localhost",5000);
            System.out.println("Connected to Server!");

            BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter File Name: ");
            String name=userInput.readLine().trim();

            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            pw.println(name);

            InputStream is=socket.getInputStream();
            FileOutputStream fos= new FileOutputStream(name);
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String msg=in.readLine();
            System.out.println(msg);

            if(!msg.equals("File not found."))
            {
                long fileSize=Long.parseLong(in.readLine());
                byte[] buffer = new byte[4096];
                int bytesRead;
                long totalBytesRead = 0;

                while (totalBytesRead < fileSize && (bytesRead = is.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
                }
                System.out.println("File received Successfully");
            }

            in.close();
            userInput.close();
            bos.close();
            is.close();
            fos.close();
            socket.close();
        
    }
}
