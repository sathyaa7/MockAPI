import io.restassured.RestAssured;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class APISimple {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileReader file = new FileReader("src/test/java/env.properties");
        properties.load(file);
        String url = properties.getProperty("url");
        System.out.println("url-----" + url);
        System.out.println("GET AS PRETTY STRING--------");
        System.out.println(
                RestAssured.given().when().get(url + "/2").getBody().asPrettyString()
        );
        System.out.println("GET AS JAVA OBJECT--------");

        ApiResponse apiResponse=    RestAssured.given().when().get(url).getBody().as(ApiResponse.class);
        System.out.println("Details: "+apiResponse.getData());
        System.out.println("FirstName: "+apiResponse.getData().get(0).getFirst_name());
        System.out.println("Last Name: "+apiResponse.getData().get(0).getLast_name());
        System.out.println("id: "+apiResponse.getData().get(0).getId());
        System.out.println("email: "+apiResponse.getData().get(0).getEmail());
        System.out.println("avatar: "+apiResponse.getData().get(0).getAvatar());


        Page page = new Page();
        page.setId(1111);
        page.setFirst_name("Allan");
        page.setLast_name("John");
        page.setEmail("aa@ccc.com");
        page.setAvatar("avatarhere");
        ApiResponse apiResponsePost=new ApiResponse();
        apiResponsePost.setData(Arrays.asList(page));
        RestAssured.given().body(apiResponsePost).when().post(url)
                .then()
                //   .log().all()
                .assertThat().statusCode(201);
        System.out.println("PATCH-----------------------------------");

        Page pagePatch = new Page();
        pagePatch.setFirst_name("Miranda");
        ApiResponse apiResponsePatch=new ApiResponse();
        apiResponsePatch.setData(Arrays.asList(pagePatch));
        System.out.println(
        RestAssured.given().body(apiResponsePatch).when().patch(url + "/2")
                    .getBody().asPrettyString()
               // .then()
              //  .assertThat().statusCode(200);
         );

        System.out.println("PUT-----------------------------------");
        Page pagePut = new Page();
        pagePut.setId(8);
        pagePut.setFirst_name("Allan");
        pagePut.setLast_name("John");
        pagePut.setEmail("aa@ccc.com");
        pagePut.setAvatar("avatarhere");
        ApiResponse apiResponsePut=new ApiResponse();
        apiResponsePut.setData(Arrays.asList(pagePut));
         System.out.println(
        RestAssured.given().body(apiResponsePut).when().put(url + "/3")
                    .getBody().asPrettyString()
           //     .then()
           //     .assertThat().statusCode(200);
         );

    }
}
