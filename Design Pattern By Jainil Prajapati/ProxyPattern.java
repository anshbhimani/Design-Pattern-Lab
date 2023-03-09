import java.io.*;
import java.util.Date;
import java.util.Scanner;

class Customer{
	private String CustID;
	private String Name;
	private String Role;
	
	Customer(String CustID,String Name,String Role){
		this.CustID = CustID;
		this.Name = Name;
		this.Role = Role;
	}
	
	public String getID(){
		return this.CustID;
	}
	
	public String toString(){
		return "Customer ID: "+this.CustID
				+"\n------------------------------"
				+"\nCustomer Name: "+this.Name
				+"\nCustoer Role:  "+this.Role;
	}
}

interface CustomerServiceInterface{

	public Customer getCustomerDetaile(String CustID);
	
}

class CustomerService implements CustomerServiceInterface{

	@Override
	public Customer getCustomerDetaile(String CustID) {
		BufferedReader fr = null;
		try{
			File f = new File("E:/PDPU/Semester - 4/Design & Pattern/Practical/src/Customers.txt");
			fr = new BufferedReader(new FileReader(f));
			
			String i = "";
			while(i != null){
				i = fr.readLine();
				if(i == null){
					return new Customer(null,null,null);
				}
				if(i.split(";")[0].equalsIgnoreCase(CustID)){
					return new Customer(i.split(";")[0],i.split(";")[1],i.split(";")[2]);
				}
				
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
		
	}

}

class CustomerServiceProxy implements CustomerServiceInterface{

	CustomerServiceInterface service = new CustomerService();
	
	public boolean checkAccess(){
		System.out.println("Enter Your Role: ");
		
		if(new Scanner(System.in).next().equalsIgnoreCase("Manager")){
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomerDetaile(String CustID) {
		if(checkAccess()){
			BufferedWriter fr = null;
			try{
				File f = new File("E:/PDPU/Semester - 4/Design & Pattern/Practical/src/UserLog.txt");
				fr = new BufferedWriter(new FileWriter(f));
				
				String i = "{User ID = "+CustID+" is arrived at "+new Date().toLocaleString()+"}";
			
				
				
				fr.write(i);
				fr.flush();
				
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try {
					fr.close();
					Customer c1 = service.getCustomerDetaile(CustID);
					return c1;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			return null;
	}
}

public class ProxyPattern {

	public static void main(String[] args) {
		
		CustomerServiceProxy cs = new CustomerServiceProxy();
		Customer c = cs.getCustomerDetaile("C00q");
		if(c != null && c.getID() != null){
			System.out.println(c);
		}
		else if(c.getID() == null){
			System.out.println("No User Founded which you searched");
		}
		else{
			System.out.println("You Don't Have Permission to do this operation");
		}
	}

}
	