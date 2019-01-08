import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {

            int count = 0;
            ServerSocket serverSocket = new ServerSocket(8000);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("client accepted " + (++count));

                OutputStreamWriter writer = new OutputStreamWriter(
                        clientSocket.getOutputStream());
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

                String request = br.readLine();
                String response = "#" + count + ", your message length is " + request.length() + "\n";

//                writer.write("HTTP/1.0 200 OK\n" +
//                        "Content-Type: text/html\n" +
//                        "\n" +
//                        response);

                writer.write(response);

                writer.flush();

                writer.close();
                br.close();
                clientSocket.close();
            }
        //serverSocket.close();
    }
}
