import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class Customer
{
    String id, name, email, city;
    //constructor
    public Customer(String id, String name, String email, 
    String city) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.city = city;
    }
 
    public String getId() {
    return id;
    }

    public void setId(String id) {
    this.id = id;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public String getCity() {
    return city;
    }

    public void setCity(String city){
    this.city = city;
    }
}

interface CustomerDatabaseService
{
    Customer getCustomerDetail(String custId);
}


class CustomerService implements CustomerDatabaseService
{
    @Override
    public Customer getCustomerDetail(String custId) 
    {
        if (custId.equals("CU101")) 
        {
            return new Customer("CU101", "John Doe", "johndoe@example.com", "New York");
        } 
        
        else if (custId.equals("CU102"))
        {
            return new Customer("CU102", "Jane Smith", "janesmith@example.com", "London");
        } 
        
        else 
        {
            return null;
        }
    }
}

class CustomerServiceProxy implements CustomerDatabaseService
{
    CustomerService cs = new CustomerService();
    @Override
    public Customer getCustomerDetail(String custId) 
    {
        try 
        {
            BufferedWriter writer = new BufferedWriter(new
            FileWriter("logUserinfo.txt", true));
            String logMessage = String.format("User %s accessed customer details on %s", "user123", new Date());
            writer.write(logMessage);
            writer.newLine();
            writer.close();
        } 
        
        catch (IOException e) 
        {
            System.err.println("Error writing to log file: " +
            e.getMessage());
        }
        String userRole = "manager";

        if (userRole.equals("manager")) 
        {
            return cs.getCustomerDetail(custId);
        } 
        
        else 
        {
            System.out.println("Access denied");
            return null;
        }
    }
}

public class CustomerDatabaseTest2
{
    public static void main(String[] args) 
    {
        CustomerDatabaseService cs = new
        CustomerServiceProxy();
        cs.getCustomerDetail("CU102");
    }
}
