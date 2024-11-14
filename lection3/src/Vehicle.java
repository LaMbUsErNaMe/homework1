public abstract class Vehicle {
    private String model;
    private int speed;
    private static int vehicleCount = 0;

    public Vehicle(String model, int speed) {
        this.model = model;
        this.speed = speed;
        vehicleCount++;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public static int getVehicleCount() {
        return vehicleCount;
    }

    public abstract void drive();

    public void displayInfo() {
        System.out.println("Model: " + model + ", Speed: " + speed + " km/h");
    }
}

