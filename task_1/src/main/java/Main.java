import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/city_ru.csv");
        Scanner scanner = new Scanner(file);

            scanner.useDelimiter(";|\\r\\n");
            while (scanner.hasNext()) {
                City city = new City();
                int number = scanner.nextInt();
                String name = scanner.next();
                String region = scanner.next();
                String district = scanner.next();
                int population = scanner.nextInt();
                String foundation = scanner.next();
                city.setName(name);
                city.setRegion(region);
                city.setDistrict(district);
                city.setPopulation(population);
                city.setFoundation(foundation);
                System.out.println(city.toString());
            }
    }
}
