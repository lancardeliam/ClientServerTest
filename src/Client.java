import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8000);

        OutputStreamWriter writer = new OutputStreamWriter(
                clientSocket.getOutputStream());
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        writer.write("Get me some information\n");
        writer.flush();

        String response = br.readLine();
        System.out.println(response);


                writer.close();
                br.close();
                clientSocket.close();

    }
}
