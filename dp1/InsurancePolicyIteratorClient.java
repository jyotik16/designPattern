

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Insurance Policy class
class InsurancePolicy {
    private String policyNumber;
    private String policyHolderName;
    private String policyType;
    private double policyAmount;

    public InsurancePolicy(String policyNumber, String policyHolderName, String policyType, double policyAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.policyType = policyType;
        this.policyAmount = policyAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPolicyAmount() {
        return policyAmount;
    }
}

// Insurance Policy Collection class
class InsurancePolicyCollection implements Iterable<InsurancePolicy> {
    private List<InsurancePolicy> policyList;

    public InsurancePolicyCollection() {
        policyList = new ArrayList<>();
    }

    public void addPolicy(InsurancePolicy policy) {
        policyList.add(policy);
    }

    public void removePolicy(InsurancePolicy policy) {
        policyList.remove(policy);
    }

    @Override
    public Iterator<InsurancePolicy> iterator() {
        return new PolicyIterator();
    }

    // Inner class for Policy Iterator
    private class PolicyIterator implements Iterator<InsurancePolicy> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < policyList.size();
        }

        @Override
        public InsurancePolicy next() {
            if (!hasNext()) {
                return null;
            }
            return policyList.get(currentIndex++);
        }
    }
}

// Client code to use the Insurance Policy Iterator
public class InsurancePolicyIteratorClient {
    public static void main(String[] args) {
        InsurancePolicyCollection policyCollection = new InsurancePolicyCollection();
        policyCollection.addPolicy(new InsurancePolicy("1001", "John Smith", "Life", 100000));
        policyCollection.addPolicy(new InsurancePolicy("1002", "Mary Jones", "Health", 5000));
        policyCollection.addPolicy(new InsurancePolicy("1003", "David Lee", "Auto", 20000));

        Iterator<InsurancePolicy> policyIterator = policyCollection.iterator();
        while (policyIterator.hasNext()) {
            InsurancePolicy policy = policyIterator.next();
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Policy Holder: " + policy.getPolicyHolderName());
            System.out.println("Policy Type: " + policy.getPolicyType());
            System.out.println("Policy Amount: " + policy.getPolicyAmount());
        }
    }
}

