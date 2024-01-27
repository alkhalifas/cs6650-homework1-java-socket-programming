import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Class for the client application to make a request against server
 */
public class Client {
    public static void main(String[] args) {

        //
        if (args.length < 2) return;

        // Get host name from command
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        // Start the try and catch block
        try (Socket socket = new Socket(hostname, port);

             // Start output stream
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

             // Get the data or input
             Scanner scanner = new Scanner(System.in)) {

            // Give the user a message tpo prompt thjem for the text
            System.out.print("Enter text: ");
            String userInput = scanner.nextLine();

            output.println(userInput);
            String response = input.readLine();
            System.out.println("Response from server: " + response);

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
