public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 120, 50, "Red");
        Truck truck = new Truck("Volvo", 80, 100, 500, "Construction Materials");
        ElectricScooter scooter = new ElectricScooter("Xiaomi", 25, 100, "Lithium-ion");

        car.drive();
        car.refuel(20);
        car.drive();

        truck.drive();
        truck.refuel(50);
        truck.loadCargo(200);
        truck.drive();

        scooter.drive();
        scooter.charge(30);
        scooter.loadCargo(10);
        scooter.drive();

        System.out.println("Total vehicles created: " + Vehicle.getVehicleCount());
        System.out.println("Total cars created: " + Car.getCarCount());
        System.out.println("Total trucks created: " + Truck.getTruckCount());
    }
}
