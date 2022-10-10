package Exersice_06_VehicleCatalogue_06;

public class Vehicle {
    String typeOfVehicle;
    String model;
    String color;
    double horsepower;

    public Vehicle(String typeOfVehicle, String model, String color, double horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        String formatType = "";
        if(this.typeOfVehicle.equals("car")){
            formatType = "Car";
        }else if(this.typeOfVehicle.equals("truck")){
            formatType = "Truck";
        }
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %.0f", formatType, this.getModel(), getColor(), getHorsepower());
    }

    public static double getStatistics(int count, double hp) {
        double result = hp / count;
        return result;
    }
}
