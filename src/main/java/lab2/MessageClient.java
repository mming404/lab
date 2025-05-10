package lab2;

import java.io.*;
import java.net.*;

public class MessageClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            System.out.println("Connected to server");

            // 消息接收线程
            new Thread(() -> {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println("Server says: " + response);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed");
                }
            }).start();

            // 消息发送线程
            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
                String userInput;
                while ((userInput = stdIn.readLine()) != null) {
                    out.println(userInput);
                }
            }
        } catch (IOException e) {
            System.err.println("Client exception: " + e.getMessage());
        }
    }
}