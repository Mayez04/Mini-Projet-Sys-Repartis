package RmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RmiTrait extends Remote {
    public void addTask(String task) throws RemoteException;
    public void removeTask(String task) throws RemoteException;
    List<String> viewTasks() throws RemoteException;
    



}
