package org.fernando.salas.part09.strategy;

public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        // false
        //System.out.println(b1);

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        // true
        //System.out.println(b2);

        // Using lambda expression
        Validator numericValidator2 = new Validator((String s) -> s.matches("\\d+"));
        boolean lambdab2 = numericValidator2.validate("bbbb");
        System.out.println(lambdab2);

        Validator lowerCaseValidator2 = new Validator((String s) -> s.matches("[a-z]+"));
        boolean lambdab1 = lowerCaseValidator2.validate("aaaa");
        System.out.println(lambdab1);


    }
}
