 import java.sql.*;
 //import com.mysql.*;
import java.util.*;  
import java.rmi.RemoteException;
public class ResponsableImpl extends 
      java.rmi.server.UnicastRemoteObject implements ResponsableInterface { 
	Connection con;
	Statement stmt;
	ResultSet rs;
    public ResponsableImpl() 
        throws java.rmi.RemoteException { 
        super(); 
    } 
 
    // Implementing the interface method 
   public List<Avis> getAvisList() throws RemoteException {  
      List<Avis> list = new ArrayList<>();

      String DB_URL = "jdbc:mysql://localhost:3306/detailsAvis";  
      

      
      //Register JDBC driver 
      try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
      
      //Open a connection
      System.out.println("Connecting to a selected database..."); 
       
	try {
		con = DriverManager.getConnection(  
				  "jdbc:mysql://localhost:3306/detailsavis","root","");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
      System.out.println("Connected database successfully...");  
      
      //Execute a query 
      System.out.println("Creating statement..."); 
      
      
	try {
		stmt = con.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
      String sql = "SELECT * FROM avis"; 
      
	try {
		rs = stmt.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
      
      //Extract data from result set 
      try {
		while(rs.next()) { 
		     // Retrieve by column name 
		     int id  = rs.getInt("id"); 
		     
		     String avisElement = rs.getString("avis_desc");  
		     
   
		     
		     // Setting the values 
		     Avis LstAvis = new Avis(); 
		     LstAvis.setID(id); 
		     LstAvis.setAvis(avisElement); 
		     
		     list.add(LstAvis); 
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
      try {
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
      return list;   
   }  

    //Ajout
   public boolean AjouterAvis(String desc) throws RemoteException {
        String sql = "INSERT INTO Avis (avis_desc) VALUES (?)";
        boolean rowInserted =false;
         try{
            PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, desc);
         
         rowInserted = statement.executeUpdate() > 0;
        statement.close();
         }catch(SQLException e){
             e.printStackTrace();
                      }
        return rowInserted;
    }
    public boolean modifierAvis(String desc,int id ) throws RemoteException {
        String sql = "UPDATE avis SET avis_desc = ?";
        sql += " WHERE id = ?";
        boolean rowUpdated=false;
        try{
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, desc);
            statement.setInt(2, id);
            rowUpdated = statement.executeUpdate() > 0;
            statement.close();
            return rowUpdated;   
        } catch(SQLException e){
             e.printStackTrace();
                      }
        return rowUpdated;   
          
    }

    
} 

