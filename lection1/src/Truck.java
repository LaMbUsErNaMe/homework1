public class Truck extends Vehicle implements Fuelable, Loadable {
    private int fuelLevel;
    private int cargoWeight;
    private String cargoType;
    private static int truckCount = 0;

    public Truck(String model, int speed, int fuelLevel, int cargoWeight, String cargoType) {
        super(model, speed);
        this.fuelLevel = fuelLevel;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        truckCount++;
    }

    public static int getTruckCount() {
        return truckCount;
    }

    public String getCargoType() {
        return cargoType;
    }

    @Override
    public void drive() {
        if (fuelLevel > 0) {
            System.out.println(getModel() + " is driving at " + getSpeed() + " km/h with cargo weight: " + cargoWeight + " kg");
            fuelLevel -= 15;
        } else {
            System.out.println("Not enough fuel to drive.");
        }
    }

    @Override
    public void refuel(int amount) {
        fuelLevel += amount;
        System.out.println(getModel() + " refueled by " + amount + " liters. Current fuel level: " + fuelLevel);
    }

    @Override
    public void loadCargo(int weight) {
        cargoWeight += weight;
        System.out.println(getModel() + " loaded with " + weight + " kg. Current cargo weight: " + cargoWeight);
    }
}
