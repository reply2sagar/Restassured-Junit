import io.restassured.RestAssured;

public class Api {

    Api(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

}
