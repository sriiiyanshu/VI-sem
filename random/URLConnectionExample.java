import java.io.*;
import java.net.*;
public class URLConnectionExample {
public static void main(String[] args) throws Exception {
URL url = new URL("https://www.example.com/");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
BufferedReader in = new BufferedReader(new
InputStreamReader(conn.getInputStream()));

String inputLine;
while ((inputLine = in.readLine()) != null) {
System.out.println(inputLine);
}
in.close();
}
}