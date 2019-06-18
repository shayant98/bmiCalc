package sr.unasat.bmi.calculator.entities;

public class MealLog {

    private int id;
    private int mealId;
    private int userId;
    private String userName;
    private String mealName;

    public MealLog(int id, int mealId, int userId) {
        this.id = id;
        this.mealId = mealId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getMealId() {
        return mealId;
    }

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String toString() {
        return "MealLog{" +
                "id=" + id +
                ", mealId=" + mealId +
                ", userId=" + userId +
                '}';
    }
}
