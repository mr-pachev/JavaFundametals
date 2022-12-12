package MoreExerRawData_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //входни данни

        List<Car> carList = new ArrayList<>(); //лист с данните на всички коли
        List<Car> equalsCarsList = new ArrayList<>();

        for (int currentCar = 1; currentCar <= n; currentCar++) { //цикъл според броя въведени коли от конзолата
            String[] carInfo = scanner.nextLine().split("\\s+");

            String model = carInfo[0]; //модела на колата
            int engineSpeed = Integer.parseInt(carInfo[1]); //максимална скорост
            int enginePower = Integer.parseInt(carInfo[2]); //конски сили
            int cargoWeight = Integer.parseInt(carInfo[3]); //тегло на товара
            String cargoType = carInfo[4]; //тип на товара

            double tirePressure1 = Double.parseDouble(carInfo[5]); //налягане на първата гума
            int tireAge1 = Integer.parseInt(carInfo[6]); //възраст на първата гума

            double tirePressure2 = Double.parseDouble(carInfo[7]); //налягане на втората гума
            int tireAge2 = Integer.parseInt(carInfo[8]); //възраст на втората гума

            double tirePressure3 = Double.parseDouble(carInfo[9]); //налягане на третата гума
            int tireAge3 = Integer.parseInt(carInfo[10]); //възраст на третата гума

            double tirePressure4 = Double.parseDouble(carInfo[11]); //налягане на четвърта гума
            int tireAge4 = Integer.parseInt(carInfo[12]); //възраст на четвъртата гума

            Engine engine = new Engine(engineSpeed, enginePower); //конструктор с данните за двигателя
            Cargo cargo = new Cargo(cargoWeight, cargoType); //конструктор с данните за товара
            Tires tires = new Tires(tirePressure1, tireAge1, tirePressure2, tireAge2, tirePressure3, tireAge3, tirePressure4, tireAge4); //конструктор с данните за гумите
            Car car = new Car(model, engine, cargo, tires); //коснструктор са данните да колата

            carList.add(car); //пълнене на листа с информацията за колите
        }

        String command = scanner.nextLine(); //команда, кои коли да се изпечатват



        System.out.println();
    }
}
