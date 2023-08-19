import configRick.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import rickAndMortyLocation.Location;
import rickAndMortyLocation.Result;
import java.util.List;
import static io.restassured.RestAssured.when;

public class RickAndMortyDimensionTest extends BaseClass {
    static String baseURL = "location";
    static Location location;

    @BeforeClass
    public static void bb() {
        location = when()
                .get(baseURL)
                .then()
                .extract()
                .body()
                .as(Location.class);
    }

    @Test //Getting location dimensions using objects
    public void test1() {
        for (Result result : location.results) {
            System.out.println(result.dimension);
        }
    }
    @Test //Getting location dimensions without using objects
    public void test2() {
          List<String> dimensions=  when()
                 .get(baseURL).then().extract().jsonPath().getList("results.dimension",String.class);
                  System.out.println(dimensions);
        }
    }
