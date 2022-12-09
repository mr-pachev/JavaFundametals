package MoreExerRawData_02;

public class Tires {
    private double tires1Pressure;
    private int tires1Age;

    private double tires2Pressure;
    private int tires2Age;

    private double tires3Pressure;
    private int tires3Age;

    private double tires4Pressure;
    private int tires4Age;

    public Tires(double tires1Pressure, int tires1Age, double tires2Pressure, int tires2Age,
                 int tires3Pressure, int tires3Age, double tires4Pressure, int tires4Age){
        this.tires1Pressure = tires1Pressure;
        this.tires1Age = tires1Age;
        this.tires2Pressure = tires2Pressure;
        this.tires2Age = tires2Age;
        this.tires3Pressure = tires3Pressure;
        this.tires3Age = tires3Age;
        this.tires4Pressure = tires4Pressure;
        this.tires4Age = tires4Age;
    }

    public double getTires1Pressure() {
        return this.tires1Pressure;
    }

    public int getTires1Age() {
        return this.tires1Age;
    }

    public double getTires2Pressure() {
        return this.tires2Pressure;
    }

    public int getTires2Age() {
        return this.tires2Age;
    }

    public double getTires3Pressure() {
        return this.tires3Pressure;
    }

    public int getTires3Age() {
        return this.tires3Age;
    }

    public double getTires4Pressure() {
        return this.tires4Pressure;
    }

    public int getTires4Age() {
        return this.tires4Age;
    }
}
