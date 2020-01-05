import java.util.*;
import java.rmi.Naming; 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 
 
public class ResponsableClient { 
 
    public static void main(String[] args) { 
        try { 
            int userChoice;
            Registry reg = LocateRegistry.getRegistry("localhost",1099);
            ResponsableInterface c = (ResponsableInterface) reg.lookup("rmi://localhost/RespnsableService");
            
            
            List<Avis> list =  c.getAvisList(); //(List<Avis>)
            userChoice = menu();
            switch (userChoice) {

                case 1:
                    AfficherAvis(list);
                    break;
                default:
                    System.out.println("Choix Invalide"); 
            }
        } 
        catch (Exception e) { 
           e.printStackTrace();
    } 
        } 


    public static void AfficherAvis(List<Avis> list){
        System.out.println("=======================(Avis)========================" );
        for (Avis s:list) { 
            
            // System.out.println("bc "+s.getBranch()); 
            System.out.println("ID: " + s.getId()); 
            System.out.println("Avis : " + s.getAvis()); 

         }
         System.out.println("=======================(Fin-Avis)========================" );
    }
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/
        
        System.out.println("*********************MENU**************************");
        System.out.println("-------------------------\n");
        System.out.println("1 - Afficher la lite des Avis");
        System.out.println("2 - Ajouter une Avis");
        System.out.println("3 - Modifier Une Avie");
        System.out.println("4 - Supprimer Une Avie");
        System.out.println("4 - Quit");
        System.out.println("***********************************************");
        System.out.print("Saisir Votre Choix : ");
        selection = input.nextInt();
        return selection;    
    }
    
} 

