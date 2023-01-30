import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostApi extends  Api{
    PostApi(){
    }

    public Response getPosts(){
        return RestAssured.get("/posts/1");
    }

    //You can use request specification to avoid duplicate code
    public Response submitPost(String payload){
        return  RestAssured.given()
                .header("Authorization", "Bearer XTZYSHBS")
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/posts");
    }

}
