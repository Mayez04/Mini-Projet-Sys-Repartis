import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer {
    // Port sur lequel le serveur écoute les connexions des clients
    private static final int PORT = 12345;

    // Ensemble de PrintWriter pour envoyer des messages à tous les clients
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Le serveur de chat est en ligne sur le port " + PORT);
            
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écoute sur le port " + PORT);
            e.printStackTrace();
        }
    }

    // Classe interne pour gérer les clients
    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        // Méthode d'exécution du thread
        public void run() {
            try {
                // Initialisation des flux de communication avec le client
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                // Ajout du PrintWriter de ce client à l'ensemble
                clientWriters.add(out);

                // Lecture du nom d'utilisateur du client
                String username = in.readLine();
                System.out.println(username + " a rejoint le salon de discussion.");

                // Diffusion du message indiquant que le client a rejoint le salon
                broadcastMessage(username + " a rejoint le salon de discussion.");

                String inputLine;
                // Boucle pour lire les messages du client et les diffuser à tous les autres clients
                while ((inputLine = in.readLine()) != null) {
                    broadcastMessage(username + ": " + inputLine);
                }
            } catch (IOException e) {
                System.out.println("Un client s'est déconnecté.");
            } finally {
                // Suppression du PrintWriter du client de l'ensemble lorsque le client se déconnecte
                if (out != null) {
                    clientWriters.remove(out);
                }
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Méthode pour diffuser un message à tous les clients
        private void broadcastMessage(String message) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }
}
