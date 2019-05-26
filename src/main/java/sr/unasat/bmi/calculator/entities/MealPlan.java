package sr.unasat.bmi.calculator.entities;

public class MealPlan {

    private int id;
    private String name;
    private int type;
    private int calorie;

    public MealPlan(int id, String name, int type, int calorie) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.calorie = calorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", calorie=" + calorie +
                '}';
    }
}
