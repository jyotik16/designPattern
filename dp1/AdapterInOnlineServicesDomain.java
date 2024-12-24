import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Enumeration;

public class AdapterInOnlineServicesDomain {
	public static void main(String[] args) {
		
	}

}

//Third-party email marketing service interface
interface ThirdPartyEmailMarketingService {
 public void sendEmail(String to, String subject, String body);
}

//Internal marketing system interface
 interface InternalMarketingSystem {
 public void addContact(String email);
 public void sendCampaign(String subject, String body);
}

//Third-party email marketing service implementation
 class ThirdPartyEmailMarketingServiceImpl implements ThirdPartyEmailMarketingService {
 public void sendEmail(String to, String subject, String body) {
     System.out.println("Sending email to " + to + " with subject '" + subject + "' and body: " + body + " using third-party email marketing service...");
     // Implementation details...
 }
}

//Adapter class
class InternalMarketingSystemAdapter implements InternalMarketingSystem {
 private ThirdPartyEmailMarketingService emailService;

 public InternalMarketingSystemAdapter(ThirdPartyEmailMarketingService emailService) {
     this.emailService = emailService;
 }

 public void addContact(String email) {
     System.out.println("Adding contact with email " + email + " to internal marketing system...");
     // Implementation details...
 }

 public void sendCampaign(String subject, String body) {
     // Convert the internal campaign format to the format expected by the third-party service
     String formattedBody = "Dear [NAME],\n\n" + body;

     System.out.println("Sending campaign with subject '" + subject + "' and body: " + formattedBody + " using third-party email marketing service...");
     // Send the email using the third-party service
     emailService.sendEmail("[EMAIL]", subject, formattedBody);
 }
}

