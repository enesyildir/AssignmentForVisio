package rule;

public class Rule {

    public int creditScoreLowerBond;
    public int creditScoreUpperBond;
    public double interestRate;
    public String interestRateDecision;
    public String ruleId;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String productType;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String state;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public int getCreditScoreLowerBond() {
        return creditScoreLowerBond;
    }

    public void setCreditScoreLowerBond(int creditScoreLowerBond) {
        this.creditScoreLowerBond = creditScoreLowerBond;
    }

    public int getCreditScoreUpperBond() {
        return creditScoreUpperBond;
    }

    public void setCreditScoreUpperBond(int creditScoreUpperBond) {
        this.creditScoreUpperBond = creditScoreUpperBond;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getInterestRateDecision() {
        return interestRateDecision;
    }

    public void setInterestRateDecision(String interestRateDecision) {
        this.interestRateDecision = interestRateDecision;
    }

}
