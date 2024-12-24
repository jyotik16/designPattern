package com.ashokit.interpreter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Expression {
    boolean interpret(PolicyContext context);
}

class GenderExpression implements Expression {
    private final String gender;

    public GenderExpression(String gender) {
        this.gender = gender;
    }

    public boolean interpret(PolicyContext context) {
        return context.getGender().equals(gender);
    }
}

class AgeExpression implements Expression {
    private final String comp;
    private final int age;

    public AgeExpression(String comp, int age) {
        this.comp = comp;
        this.age = age;
    }

    public boolean interpret(PolicyContext context) {
        switch (comp) {
            case "<":
                return context.getAge() < age;
            case ">":
                return context.getAge() > age;
            case "=":
                return context.getAge() == age;
            default:
                return false;
        }
    }
}

class PolicyTypeExpression implements Expression {
    private final String policyType;

    public PolicyTypeExpression(String policyType) {
        this.policyType = policyType;
    }

    public boolean interpret(PolicyContext context) {
        return context.getPolicyType().equals(policyType);
    }
}

class PolicyContext {
    private final String gender;
    private final int age;
    private final String policyType;

    public PolicyContext(String gender, int age, String policyType) {
        this.gender = gender;
        this.age = age;
        this.policyType = policyType;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }
}

class PolicyExpression {
    private final Expression expression;

    public PolicyExpression(String expressionStr) {
        Pattern pattern = Pattern.compile("(\\w+)\\s*(<|=|>)\\s*(\\d+)");
        Matcher matcher = pattern.matcher(expressionStr);

        if (matcher.matches()) {
            String field = matcher.group(1);
            String comp = matcher.group(2);
            int value = Integer.parseInt(matcher.group(3));

            switch (field) {
                case "gender":
                    expression = new GenderExpression(value == 1 ? "male" : "female");
                    break;
                case "age":
                    expression = new AgeExpression(comp, value);
                    break;
                case "policyType":
                    expression = new PolicyTypeExpression(value == 1 ? "premium" : "basic");
                    break;
                default:
                    expression = null;
            }
        } else {
            expression = null;
        }
    }

    public boolean interpret(PolicyContext context) {
        if (expression == null) {
            return false;
        } else {
            return expression.interpret(context);
        }
    }
}

public class InsuranceInterpreterExample {
    public static void main(String[] args) {
        PolicyContext context1 = new PolicyContext("male", 25, "basic");
        PolicyExpression expression1 = new PolicyExpression("gender = 1 and age > 18 and policyType = 0");
        System.out.println("Expression 1: " + expression1.interpret(context1));

        PolicyContext context2 = new PolicyContext("female", 35, "premium");
        PolicyExpression expression2 = new PolicyExpression("gender = 0 and age < 40 and policyType = 1");
        System.out.println("Expression 2: " + expression2.interpret(context2));

        PolicyContext context3 = new PolicyContext("male", 55, "premium");
       // PolicyExpression expression3 = new PolicyExpression("gender
    }
}
