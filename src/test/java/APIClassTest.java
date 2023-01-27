import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import models.Post;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class APIClassTest extends  BaseTest{

    @Test
    public void getUserPost() {
        PostApi api = new PostApi();
        Response response = api.getPosts();
        assertEquals(200, response.getStatusCode());
        test.info("200 response got from api");
       // assertEquals("quidem molestiae enim", response.jsonPath().get("title"));
    }

    @Test
    public void PostRequest(){
        String payload = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
        PostApi api = new PostApi();
        Response response = api.submitPost(payload);
        assertEquals(201, response.getStatusCode());
    }

    @Test
    public void PostRequestJackson() throws Exception{
        Post post = new Post();
//        post.setBody("Hello");
//        post.setTitle("Title");
//        post.setUserId("2");
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(post);

        PostApi api = new PostApi();
        Response response = api.submitPost(payload);
        assertEquals(201, response.getStatusCode());
    }
}
