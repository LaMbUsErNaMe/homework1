interface Fuelable {
    void refuel(int amount);
}

interface Loadable {
    void loadCargo(int weight);
}

abstract class Vehicle {

    protected String model;
    protected int speed;

    private static int vehicleCount = 0;

    public Vehicle(String model, int speed) {
        this.model = model;
        this.speed = speed;
        vehicleCount++;
    }

    public static int getVehicleCount() {
        return vehicleCount;
    }

    public abstract void drive();

    public void displayInfo() {
        System.out.println("Model: " + model + ", Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle implements Fuelable {
    private int fuelLevel;

    public Car(String model, int speed, int fuelLevel) {
        super(model, speed);
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void drive() {
        if (fuelLevel > 0) {
            System.out.println(model + " is driving at " + speed + " km/h");
            fuelLevel -= 10;
        } else {
            System.out.println("Not enough fuel to drive.");
        }
    }

    @Override
    public void refuel(int amount) {
        fuelLevel += amount;
        System.out.println(model + " refueled by " + amount + " liters. Current fuel level: " + fuelLevel);
    }
}

class Truck extends Vehicle implements Fuelable, Loadable {
    private int fuelLevel;
    private int cargoWeight;

    public Truck(String model, int speed, int fuelLevel, int cargoWeight) {
        super(model, speed);
        this.fuelLevel = fuelLevel;
        this.cargoWeight = cargoWeight;
    }

    @Override
    public void drive() {
        if (fuelLevel > 0) {
            System.out.println(model + " is driving at " + speed + " km/h with cargo weight: " + cargoWeight + " kg");
            fuelLevel -= 15;
        } else {
            System.out.println("Not enough fuel to drive.");
        }
    }

    @Override
    public void refuel(int amount) {
        fuelLevel += amount;
        System.out.println(model + " refueled by " + amount + " liters. Current fuel level: " + fuelLevel);
    }

    @Override
    public void loadCargo(int weight) {
        cargoWeight += weight;
        System.out.println(model + " loaded with " + weight + " kg. Current cargo weight: " + cargoWeight);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 120, 50);
        Truck truck = new Truck("Volvo", 80, 100, 500);

        System.out.println("for pr2");

        car.drive();
        car.refuel(20);
        car.drive();

        truck.drive();
        truck.refuel(50);
        truck.loadCargo(200);
        truck.drive();

        System.out.println("Total vehicles created: " + Vehicle.getVehicleCount());
    }
}
