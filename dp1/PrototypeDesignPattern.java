



import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface InsurancePolicy1 extends Cloneable {
    public void setPolicyHolder(String policyHolder);
    public String getPolicyHolder();
    public void setPolicyAmount(double policyAmount);
    public double getPolicyAmount();
    public void setPremium(double premium);
    public double getPremium();
    public InsurancePolicy1 clone() throws CloneNotSupportedException;
}

// Concrete prototype class
class LifeInsurancePolicy implements InsurancePolicy1 {
    private String policyHolder;
    private double policyAmount;
    private double premium;

    public LifeInsurancePolicy() {}

    public LifeInsurancePolicy(String policyHolder, double policyAmount, double premium) {
        this.policyHolder = policyHolder;
        this.policyAmount = policyAmount;
        this.premium = premium;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyAmount(double policyAmount) {
        this.policyAmount = policyAmount;
    }

    public double getPolicyAmount() {
        return policyAmount;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public double getPremium() {
        return premium;
    }

    public InsurancePolicy1 clone() throws CloneNotSupportedException {
        return (InsurancePolicy1) super.clone();
    }
}

// Client class
public class PrototypeDesignPattern {
    private static Map<String, InsurancePolicy1> policyCache = new HashMap<String, InsurancePolicy1>();

    public static void loadCache() {
        LifeInsurancePolicy lifePolicy = new LifeInsurancePolicy("John Doe", 50000, 1000);
        policyCache.put("life", lifePolicy);
    }

    public static InsurancePolicy1 getPolicy(String policyType) {
        InsurancePolicy1 cachedPolicy = policyCache.get(policyType);
        try {
            return (InsurancePolicy1) cachedPolicy.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        loadCache();

        InsurancePolicy1 lifePolicy = getPolicy("life");
        lifePolicy.setPolicyHolder("Jane Doe");
        lifePolicy.setPolicyAmount(75000);

        System.out.println("Original Policy:");
        System.out.println("Policy Holder: " + policyCache.get("life").getPolicyHolder());
        System.out.println("Policy Amount: " + policyCache.get("life").getPolicyAmount());
        System.out.println("Premium: " + policyCache.get("life").getPremium());

        System.out.println("Cloned Policy:");
        System.out.println("Policy Holder: " + lifePolicy.getPolicyHolder());
        System.out.println("Policy Amount: " + lifePolicy.getPolicyAmount());
        System.out.println("Premium: " + lifePolicy.getPremium());
    }
}
