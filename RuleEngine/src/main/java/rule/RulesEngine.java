package rule;

import com.google.gson.Gson;
import domain.Person;
import domain.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class RulesEngine {


    public static List<Rule> load_rules() {

        InputStreamReader inputStreamReader = new InputStreamReader(RulesEngine.class.getClassLoader().getResourceAsStream("rule.json"));

        Reader reader = new BufferedReader(inputStreamReader);
        Gson gson = new Gson();
        RuleWrapper rule = gson.fromJson(reader, RuleWrapper.class);

        return rule.rules;


    }

    public static void runRules(Person person, Product product, List<Rule> rules) {

          rules.forEach(rule -> {

              // trigger state rule, we dont have product in certain state.
              if (rule.getState() != null && rule.getState().equalsIgnoreCase(person.getState()) ) {
                  product.setDisqualified(true);
                  System.out.println("Triggered rule ----- " + rule.getRuleId());
                 }
                    // credit score rules, add or deduct based on the score.
                 if (rule.getCreditScoreLowerBond() <= person.getCreditScore() && person.getCreditScore() <= rule.getCreditScoreUpperBond()) {
                     decideOnInterestRate(rule, product);
                     System.out.println("Triggered rule ----- " + rule.getRuleId());
                 }

                 // product type rule, add or deduct based on the product type
                 if (rule.getProductType() != null && rule.getProductType().equalsIgnoreCase(product.getName())) {
                     decideOnInterestRate(rule, product);
                     System.out.println("Triggered rule ----- " + rule.getRuleId());
                 }

                // trigger state rule, decide if a person eligible to apply for a product due to age restriction.

                if (decideOnAgeQualification(rule, person)) {
                    product.setDisqualified(true);
                    System.out.println("Triggered rule ----- " + rule.getRuleId());
                 }


          });



    }

    private static void decideOnInterestRate(Rule rule, Product product) {
        String decision = rule.getInterestRateDecision();
        if ("Add".equalsIgnoreCase(decision)) {
            product.addInterestRate(rule.getInterestRate());
        } else if ("Deduct".equalsIgnoreCase(decision)) {
            product.deductInterestRate(rule.getInterestRate());
        }
    }

    public static boolean decideOnAgeQualification(Rule rule, Person person) {
        boolean flag = false;
        if ((rule.getAgeLimitLowerBond() != 0) && rule.getAgeLimitLowerBond() > person.getAge() ||
                ((rule.getAgeLimitLowerBond() != 0) && (person.getAge() > rule.getAgeLimitUpperBond()))) {
            return flag = true;
        }else {
            return false;
        }

    }

}
