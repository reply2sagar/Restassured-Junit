import io.restassured.RestAssured;
import utilities.ConfigManager;

public class Api {

    Api(){
        RestAssured.baseURI = ConfigManager.prop.getProperty("server");
       // RestAssured.baseURI = ConfigManager.getInstance().getProperties().getProperty("server");


    }

}
