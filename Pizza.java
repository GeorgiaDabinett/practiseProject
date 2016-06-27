import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.TableView;
/**
 * Write a description of class Pizza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pizza
{
    public int id;
    public String name;
    public Boolean vegetarian;
    public String toppings;
    public String base;
    
    public Pizza(int id, String name, String toppings, Boolean vegetarian,String base){
        this.id=id;
        this.name=name;
        this.vegetarian=vegetarian;
        this.toppings=toppings;
        this.base=base;
    }
    
    // instance variables - replace the example below with your own
    public static void readAll(List<Pizza> list){
        list.clear();       // Clear the target list first.

        /* Create a new prepared statement object with the desired SQL query. */
        PreparedStatement statement = Application.database.newStatement("SELECT id, name, toppings, vegetarian, base FROM type"); 

        if (statement != null)      // Assuming the statement correctly initated...
        {
            ResultSet results = Application.database.runQuery(statement);       // ...run the query!

            if (results != null)        // If some results are returned from the query...
            {
                try {                               // ...add each one to the list.
                    while (results.next()) {                                               
                        list.add( new Pizza(results.getInt("id"), 
                                results.getString("name"), 
                                results.getString("toppings"),
                                results.getBoolean("vegetarian"),
                                results.getString("base") ));
                    }
                }
                catch (SQLException resultsexception)       // Catch any error processing the results.
                {
                    System.out.println("Database result processing error: " + resultsexception.getMessage());
                }
            }
        }
    }
    public static void remove(int iD){
        PreparedStatement statement =Application.database.newStatement("");
        
    }
    public static void add(int iD, String name,String toppings,int base){
        PreparedStatement statement =Application.database.newStatement("INSERT INTO Type(id,name,Toppings,vegetarian, base) VALUES("+name+","+toppings+","+base+");");
        
    }
    public static void search(int iD){
        PreparedStatement statement =Application.database.newStatement("SELECT id, name, toppings, vegetarian, base FROM type WHERE id="+iD);
        
    }
}
