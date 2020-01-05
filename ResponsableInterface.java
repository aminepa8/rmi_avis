import java.util.List;
import java.rmi.RemoteException;
 import java.sql.*;
public interface ResponsableInterface  extends java.rmi.Remote { 

     List<Avis> getAvisList() throws RemoteException;
      boolean  AjouterAvis(String desc) throws RemoteException ;
} 

