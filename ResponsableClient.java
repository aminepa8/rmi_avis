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
                case 0:
                    break;
                case 1:
                    clearScreen();
                    AfficherAvis(list);
                    break;
                case 2:
                   clearScreen();
                   boolean Test =  c.AjouterAvis(Ajouter_avis()); // HAHA confusing
                   if(Test){
                       System.out.println("<<<<<<<Bien Effectue>>>>>>>");
                        menu();
                   }else{
                       System.out.println("<<<<<<<<Problem>>>>>>>>>>>>>");
                        menu();
                   }
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
            System.out.println("ID: " + s.getId()); 
            System.out.println("Avis : " + s.getAvis()); 

         }
         System.out.println("=======================(Fin-Avis)========================" );
    }
    public static String Ajouter_avis()  {
        String AvisDescription ="";
      Scanner input = new Scanner(System.in);
      System.out.println("Saisire Avis : " );
       AvisDescription= input.nextLine();
      return AvisDescription;
    }
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/
        
        System.out.println("*********************MENU**************************");
        System.out.println("[1] - Afficher la lite des Avis");
        System.out.println("[2] - Ajouter une Avis");
        System.out.println("[3] - Modifier Une Avie");
        System.out.println("[4] - Supprimer Une Avie");
        System.out.println("[0] - Quit");
        System.out.println("***********************************************");
        System.out.print("Saisir Votre Choix : ");
        selection = input.nextInt();
        return selection;    
    }
    
    ///For later use Zwa9 and stuff
    public static void clearScreen() {   
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  
} 

