public class ElectricScooter extends Vehicle implements Loadable {
    private int batteryLevel;
    private int cargoWeight;
    private String batteryType;

    public ElectricScooter(String model, int speed, int batteryLevel, String batteryType) {
        super(model, speed);
        this.batteryLevel = batteryLevel;
        this.batteryType = batteryType;
    }

    public String getBatteryType() {
        return batteryType;
    }

    @Override
    public void drive() {
        if (batteryLevel > 0) {
            System.out.println(getModel() + " is driving at " + getSpeed() + " km/h with cargo weight: " + cargoWeight + " kg");
            batteryLevel -= 5;
        } else {
            System.out.println("Battery low. Please recharge.");
        }
    }

    public void charge(int amount) {
        batteryLevel += amount;
        System.out.println(getModel() + " charged by " + amount + " units. Current battery level: " + batteryLevel);
    }

    @Override
    public void loadCargo(int weight) {
        cargoWeight += weight;
        System.out.println(getModel() + " loaded with " + weight + " kg. Current cargo weight: " + cargoWeight);
    }
}

