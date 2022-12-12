package MoreExerRawData_02;

public class Tires {
    private double tire1Pressure;
    private int tire1Age;

    private double tire2Pressure;
    private int tire2Age;

    private double tire3Pressure;
    private int tire3Age;

    private double tire4Pressure;
    private int tire4Age;

    public Tires(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age,
                 double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age){
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }

    public double getTires1Pressure() {
        return this.tire1Pressure;
    }

    public int getTires1Age() {
        return this.tire1Age;
    }

    public double getTires2Pressure() {
        return this.tire2Pressure;
    }

    public int getTires2Age() {
        return this.tire2Age;
    }

    public double getTires3Pressure() {
        return this.tire3Pressure;
    }

    public int getTires3Age() {
        return this.tire3Age;
    }

    public double getTires4Pressure() {
        return this.tire4Pressure;
    }

    public int getTires4Age() {
        return this.tire4Age;
    }
}
