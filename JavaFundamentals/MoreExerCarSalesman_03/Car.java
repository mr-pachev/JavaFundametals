package MoreExerCarSalesman_03;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car (String model, Engine engine, String weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" + "  %s:%n" + "    Power: %d%n" + "    Displacement: %s%n"
        + "    Efficiency: %s%n" + "  Weight: %s%n" + "  Color: %s%n", getModel(), getEngine().getEngineModel(), getEngine().getPower(),
        getEngine().getDisplacement(), getEngine().getEfficiency(), getWeight(), getColor());
    }
}
