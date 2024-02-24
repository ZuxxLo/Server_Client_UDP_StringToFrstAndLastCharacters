import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Connecting to the server machine:");
            try (Socket client = new Socket("localhost", 7777);
                 DataInputStream input = new DataInputStream(client.getInputStream());
                 DataOutputStream output = new DataOutputStream(client.getOutputStream())) {

                Scanner scan = new Scanner(System.in);
                System.out.println("Enter a string: ");
                String inputString = scan.nextLine();

                output.writeUTF(inputString);

                // Receive and print the result from the server
                String result = input.readUTF();
                System.out.println("Result from server: " + result);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace(); // Handle appropriately
        } catch (IOException e) {
            e.printStackTrace(); // Handle appropriately
        }
    }
}


