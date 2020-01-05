
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

   public Server() {
     try {
    	 
    	 Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
         
    	 EtudiantImpl EtudiantStub = new EtudiantImpl();
       ResponsableImpl ResponsableStub = new ResponsableImpl();
         
         reg.rebind("rmi://localhost/EtudiantService", EtudiantStub);
         reg.rebind("rmi://localhost/RespnsableService", ResponsableStub);
    
       System.err.println("Server ready"); 
     } catch (Exception e) {
       System.out.println("Trouble: " + e);
     }
   }

   public static void main(String args[]) {
     new Server();
   }
}


