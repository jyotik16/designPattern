
public class AdapterPatternExample {
	
	public static void main(String[] args) {
		
		AshokIt as= new AshokIt();
		as.setPaymentType("UPI");
		as.setDetails("9898763212@axis");		
		
		PayTm p =PaymentAdapter.ConvertBillDeskToPaytm(as);
		
	}

}

interface BillDesk{
	void setPaymentType(String Paymenttype);
	String getPaymentType();
	
	void setDetails(String data);
	String getDetails();	
}

interface PayTm{
	void setTypeOfPayment(String Paymenttype);
	String getTypeOfPayment();
	
	void provideDetails(String data);
	String getDetails();	
}

interface RazoPay{
	void setTypeOfPayment(String Paymenttype);
	String getTypeOfPayment();
	
	void provideDetails(String data);
	String getDetails();	
}

class PaymentAdapter {
	static PayTm p=null;
	static RazoPay r=null;
	PaymentAdapter(PayTm p){
		this.p=p;
	}
	
	static PayTm ConvertBillDeskToPaytm(BillDesk b){
		
		p.setTypeOfPayment(b.getPaymentType());
		p.provideDetails(b.getDetails());
		return p;		
	}
	static RazoPay ConvertBillDeskToRazoPay(BillDesk b){
		
		r.setTypeOfPayment(b.getPaymentType());
		r.provideDetails(b.getDetails());
		return r;		
	}
}

class PaymentAdapterForRazopay {
	static PayTm p=null;
	PaymentAdapterForRazopay(PayTm p){
		this.p=p;
	}
	
	static PayTm ConvertBillDeskToPaytm(BillDesk b){
		
		p.setTypeOfPayment(b.getPaymentType());
		p.provideDetails(b.getDetails());
		return p;		
	}
}

class AshokIt implements BillDesk{

	String Paymenttype=null;
	String data=null;
	@Override
	public void setPaymentType(String Paymenttype) {
		// TODO Auto-generated method stub
		this.Paymenttype=Paymenttype;
	}

	@Override
	public String getPaymentType() {
		// TODO Auto-generated method stub
		return Paymenttype;
	}

	@Override
	public void setDetails(String data) {
		// TODO Auto-generated method stub
		this.data=data;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return data;
	}
	
}