public class Main {
    public static void main(String[] args) {
        DivisibleByThirteen divisibleByThirteen = (number) -> number % 13 == 0;
        int testNumber = 26;
        System.out.println("Is " + testNumber + " divisible by 13? " + divisibleByThirteen.isDivisible(testNumber));

        DiscriminantCalculator discriminantCalculator = (a, b, c) -> b * b - 4 * a * c;
        double a = 1.0, b = 4.0, c = 1.0;
        System.out.println("Discriminant for a=" + a + ", b=" + b + ", c=" + c + " is: " + discriminantCalculator.calculate(a, b, c));

        Car car = new Car("Toyota", 120, 50, "Red");
        Container<Car> carContainer = new Container<>(car);
        carContainer.displayItem();
    }
}
