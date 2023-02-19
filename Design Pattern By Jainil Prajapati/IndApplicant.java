import java.util.ArrayList;
import java.util.Iterator;

class Industry{
	String name;
	int NoOfJobs;
	ArrayList<Applicant> applicants = new ArrayList<Applicant>();
	
	Industry(String name,int NoOfJobs,Applicant applicants[]){
		this.name = name;
		this.NoOfJobs = NoOfJobs;
		
		for(int i = 0 ; i <= applicants.length - 1; i++){
			this.applicants.add(applicants[i]);
		}
		
	}
	
	void PrintDetailsByExperience(int experience){
		Iterator ir = applicants.iterator();
		
		while(ir.hasNext()){
			Applicant a = (Applicant)ir.next();
			if(a.NoOfExperince == experience){				
				System.out.print("Name: "+ a.name +" | Experince: " +a.NoOfExperince);
				a.contact.GetDetails();
				System.out.println();
			}
		}
	}
	
	void PrintAllApplicants(){
		Iterator ir = applicants.iterator();
		
		while(ir.hasNext()){
			Applicant a = (Applicant)ir.next();		
			System.out.println("Name: "+ a.name +" | Experince: " +a.NoOfExperince);
			a.contact.GetDetails();
		}
	}
}


class Applicant{
	String name;
	ContactDetails contact = null;
	int NoOfExperince;
	
	Applicant(String name,int NoOfExperince,ContactDetails c){
		this.name = name;
		this.NoOfExperince = NoOfExperince;
		contact = c;
	}
	
}

class ContactDetails{
	
	private long MobileNo;
	private String Email;
	
	public ContactDetails(long MobileNo , String Email){
		this.MobileNo = MobileNo;
		this.Email = Email;
	}
	
	public void GetDetails(){
		System.out.print(" | MobileNo : "+this.MobileNo +" | Email: "+this.Email);
	}
}

public class IndApplicant {

	public static void main(String args[]){
		Applicant forit[] = {
								new Applicant("Jainil",5,new ContactDetails(2343242,"Jainil@123")),
								new Applicant("Vishesh",4,new ContactDetails(4364532,"Vishesh@123")),
								new Applicant("Abhisht",6,new ContactDetails(32445634,"Abhisht@123")),
								new Applicant("Jatin",7,new ContactDetails(23642354,"Jatin@123")),
								new Applicant("Dhruv",6,new ContactDetails(2342353,"Dhruv@123")),
								new Applicant("Kishan",5,new ContactDetails(643324,"Kishan@123")),
								new Applicant("Jignesh",5,new ContactDetails(756734,"Jignesh@123"))
							};
		
		Applicant foram[] = {
								new Applicant("Jainil",3,new ContactDetails(32453465,"Jainil@123")),
								new Applicant("Vishesh",2,new ContactDetails(235346,"Vishesh@123")),
								new Applicant("Abhisht",3,new ContactDetails(2343242,"Abhisht@123")),
								new Applicant("Jatin",6,new ContactDetails(2343242,"Jatin@123")),
								new Applicant("Dhruv",3,new ContactDetails(2343242,"Dhruv@123")),
								new Applicant("Kishan",1,new ContactDetails(2343242,"Kishan@123")),
								new Applicant("Jignesh",4,new ContactDetails(2343242,"Jignesh@123"))
							};
		
		Industry IT = new Industry("IT Industry",30,forit);
		Industry AutoMobile = new Industry("Auto Mobile Industry",30,foram);
		
		IT.PrintDetailsByExperience(5);
		System.out.println("\n------------------------------------------------------------\n");
		AutoMobile.PrintDetailsByExperience(3);
		
	}
	
}
