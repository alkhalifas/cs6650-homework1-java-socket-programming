import java.io.*;
import java.net.*;

/**
 * Class for the server application to get a request from client
 */
public class Server {
    public static void main(String[] args) throws IOException {

        // Set the port to 32000
        int port = 32000;

        // Make sure we get input from user for arguments
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

//        System.out.println("PORT IS: " + port);

        // Create socket
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            // Feedback to the user to tell the server is active and listening
            System.out.println("Server is listening on port " + port);

            // Start second try/catch to accept call from client
            try (Socket socket = serverSocket.accept();

//                 BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 // Instantiate the reader and writer
                 BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                // Isolate the received text
                String receivedText = input.readLine();

                // return the processed text from processText function
                String processedText = processText(receivedText);
                output.println(processedText);
            }

            // Catch the IOE error
        } catch (IOException ex) {
            System.out.println("Server exception ex: " + ex);
            System.out.println("Server exception ex.getMessage(): " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Function that processes text to address casing
     */
    private static String processText(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }
}
