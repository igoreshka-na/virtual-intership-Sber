import java.util.List;

public class Main extends CityUtils {
    public static void main(String[] args) {
        List<City> cities = parse();

        sortingByOneParameters(cities);
        print(cities);

        sortingByTwoParametersV2(cities);
        print(cities);
    }
}
