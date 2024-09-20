package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FakeServer {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println(String.format("Starting server on port %d...", port));

            while (true) {
                try (Socket connection = server.accept()) {
                    System.out.println("Received connection:");

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));

                    String line;
                    while ((line = reader.readLine()) != null && line.trim().length() > 0) {
                        System.out.println(line);
                    }
                } finally {
                    System.out.println("Request finished\n\n");
                }
            }
        }
    }
}
