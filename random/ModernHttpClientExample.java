import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class ModernHttpClientExample {
public static void main(String[] args) throws Exception {
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
.uri(URI.create("http://example.com"))
.GET()
.build();
HttpResponse<String> response = client.send(request,
HttpResponse.BodyHandlers.ofString());
System.out.println("Response Code: " + response.statusCode());
System.out.println("Response Body: " + response.body());
}
}