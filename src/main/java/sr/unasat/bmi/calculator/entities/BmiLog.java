package sr.unasat.bmi.calculator.entities;

public class BmiLog {

    private int id;
    private int userId;
    private double bmi;
    private double weight;
    private String date;

    public BmiLog(int id, int userId, double bmi,double weight, String date) {
        this.id = id;
        this.userId = userId;
        this.bmi = bmi;
        this.weight = weight;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public double getBmi() {
        return bmi;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "BmiLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", bmi=" + bmi +
                ", date=" + date +
                '}';
    }
}
