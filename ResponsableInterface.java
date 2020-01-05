import java.util.List;
import java.rmi.RemoteException;
 import java.sql.*;
public interface ResponsableInterface  extends java.rmi.Remote { 

     List<Avis> getAvisList() throws RemoteException;
      boolean  AjouterAvis(String desc) throws RemoteException ;
      boolean modifierAvis(String desc,int id ) throws RemoteException;
      boolean SupprimerAvis(int id) throws RemoteException;
} 

