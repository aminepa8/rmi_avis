 import java.sql.*;
 //import com.mysql.*;
import java.util.*;  
import java.rmi.RemoteException;
public class EtudiantImpl extends 
      java.rmi.server.UnicastRemoteObject 
    implements EtudiantInterface { 
	Connection con;
	Statement stmt;
	ResultSet rs;
    public EtudiantImpl() 
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
} 

