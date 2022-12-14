package MoreExerCarSalesman_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой редове с двигатели

        List<Car> carList = new ArrayList<>();
        List<Engine> engineList = new ArrayList<>();

        String modelCar = ""; //модел на колата
        String weightCar = "n/a"; //тегло на колата
        String carColor = "n/a"; //цвят на колата

        for (int currentEngine = 1; currentEngine <= n; currentEngine++) {
            String[] inputArr = scanner.nextLine().split(" "); //масив с входящата информация

            String engineModel = inputArr[0]; //модел на двигателя
            int power = Integer.parseInt(inputArr[1]); //мощност на двигателя
            String displacement = "n/a"; //работен обем
            String efficiency = "n/a"; //ефективност на двигателя

            if (inputArr.length == 3) { //проверка дали има подадени робетен обем и ефективност на двигателя и проверка дали стринга е число
                if (isNumeric(inputArr[2])) {
                    displacement = inputArr[2];
                } else {
                    efficiency = inputArr[2];
                }

            } else if (inputArr.length == 4) {
                if (isNumeric(inputArr[2])) {
                    displacement = inputArr[2];
                    efficiency = inputArr[3];
                }else {
                    efficiency = inputArr[3];
                }
            }

            Engine engine = new Engine(engineModel, power, displacement, efficiency);
            engineList.add(engine);

        }
        n = Integer.parseInt(scanner.nextLine());

        for (int currentCar = 1; currentCar <= n; currentCar++) { //брой коли въведени от конзолата
            String[] inputArr = scanner.nextLine().split(" "); //входящата информация
            modelCar = inputArr[0];
            String engineCarModel = inputArr[1]; //модел вдигател
            weightCar = "n/a"; //тегло на колата
            carColor = "n/a"; //цвят на колата

            if ((inputArr.length == 3)) { //проверка дали има тегло и/или цвят
                if (isNumeric(inputArr[2])) {
                    weightCar = inputArr[2];
                } else {
                    carColor = inputArr[2];
                }
            } else if ((inputArr.length == 4)) { //проверка дали има тегло и/или цвят
                if (isNumeric(inputArr[2])) {
                    weightCar = inputArr[2];
                    carColor = inputArr[3];
                } else {
                    carColor = inputArr[3];
                }
            }

            for (Engine engine : engineList) { //обхожда листа с модели двигатели и създава обект със съответващия вид двигател
                if (engine.getEngineModel().equals(engineCarModel)) { //проверява дали зададения модел двигател го има в листа с модела двигатели
                    Engine engine1 = new Engine(engineCarModel, engine.getPower(), engine.getDisplacement(), engine.getEfficiency());
                    Car car = new Car(modelCar, engine1, weightCar, carColor);
                    carList.add(car);
                }
            }

        }
        for (Car car : carList) {
            System.out.print(car.toString());
        }
    }

    //метод за проверка даден стринг дали е число
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
