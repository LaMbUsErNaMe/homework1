public class Car extends Vehicle implements Fuelable {
    private int fuelLevel;
    private String color;
    private static int carCount = 0;

    public Car(String model, int speed, int fuelLevel, String color) {
        super(model, speed);
        this.fuelLevel = fuelLevel;
        this.color = color;
        carCount++;
    }

    public static int getCarCount() {
        return carCount;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void drive() {
        if (fuelLevel > 0) {
            System.out.println(getModel() + " is driving at " + getSpeed() + " km/h");
            fuelLevel -= 10;
        } else {
            System.out.println("Not enough fuel to drive.");
        }
    }

    @Override
    public void refuel(int amount) {
        fuelLevel += amount;
        System.out.println(getModel() + " refueled by " + amount + " liters. Current fuel level: " + fuelLevel);
    }
}
