package MoreExerCarSalesman_03;

import java.util.stream.Stream;

public class Engine {
    private String engineModel;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine (String model, int power, String displacement, String efficiency){
        this.engineModel = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }


    public String getEngineModel() {
        return this.engineModel;
    }

    public int getPower() {
        return  this.power;
    }

    public String getDisplacement() {
        return  this.displacement;
    }

    public String getEfficiency() {
        return  this.efficiency;
    }
}
