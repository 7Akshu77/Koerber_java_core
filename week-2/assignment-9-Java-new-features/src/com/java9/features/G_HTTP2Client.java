package com.java9.features;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class G_HTTP2Client {
    public static void main(String[] args) {
try(HttpClient hc = HttpClient.newHttpClient()){
   HttpRequest hcReq = HttpRequest.newBuilder().uri(new URI("https://www.google.com")).GET().build();
   HttpResponse<String> resp = hc.send(hcReq,HttpResponse.BodyHandlers.ofString());
}  catch (URISyntaxException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} catch (InterruptedException e) {
    e.printStackTrace();
}

    }
}
