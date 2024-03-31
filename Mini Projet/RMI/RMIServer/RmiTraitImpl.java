package RmiServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RmiTraitImpl extends UnicastRemoteObject implements RmiTrait   {

    // Liste pour stocker les tâches
    private List<String> tasks;


    // Constructeur qui initialise la liste des tâches
    public RmiTraitImpl() throws RemoteException {
        tasks = new ArrayList<String>();
    }
    // Méthode pour ajouter une tâche à la liste
    @Override
    public void addTask(String task) throws RemoteException {
        tasks.add(task);
       
    }
    // Méthode pour supprimer une tâche de la liste
    @Override
    public void removeTask(String task) throws RemoteException {
      tasks.remove(task);
    }
    // Méthode pour afficher les tâches actuellement enregistrées
    @Override
    public List<String> viewTasks() throws RemoteException {
        
        return tasks;    
    }
    

   
    


}
