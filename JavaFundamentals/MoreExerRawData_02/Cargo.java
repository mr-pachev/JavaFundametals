package MoreExerRawData_02;

public class Cargo {
    private String model;
    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getType() {
        return this.type;
    }

}
