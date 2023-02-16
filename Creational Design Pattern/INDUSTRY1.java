import java.util.List;
import java.util.ArrayList;

class Industry {
    private String name;
    private List<Applicant> applicants;

    public Industry(String name) {
        this.name = name;
        this.applicants = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Applicant> getApplicants() {
        return this.applicants;
    }

    public void addApplicant(Applicant applicant) {
        this.applicants.add(applicant);
    }

    public void printApplicants(){
        System.out.println("Applicants for industry " + name + ":");
        for (Applicant applicant : applicants) {
            System.out.println(((Industry) applicants).getName());
        }
    }

    public List<Applicant> printApplcantsWithExperienceMoreThan5Years(){
        System.out.println("Applicants for industry " + name + " having experience more than 5 years are: ");
        for (Applicant applicant : applicants) {
            if(applicant.getExperience()>=5){
                System.out.println(applicant.getName()+" -> Experience :"+applicant.getExperience());
            }
            
        }
        return applicants;
    }
}

class Applicant {
    private String name;
    private int experience;
    private ContactDetails contactDetails;

    public Applicant(String name, int experience, ContactDetails contactDetails) {
        this.name = name;
        this.experience = experience;
        this.contactDetails = contactDetails;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

     public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }
}

class ContactDetails {
    private String phoneNumber;
    private String email;

    public ContactDetails(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class INDUSTRY1{
    public static void main(String[] args) {
        Industry IT =new Industry("IT");
        Applicant a1=new Applicant("Shubham Patel", 5, new ContactDetails("99999999", "geayufgaufbay.com"));
        IT.addApplicant(a1);
        Applicant a2=new Applicant("dev sapariya", 1,new ContactDetails("8888888888", "neghsufughfbuyeaga.com"));
        IT.addApplicant(a2);
        Applicant a3=new Applicant("soban", 10,new ContactDetails("0000000000", "vndvjhvuwBVYG.com"));
        IT.addApplicant(a3);

    }
}