package RmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Client  {

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
         // Recherche de l'objet distant dans le registre RMI
        RmiTrait stub = (RmiTrait) Naming.lookup("rmi://localhost:1125/RMI");
        
        //Ajout de quelques taches à l'objet distant

        //NB:Enlever le commentaire pour tester l'
        //Commentaire 1 Ajout et affichage
        /* 
        stub.addTask("jouer");
        stub.addTask("open");
        stub.addTask("close");

        // Récupération de la liste des tâches actuelles depuis l'obje
        List<String> tasks = stub.viewTasks();

        // Affichage des tâches
        for (String task : tasks){
            System.out.println(task);
        }*/
        //Fin commentaire 1
        

        //Suppression d'une tache

        //Enlever le commentaire pour supprimer la tache jouer et refaire l'affichage
        //Commentaire 2 Suppression et affichage
       /*  stub.removeTask("jouer");
        List<String> tasks = stub.viewTasks();

        for (String task : tasks){
            System.out.println(task);
        }*/
        //Fin commentaire 2



    }
}
