import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Laptop {
    private String brand;
    private String model;
    private int ram;
    private int hdd;
    String os;
    private String color;

    public Laptop(String brand, String model, int ram, int hdd, String os, String color) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop {" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", ram=" + ram + ", hdd=" + hdd
                + ", os='" + os + '\'' + ", color='" + color + '\'' + '}';
    }

    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Lenovo", "Yoga", 8, 500, "Windows 10", "Black"));
        laptops.add(new Laptop("Dell", "XPS", 16, 1000, "Windows 10", "Silver"));
        laptops.add(new Laptop("Apple", "MacBook Pro", 16, 512, "macOS", "Space Gray"));
        laptops.add(new Laptop("Thunderobot", "911S Core", 16, 512, "Windows 11 Pro", "Black"));
        laptops.add(new Laptop("ASUS", "X515EA-BQ4265", 8, 512, "none", "Gray"));
        laptops.add(new Laptop("HUAWEI", "MateBook D 15 2021 BoD-WDH9", 8, 512, "Windows 11", "Silver"));

        Map<Integer, String> criteriaMap = new HashMap<>();
        criteriaMap.put(1, "ram");
        criteriaMap.put(2, "hdd");
        criteriaMap.put(3, "os");
        criteriaMap.put(4, "color");

        Map<String, Integer> filterMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        for (Map.Entry<Integer, String> entry : criteriaMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        int choice = scanner.nextInt();
        String criterion = criteriaMap.get(choice);

        System.out.println("Введите минимальное значение для " + criterion + ":");
        int minValue = scanner.nextInt();

        filterMap.put(criterion, minValue);

        for (Laptop laptop : laptops) {
            if (criterion.equals("ram") && laptop.getRam() >= minValue ||
                    criterion.equals("hdd") && laptop.getHdd() >= minValue ||
                    criterion.equals("os") && laptop.getOs().equals(minValue) ||
                    criterion.equals("color") && laptop.getColor().equals(minValue)) {
                System.out.println(laptop);
            }
        }
    }
}