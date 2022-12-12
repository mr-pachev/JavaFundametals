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

            double[] tirePressureArr = {(Double.parseDouble(carInfo[5])), //налягането на всичките бетири гуми
                    (Double.parseDouble(carInfo[7])),
                    (Double.parseDouble(carInfo[9])),
                    (Double.parseDouble(carInfo[11]))};

            int[] tireAgeArr = {(Integer.parseInt(carInfo[6])), //възрастта на всичките четири гуми
                    (Integer.parseInt(carInfo[8])),
                    (Integer.parseInt(carInfo[10])),
                    (Integer.parseInt(carInfo[12]))};

            Engine engine = new Engine(engineSpeed, enginePower); //конструктор с данните за двигателя
            Cargo cargo = new Cargo(cargoWeight, cargoType); //конструктор с данните за товара
            Tires tires = new Tires(tirePressureArr, tireAgeArr); //конструктор с данните за гумите
            Car car = new Car(model, engine, cargo, tires); //коснструктор са данните да колата

            carList.add(car); //пълнене на листа с информацията за колите
        }

        String command = scanner.nextLine(); //команда, кои коли да се изпечатват

        for (Car car : carList) { //обхождаме листа с колите и вадим елементите, които ни трябват
            String typeCargo = car.getCargo().getType(); //вади текущия лемент тип товар
            int tyrePressureLength = car.getTires().getTiresPressureArr().length - 1; //вади дължината на масива на налягането но гумите

            for (int currentTire = 0; currentTire <= tyrePressureLength; currentTire++) { //обхождаме масива с налягането на гумите, зада видим коя отговаря на условието

                if (typeCargo.equals(command) && car.getTires().getTiresPressureArr()[currentTire] < 1){
                    System.out.println(car.getModel());
                    break;
                }else if (typeCargo.equals(command) && car.getEngine().getPower() > 250){
                    System.out.println(car.getModel());
                    break;
                }
            }


        }

    }
}
