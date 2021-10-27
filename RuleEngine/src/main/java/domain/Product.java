package domain;

public class Product  {

    public String name;
    public boolean disqualified;
    public double interestRate = 5.0;

    public Product(String name, double interestRate) {
        this.interestRate = interestRate;
        this.name = name;
    }
    public Product(String name) {
        this.name = name;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisqualified() {
        return disqualified;
    }

    public void setDisqualified(boolean disqualified) {
        this.disqualified = disqualified;
    }

    public void addInterestRate(double interestRate) {
        this.interestRate += interestRate;
    }

    public void deductInterestRate(double interestRate) {
        this.interestRate -= interestRate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", disqualified=" + disqualified +
                ", interestRate=" + interestRate +
                '}';
    }

}
