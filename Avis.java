import java.io.Serializable;
public class Avis implements Serializable{
   private static final long serialVersionUID = 1L;
   private int id ;
   private String AvisDesc;
   
  public Avis(String AvisDesc){
     this.AvisDesc = AvisDesc; 
      }
      public Avis(){
     
      }
   public int getId() { 
      return id; 
   } 
   public String getAvis() { 
      return AvisDesc; 
   } 
  
   public void setID(int id) { 
      this.id = id; 
   } 
   public void setAvis(String AvisDesc) { 
      this.AvisDesc = AvisDesc; 
   } 
   
   } 
