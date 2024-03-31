package RmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException{
        // Définition du port utilisé par le serveur RMI
        final int PORT = 1125;
        // Création d'un registre RMI local sur le port spécifié
        LocateRegistry.createRegistry(PORT);
        // Création d'une instance de l'implémentation de l'interface RmiTrait
        RmiTraitImpl rmiTrait = new RmiTraitImpl();
        // Enregistrement de l'objet distant dans le registre RMI local avec un nom spécifique
        Naming.rebind("rmi://localhost:1125/RMI", rmiTrait);
        

        
        System.out.println("Server RMI started on port " + PORT);

    }

}
