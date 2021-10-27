package runner;


import domain.Person;
import domain.Product;
import rule.Rule;
import rule.RulesEngine;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Person person = new Person(720, "Florida");
        Product product = new Product("7-1 ARM", 5.0);
        RulesEngine rulesEngine = new RulesEngine();

        List<Rule> rules = RulesEngine.load_rules();

        RulesEngine.runRules(person, product, rules);

        System.out.println(product);



    }
}
