package t2;




import java.util.ArrayList;
import java.util.List;

public class MementoDesignPatternExample {
	
	String name;
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
	public String getComplaintText() {
		return complaintText;
	}
	public void setComplaintText(String complaintText) {
		this.complaintText = complaintText;
	}
	String email;
	String complaintText;

	public MementoDesignPatternExample(String name,String email,String complainttext) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.email=email;
		this.complaintText=complainttext;
		
	}
	
	Memento saveMemento(){
		 System.out.println("Originator: Saving to Memento.");
		return new Memento(name,email,complaintText);
	}
	
	String restoreMemento(Memento m){
		return m.getStateOfObject();
	}
	
	static class Memento{
		String name;
		String email;
		String complaintText;
		public Memento(String name, String email, String complaintText) {
			
			this.name = name;
			this.email = email;
			this.complaintText = complaintText;
		}
		
		private String getStateOfObject() {
            return "Name is "+this.name +" and Email is "+this.email+" and complaint TeXt is"+complaintText;
        }
		
	}
	
	public static void main(String[] args) {
		List<MementoDesignPatternExample.Memento> stateList= new ArrayList<MementoDesignPatternExample.Memento>();
		MementoDesignPatternExample m=new MementoDesignPatternExample("Ranjeet", "123.ashok@gmail.com","Hi Guys" );
		
		stateList.add(m.saveMemento());
		m.setName("Vikas");
		m.setEmail("Vikas.ashok@gmail.com");
		m.setComplaintText("Thanks for Teaching");
		stateList.add(m.saveMemento());
		m.setName("Abhishek");
		m.setEmail("Abhishek.ashok@gmail.com");
		m.setComplaintText("How r u");
		stateList.add(m.saveMemento());
		for (int i = stateList.size()-1; i >=0; i--) {
			System.out.println(m.restoreMemento(stateList.get(i)));
		}
		//System.out.println(m.restoreMemento(stateList.get(stateList.size()-3)));;
	}
}

