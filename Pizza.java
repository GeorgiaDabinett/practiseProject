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
    public int getId(){
        return id;
    }

    @Override
    public String toString()
    {
        return name;
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

    public static void deleteById(int id)
    {
        try 
        {

            PreparedStatement statement = Application.database.newStatement(
                    "DELETE FROM type WHERE id = ?");             

            statement.setInt(1, id);

            if (statement != null)
            {
                Application.database.executeUpdate(statement);
            }
        }
        catch (SQLException resultsexception)
        {
            System.out.println("Database result processing error: " 
                + resultsexception.getMessage());
        }

    }

    public void save()    
    {
        PreparedStatement statement;
        try 
        {
            if (id == 0)
            {
                statement = Application.database.newStatement("SELECT id FROM type ORDER BY id DESC");             
                if (statement != null)  
                {
                    ResultSet results = Application.database.runQuery(statement);
                    if (results != null)
                    {
                        id = results.getInt("id") + 1;
                    }
                }

                statement = Application.database.newStatement("INSERT INTO type (id, name, toppings, vegetarian, base) VALUES (?, ?, ?, ?, ?)");             
                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setString(3, toppings); 
                statement.setBoolean(4, vegetarian);
                statement.setString(5, base);
            }
            else
            {
                statement = Application.database.newStatement("UPDATE type SET  id = ? ,name = ?, toppings=?, base=? , vegetarian=? WHERE id = ?");             
                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setString(3, toppings); 
                statement.setBoolean(4, vegetarian);
                statement.setString(5, base);
            }
            if (statement != null)
            {
                Application.database.executeUpdate(statement);
            }
        }
        catch (SQLException resultsexception)
        {
            System.out.println("Database result processing error: " + resultsexception.getMessage());
        }
    }

    public static Pizza getById(int id)
    {
        Pizza Pizza = null;
        PreparedStatement statement = Application.database.newStatement(
                "SELECT id, name, toppings, vegetarian, base FROM type WHERE id = ?"); 
        try 
        {
            if (statement != null) 
            {
                statement.setInt(1, id);
                ResultSet results = Application.database.runQuery(statement);
                if (results != null) 
                {
                    Pizza = new Pizza(results.getInt("id"), 
                        results.getString("name"), 
                        results.getString("toppings"),
                        results.getBoolean("vegetarian"),
                        results.getString("base") );
                }
            }
        }
        catch (SQLException resultsexception)
        {
            System.out.println("Database result processing error: " 
                + resultsexception.getMessage());
        }
        return Pizza;
    }}
