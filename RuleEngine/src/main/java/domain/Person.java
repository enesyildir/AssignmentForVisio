package domain;

public class Person {
    public int creditScore;
    public String state;
    public int age;


    public Person(int creditScore, String state, int age) {
        this.creditScore = creditScore;
        this.state = state;
        this.age = age;
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

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }



}
