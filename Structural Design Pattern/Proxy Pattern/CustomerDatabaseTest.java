import java.io.*;
import java.util.*;
class Customer{
    private String id;
    private String name;
    private String email;
    private String city;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    Customer(String id,String name,String city,String email){
        this.name=name;
        this.city=city;
        this.email=email;
        this.id=id;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

interface CustomerDatabaseService{
    Customer getCustomerDetail(String custId) throws IOException;
}

class CustomerService implements CustomerDatabaseService{

    @Override
    public Customer getCustomerDetail(String custId) throws IOException {
        //Open the file CustomerDetails.txt
        //Read the records - search for custId
        Customer c1=null;
        BufferedReader br=new BufferedReader(new FileReader("CustomerDetails.txt"));
        String line;
        while((line= br.readLine())!=null){
            StringTokenizer st=new StringTokenizer(line," ");

            if(Objects.equals(st.nextToken(), custId)){
                String[] custArray=new String[st.countTokens()];

                int i=0;
                while(st.hasMoreTokens()){
                    custArray[i]=st.nextToken();
                    i++;
                }
                c1=new Customer(custId,custArray[0],custArray[1],custArray[2]);
            }

            line=br.readLine();
        }

        //intialize customer object for particular custId
        //return the customer
        return c1;
    }
}

class CustomerServiceProxy implements CustomerDatabaseService{

    CustomerService cs=new CustomerService();
    @Override
    public Customer getCustomerDetail(String custId) throws IOException {
        Customer c1=null;
        //create a file logUserInfo.txt for storing user log.
        Scanner sc =new Scanner(System.in);
        String username,userid,role;
        System.out.println("Enter your id:");
        userid=sc.nextLine();
        System.out.println("Enter your name:");
        username=sc.nextLine();
        System.out.println("Enter your role:");
        role=sc.nextLine();

        try{
            Writer fw=new FileWriter("logUserInfo",true);
            fw.write(userid+" "+username+"\n");
            fw.close();
        }catch (IOException ignored){}

        if(Objects.equals(role, "Manager")){
            c1=cs.getCustomerDetail(custId);
        }


        return c1;
    }
}

class CustomerDatabaseTest{
    public static void main(String[] args) throws IOException {
        CustomerService cs=new CustomerService();
        Customer c=null;
        CustomerServiceProxy csp =new CustomerServiceProxy();
        c=csp.getCustomerDetail("CU103");
//        c=cs.getCustomerDetail("CU103");
        System.out.println(c);
    }
}