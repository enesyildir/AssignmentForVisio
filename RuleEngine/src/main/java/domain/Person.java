package domain;

public class Person {
    public int creditScore;
    public String state;


    public Person(int creditScore, String state) {
        this.creditScore = creditScore;
        this.state = state;
    }
    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



}
