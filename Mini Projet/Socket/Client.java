import java.io.*;
import java.net.*;


public class Client {
    // Adresse IP du serveur
    private static final String SERVER_ADDRESS = "localhost";
    // Port sur lequel le serveur écoute les connexions des clients
    private static final int SERVER_PORT = 9090;

    
    public static void main(String[] args) {
        try (
            // Création d'une socket pour se connecter au serveur
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            // Initialisation des flux de communication avec le serveur
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            // Demande à l'utilisateur de saisir son nom d'utilisateur
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = stdIn.readLine();
            // Envoi du nom d'utilisateur au serveur
            out.println(username);

            String serverResponse;

            // Boucle pour recevoir et afficher les messages du serveur et envoyer les messages saisis par l'utilisateur
            while ((serverResponse = in.readLine()) != null) {
                System.out.println(serverResponse);
                System.out.print("> ");
                String userInput = stdIn.readLine();
                if (userInput != null) {
                    out.println(userInput);
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la connexion au serveur.");
            e.printStackTrace();
        }
    }
}
