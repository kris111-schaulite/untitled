package api;

import io.qameta.allure.Epic;
import org.example.LoginUser;
import org.example.RegistrationUser;
import org.example.UpdateUser;
import org.example.UpdateUserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    private final static String URL = "https://reqres.in/";


    @Test
    @Epic("Status200")
    @DisplayName("Регистрация пользователя")
    public void testRegistrationUser(){

        Specifications.instSpecific(Specifications.requestSpecification(URL),Specifications.responseSpecOk200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        LoginUser loginUser = new LoginUser("eve.holt@reqres.in", "pistol");

        RegistrationUser registrationUser = given()
                .body(loginUser)
                .when()
                .post("api/register")
                .then().log().all()
                .statusCode(200)
                .extract().as(RegistrationUser.class);
        Assertions.assertNotNull(registrationUser.getId());
        Assertions.assertNotNull(registrationUser.getToken());
        Assertions.assertEquals(id, registrationUser.getId());
        Assertions.assertEquals(token, registrationUser.getToken());
    }

    @Test
    @Epic("Status400")
    @DisplayName("Неудачная регистрация")
    public void noRegTest(){
        Specifications.instSpecific(Specifications.requestSpecification(URL),Specifications.responseSpecificationErr400());
        String error = "No password";
        LoginUser loginUser = new LoginUser("sydney@fife","");
        RegistrationUser registrationUser = given()
                .body(loginUser)
                .when()
                .post("api/register")
                .then().log().all()
                .statusCode(400)
                .extract().as(RegistrationUser.class);
        Assertions.assertEquals(error, registrationUser.getError());
    }
    

    @Test
    @Epic("AnotherStatus")
    @DisplayName("Удаление пользователя")
    public void deleteTest(){
        Specifications.instSpecific(Specifications.requestSpecification(URL),Specifications.responseSpecificationStat(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all()
                .statusCode(204);

    }
    @Test
    @Epic("Status200")
    @DisplayName("Изменение пользователя")
    public void updateUser(){
        Specifications.instSpecific(Specifications.requestSpecification(URL),Specifications.responseSpecOk200());
        UpdateUser updateUser = new UpdateUser("morpheus","zion resident");
        UpdateUserData updateUserData = given()
                .body(updateUser)
                .when()
                .put("api/users/2")
                .then().log().all()
                .statusCode(200)
                .extract().as(UpdateUserData.class);
        Assertions.assertNotNull(updateUserData.getName());
        Assertions.assertNotNull(updateUserData.getJob());
        Assertions.assertNotNull(updateUserData.getUpdatedAt());
        Assertions.assertEquals("morpheus",updateUserData.getName());
        Assertions.assertEquals("zion resident",updateUserData.getJob());

    }

}

