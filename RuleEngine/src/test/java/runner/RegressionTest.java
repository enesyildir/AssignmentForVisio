package runner;

import domain.Person;
import domain.Product;
import org.junit.Assert;
import org.junit.Test;
import rule.Rule;
import rule.RulesEngine;

import java.util.List;

public class RegressionTest {

    private static List<Rule> rules = RulesEngine.load_rules();


    @Test
    public void testRuleSize() {
        Assert.assertEquals("The size of the rule should be Equal ", 5, rules.size());
    }

    @Test
    public void testStandardProductInterestRate() {
        Person person = new Person(720, "Maryland", 30);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertEquals(4.7, product.getInterestRate(), 0.0);

    }

    @Test
    public void testNotStandardProductInterestRate() {
        Person person = new Person(720, "Maryland", 30);
        Product product = new Product("7-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertEquals(5.2, product.getInterestRate(), 0.0);

    }

    @Test
    public void testIfStateDisqualified() {
        Person person = new Person(720, "Florida", 30);
        Product product = new Product("7-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertTrue(product.isDisqualified());

    }

    @Test
    public void testIfStateQualified() {
        Person person = new Person(720, "California", 30);
        Product product = new Product("7-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertFalse(product.isDisqualified());

    }

    //STARTING FROM HERE BOUNDARY VALUE ANALYSIS
    //Good Credit Score 720, 850, 851
    //Bad Credit Score 719, 500, 499

    @Test
    public void testGoodCreditScoreDeduction() {
        Person person = new Person(720, "California", 30);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertEquals(4.7, product.getInterestRate(), 0.0);

    }

    @Test
    public void testGoodCreditScoreDeductionMaximum() {
        Person person = new Person(850, "California", 30);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertEquals(4.7, product.getInterestRate(), 0.0);

    }

    @Test
    //In this scenario, if a person possible to have a credit score more than 850.
    //No logic has been added for it, so I will limit the reducing the interest rate by 0.3 for people who have maximum 850 credit score.
    public void testGoodCreditScoreDeductionAboveMaximum() {
        Person person = new Person(851, "California", 30);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertEquals(5, product.getInterestRate(), 0.0);

    }

    @Test
    public void testBadCreditScoreAddition() {
        Person person = new Person(719, "California", 30);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertEquals(5.5, product.getInterestRate(), 0.0);

    }

    @Test
    public void testBadCreditScoreAdditionMinimum() {
        Person person = new Person(500, "California", 30);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertEquals(5.5, product.getInterestRate(), 0.0);

    }

    @Test
    //In this scenario, if a person possible to have a credit score less than 500.
    //No logic has been added for it, so I will limit the increasing the interest rate by 0.5 for people who have minimum 500 credit score.
    public void testBadCreditScoreAdditionUnderMinimum() {
        Person person = new Person(499, "California", 30);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertEquals(5, product.getInterestRate(), 0.0);

    }

    @Test
    public void testAgeQualificationUnderMinimum() {
        Person person = new Person(725, "California", 24);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertTrue( product.isDisqualified());

    }

    @Test
    public void testAgeQualificationMinimum() {
        Person person = new Person(725, "California", 25);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertFalse( product.isDisqualified());

    }

    @Test
    public void testAgeQualificationAboveMaximum() {
        Person person = new Person(725, "California", 66);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertTrue(product.isDisqualified());

    }

    @Test
    public void testAgeQualificationMaximum() {
        Person person = new Person(725, "California", 65);
        Product product = new Product("5-1 ARM", 5);
        RulesEngine.runRules(person, product, rules);

        Assert.assertFalse(product.isDisqualified());


    }
}
