import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) {
        try {
            try (ServerSocket serverSocket = new ServerSocket(7777);
                 Socket clientSocket = serverSocket.accept();
                 DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())) {

                // Receive the string from the client
                String receivedString = input.readUTF();
                receivedString = receivedString.substring(0, 1) + receivedString.substring(receivedString.length() - 1);;
                // Convert the string to uppercase
                String resultString = receivedString;

                // Send the result back to the client
                output.writeUTF(resultString);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle appropriately
        }
    }
}