import java.io.*;       
import java.net.*;

public class prac7FileServer {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        String name = in.readLine().trim();
        File file = new File(name);

        if (!file.exists() || file.isDirectory()) {
            pw.println("File not found.");
            System.out.println("File not found.");
        } 
        else {
            pw.println("File Found.");
            long filesize = file.length();
            pw.println(filesize);

            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            OutputStream out = socket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("File sent successfully.");
            pw.println("File transfer complete.");

            bis.close();
            fis.close();
            out.close();
        }

        in.close();
        pw.close();
        socket.close();
        serverSocket.close();
    }
}
