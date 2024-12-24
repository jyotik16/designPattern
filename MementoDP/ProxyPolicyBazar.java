package t2;


interface InsurancePolicy {
    String getName();
    String getDescription();
    double getPremium();
}

class InsurancePolicyImpl implements InsurancePolicy {
    private String name;
    private String description;
    private double premium;

    public InsurancePolicyImpl(String name, String description, double premium) {
        this.name = name;
        this.description = description;
        this.premium = premium;
        loadPolicyFromDatabase(); // simulate loading policy details from a database
    }

    private void loadPolicyFromDatabase() {
        // simulate loading policy details from a database
        System.out.println("Loading policy details from database...");
        try {
            Thread.sleep(1000); // simulate slow database access
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Policy details loaded.");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPremium() {
        return premium;
    }
}

class InsurancePolicyProxy implements InsurancePolicy {
    private String name;
    private String description;
    private double premium;
    private InsurancePolicy realPolicy;

    public InsurancePolicyProxy(String name, String description, double premium) {
        this.name = name;
        this.description = description;
        this.premium = premium;
    }

    public String getName() {
        if (realPolicy == null) {
            loadRealPolicy();
        }
        return realPolicy.getName();
    }

    public String getDescription() {
        if (realPolicy == null) {
            loadRealPolicy();
        }
        return realPolicy.getDescription();
    }

    public double getPremium() {
        if (realPolicy == null) {
            loadRealPolicy();
        }
        return realPolicy.getPremium();
    }

    private void loadRealPolicy() {
        System.out.println("Loading policy details from insurance provider...");
        realPolicy = new InsurancePolicyImpl(name, description, premium);
    }
}

public class ProxyPolicyBazar {
	
	private ProxyPolicyBazar() {
		System.out.println("private constructor");
	}
	
	private void display() {
		
	}
    public static void main(String[] args) {
        InsurancePolicy policy = new InsurancePolicyProxy("Term Life Insurance", "Provides coverage for a specified period of time", 5000.0);

        // customer requests policy details
        System.out.println("Policy name: " + policy.getName());
        System.out.println("Policy description: " + policy.getDescription());
        System.out.println("Policy premium: " + policy.getPremium());

        // customer requests policy details again
		/*
		 * System.out.println("Policy name: " + policy.getName());
		 * System.out.println("Policy description: " + policy.getDescription());
		 * System.out.println("Policy premium: " + policy.getPremium());
		 */
    }
}
