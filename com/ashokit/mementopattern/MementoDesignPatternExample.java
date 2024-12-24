package com.ashokit.mementopattern;

import java.util.ArrayList;
import java.util.List;

public class MementoDesignPatternExample {
	
	static List<FeedBackMemento> stateList= new ArrayList<>();
	public static void main(String[] args) {
		FeedBackForm form= new FeedBackForm("Karthik","karthik.abc@gmail.com","Food is good");
		FeedBackCareTaker careTaker=new FeedBackCareTaker();
		stateList.add( careTaker.saveState(form));
		
		form.setName("Nitesh");
		form.setEmailId("Nitesh@gmail.com");
		form.setComment("form is filled");
		stateList.add( careTaker.saveState(form));
		form.setName("Rahul");
		form.setEmailId("Rahul@gmail.com");
		form.setComment("Rahul is good");
		stateList.add( careTaker.saveState(form));
		//careTaker.restoreState(form);
		
		for (int i = stateList.size()-1; i >=0; i--) {
			System.out.println(stateList.get(i).getName()+" "+stateList.get(i).getEmailId()+" "+stateList.get(i).getComment());
		}
	}

}

class FeedBackForm{
	private String name;
	private String emailId;
	private String comment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public FeedBackForm(String name, String emailId, String comment) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.comment = comment;
	}
	
	FeedBackMemento save(FeedBackForm form){
		FeedBackMemento memento= new FeedBackMemento(form.getName(),form.getEmailId(),form.getComment());
		return memento;
	}
	
	void restore(FeedBackMemento form){
		this.name=form.getName();
		this.emailId=form.getEmailId();
		this.comment=form.getComment();
		System.out.println("Name is "+name+" email id is "+emailId+" comments is "+comment);
	}
}

class FeedBackMemento{
	private String name;
	private String emailId;
	private String comment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public FeedBackMemento(String name, String emailId, String comment) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.comment = comment;
	}
	
}


class FeedBackCareTaker{
	FeedBackMemento memento;
	public FeedBackMemento saveState(FeedBackForm form) {
        memento = form.save(form);
        return memento;
    }

    public void restoreState(FeedBackForm form) {
        form.restore(memento);
    }
}
