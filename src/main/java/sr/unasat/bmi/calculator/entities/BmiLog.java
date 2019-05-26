package sr.unasat.bmi.calculator.entities;

public class BmiLog {

    private int id;
    private int userId;
    private int bmi;
    private String date;

    public BmiLog(int id, int userId, int bmi, String date) {
        this.id = id;
        this.userId = userId;
        this.bmi = bmi;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getBmi() {
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

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }

    public void setDate(String date) {
        this.date = date;
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
