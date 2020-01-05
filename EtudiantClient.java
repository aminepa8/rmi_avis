import java.util.List;
import java.rmi.Naming; 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 
 
public class EtudiantClient { 
 
    public static void main(String[] args) { 
        try { 
    
            Registry reg = LocateRegistry.getRegistry("localhost",1099);
            EtudiantInterface c = (EtudiantInterface) reg.lookup("rmi://localhost/EtudiantService");
            System.out.println("=======================(Avis)========================" );
            
            List<Avis> list =  c.getAvisList(); //(List<Avis>)
         for (Avis s:list) { 
            
            // System.out.println("bc "+s.getBranch()); 
            System.out.println("ID: " + s.getId()); 
            System.out.println("Avis : " + s.getAvis()); 

         }
        } 
        catch (Exception e) { 
           e.printStackTrace();
    } 
        } 
    
} 

