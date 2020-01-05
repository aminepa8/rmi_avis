import java.util.List;
import java.rmi.RemoteException;
public interface ResponsableInterface  extends java.rmi.Remote { 

     List<Avis> getAvisList() throws RemoteException;
} 

