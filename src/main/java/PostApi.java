import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostApi extends  Api{
    PostApi(){

    }
    public Response getPosts(){
        return RestAssured.get("/posts/1");
    }

    public void submitPost(){

    }

}
