package t2;

public class MemExample {

	public static void main(String[] args) {
		FeedbackForm form = new FeedbackForm("Karthik", "karthik.abc@gmail.com", "Food is good");
		FeedbackFormCaretaker caretaker = new FeedbackFormCaretaker();
		caretaker.saveState(form);

		// User edits feedback
		form.setName("Nitech");
		form.setEmail("Nitesh@gmail.com");
		form.setComments("Form is filled");
		// User decides to undo changes
		caretaker.restoreState(form);
		

	}
	 public static void submitFeedback(FeedbackForm form) {
	        //FeedbackMemento memento = createMemento();
	        // code to save memento to database or file
	    }
}

class FeedbackForm {
    private String name;
    private String email;
    private String comments;

    public FeedbackForm(String name, String email, String comments) {
        this.name = name;
        this.email = email;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getComments() {
        return comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public FeedbackFormMemento save() {
        return new FeedbackFormMemento(name, email, comments);
    }

    public void restore(FeedbackFormMemento memento) {
        this.name = memento.getName();
        this.email = memento.getEmail();
        this.comments = memento.getComments();
        System.out.println(" name "+this.name+" email "+email+" comments "+comments);
    }
}
class FeedbackFormMemento {
    private String name;
    private String email;
    private String comments;

    public FeedbackFormMemento(String name, String email, String comments) {
        this.name = name;
        this.email = email;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getComments() {
        return comments;
    }
}
class FeedbackFormCaretaker {
    private FeedbackFormMemento memento;

    public void saveState(FeedbackForm form) {
        memento = form.save();
    }

    public void restoreState(FeedbackForm form) {
        form.restore(memento);
    }
}

