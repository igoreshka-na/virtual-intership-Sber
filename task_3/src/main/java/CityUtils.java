import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CityUtils {

    public static List<City> parse() {
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/city_ru.csv"));
            while (scanner.hasNextLine()) {
                cities.add(parse(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    public static void sortingByOneParameters(List<City> cities) {
        cities.sort(Comparator.comparing(City::getName));
    }

    public static void sortingByOneParametersV2(List<City> cities) {
        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    public static void sortingByTwoParameters(List<City> cities) {
        cities.sort((p1, p2) -> {
            if (p1.getDistrict().compareTo(p2.getDistrict()) != 0) {
                return p1.getDistrict().compareTo(p2.getDistrict());
            } else {
                return p1.getName().compareTo(p2.getName());
            }
        });
    }

    public static void sortingByTwoParametersV2(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }

    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        int number = scanner.nextInt();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        scanner.close();

        return new City(number, name, region, district, population, foundation);
    }

    public static City[] arrayCreation() {
        List<City> cities = parse();
        City[] city = new City[cities.size()];
        for (int i = 0; i < cities.size(); ++i) {
            city[i] = new City(cities.get(i).getNumber(), cities.get(i).getPopulation());
        }
        return city;
    }
    public static void printMaxPopulation(City[] cities) {
        City maxCity = Arrays.stream(cities).max(Comparator.comparing(City::getPopulation)).get();
        System.out.println(maxCity.getNumber() + " = " + maxCity.getPopulation());
    }
}
