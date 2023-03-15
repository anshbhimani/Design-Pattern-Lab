interface GUIFactory{
	public Button CreateButton();
	public Checkbox CreateCheckbox();
}

class WinFactory implements GUIFactory{

	public WinFactory CreateWinProduct(String product){
		switch(product){
			case "Button":{
				return (WinFactory) CreateButton();
			}
			case "Checkbox":{
				return (WinFactory) CreateCheckbox();
			}
			default:{
				return null;
			}
		}
	}
	
	@Override
	public Button CreateButton() {
		return new WinButton();
	}

	@Override
	public Checkbox CreateCheckbox() {
		return new WinCheckbox();
	}
	
}

class MacFactory implements GUIFactory{

	public MacFactory CreateMacProduct(String product){
		switch(product){
			case "Button":{
				return (MacFactory) CreateButton();
			}
			case "Checkbox":{
				return (MacFactory) CreateCheckbox();
			}
			default:{
				return null;
			}
		}
	}
	
	@Override
	public Button CreateButton() {
		return new MacButton();
	}

	@Override
	public Checkbox CreateCheckbox() {
		return new MacCheckbox();
	}
	
}

interface Button{
	public void Features();
}

interface Checkbox{
	public void Features();
}

class WinButton extends WinFactory implements Button{
	WinButton(){
		System.out.println("Window's Button is Create");
		 Features();
	}

	@Override
	public void Features() {
		System.out.println("Windows button will be sqare and your can click this button also");
	}
}

class WinCheckbox extends WinFactory implements Checkbox{
	WinCheckbox(){
		System.out.println("Window's Checkbox is Create");
		 Features();
	}

	@Override
	public void Features() {
		System.out.println("Windows checkbox will be sqare and your can check and uncheck it also");
	}
}

class MacButton extends MacFactory implements Button{
	MacButton(){
		System.out.println("Mac's Button is Create");
		Features();
	}

	@Override
	public void Features() {
		System.out.println("Mac's  button will be rounded Ractangual and your can click this button also");
	}
}

class MacCheckbox extends MacFactory implements Checkbox{
	MacCheckbox(){
		System.out.println("Mac's Checkbox is Create");
		Features();
	}

	@Override
	public void Features() {
		System.out.println("Mac's checkbox will be round ranctangual and your can check and uncheck it also");
	}
}


public class GUIFactoryProduct {

	public static void main(String args[]){
		WinFactory wf = new WinFactory();
		MacFactory mf = new MacFactory();
		
		wf.CreateButton();
		mf.CreateCheckbox();
		
	}
	
}
