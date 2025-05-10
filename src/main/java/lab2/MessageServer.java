package lab2;

import java.io.*;
import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageServer {
    private static final int PORT = 8080;
    private static final CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
                System.out.println("New client connected. Total clients: " + clients.size());
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientId;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.clientId = "Client-" + (clients.size() + 1);
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Connected to server as " + clientId);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received from " + clientId + ": " + inputLine);
                    broadcastMessage(clientId + ": " + inputLine, this);
                }
            } catch (IOException e) {
                System.out.println(clientId + " disconnected.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
                clients.remove(this);
                System.out.println("Remaining clients: " + clients.size());
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }

    private static void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }
}