class HardWareEngineer{
	ComputerBuilder cb;
	
	HardWareEngineer(ComputerBuilder c){
		this.cb = c; 
		cb.configerCompanyName();
		cb.configerHDDSize();
		cb.configerMonitorSize();
		cb.configerMonitorType();
		cb.configerProcessorName();
		cb.configerOSName();
		cb.configerRAMSize();
	}

}

abstract class ComputerBuilder{
	Computer computer1;
	
	abstract public void configerOSName();
	abstract public void configerRAMSize();
	abstract public void configerHDDSize();
	abstract public void configerMonitorSize();
	abstract public void configerMonitorType();
	abstract public void configerProcessorName();
	abstract public void configerCompanyName();
}

class ServerComputerBuilder extends ComputerBuilder{
	 
	ServerComputerBuilder(){
		computer1 = new Computer("S011220");
	}

	public Computer GetComputer(){
		return computer1;
		
	}

	@Override
	public void configerOSName() {
		
		computer1.SetOSName("Linux");
	}

	@Override
	public void configerRAMSize() {
		computer1.SetRAMSize(16);
	}

	@Override
	public void configerHDDSize() {
		computer1.SetHDDSize(1000);
	}

	@Override
	public void configerMonitorSize() {
		computer1.SetMonitorSize(32);
	}

	@Override
	public void configerMonitorType() {
		computer1.SetMonitorType("LCD");
	}

	@Override
	public void configerProcessorName() {
		computer1.SetProcessorName("AMD16");
	}

	@Override
	public void configerCompanyName() {
		computer1.SetCompanyName("ServerComputer");
	}
	
}

class PersonalComputerBuilder extends ComputerBuilder{

	PersonalComputerBuilder(){
		computer1 = new Computer("P100837");
	}
	
	
	public Computer GetComputer(){
		return computer1;
		
	}

	@Override
	public void configerOSName() {
		computer1.SetOSName("Windows");
	}

	@Override
	public void configerRAMSize() {
		computer1.SetRAMSize(8);
	}

	@Override
	public void configerHDDSize() {
		computer1.SetHDDSize(100);
	}

	@Override
	public void configerMonitorSize() {
		computer1.SetMonitorSize(26);
	}

	@Override
	public void configerMonitorType() {
		computer1.SetMonitorType("AMOLD");
	}

	@Override
	public void configerProcessorName() {
		computer1.SetProcessorName("Intel12");
	}

	@Override
	public void configerCompanyName() {
		computer1.SetCompanyName("HP");
	}
	
}

class Computer{
	String ComputerID;
	private int HDDSize;
	private int RAMSize;
	private int MonitorSize;
	private String MonitorType;
	private String ProcessorName;
	private String OSName;
	private String CompanyName;
	
//	setter methods
	public void SetHDDSize(int size){
		this.HDDSize = size;
	}
	
	public void SetRAMSize(int size){
		this.RAMSize = size;
	}
	
	public void SetMonitorSize(int size){
		this.MonitorSize = size;
	}
	
	public void SetMonitorType(String type){
		this.MonitorType = type;
	}
	
	public void SetProcessorName(String Name){
		this.ProcessorName = Name;
	}
	
	public void SetOSName(String Name){
		this.OSName = Name;
	}
	
	public void SetCompanyName(String Name){
		this.CompanyName = Name;
	}
	
//	one constructor
	Computer(String ComputerID){
		this.ComputerID = ComputerID;
	}
	
	public String toString(){
		return "Your Computer ID = " + this.ComputerID 
				+"\n----------------------------------------------------------"
				+"\nYour Computer Company Name = " + this.CompanyName 
				+"\nYour HDD Size = " + this.HDDSize 
				+"\nYour RAM Size = " + this.RAMSize 
				+"\nYour Monitor Size = " + this.MonitorSize 
				+"\nYour Monitor Type = "+this.MonitorType
				+"\nYour Processor Name = "+this.ProcessorName
				+"\nYour Processor Name = "+this.OSName;
	}
}

public class BuilderDesignPattern {
	public static void main(String[] args){
		PersonalComputerBuilder pcb = new PersonalComputerBuilder();
		new HardWareEngineer(pcb);
		
		System.out.println(pcb.GetComputer());
		
	}
}
