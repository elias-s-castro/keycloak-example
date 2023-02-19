package br.com.example.keycloakexample.keycloaktestcontainers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Requer Docker em execução na máquina para rodar sem erros
 * Portanto, ignorado do pipeline
 */
public class UserControllerManualTest extends KeycloakTestContainers{

    @Test
    @DisplayName("Deve pegar o usuário autenticado e retornas suas informações")
    void givenAuthenticatedUser_whenGetMe_shouldReturnMyInfo() {
        given().header("Authorization", getMyUserBearer())
                .when()
                .get("/users/me")
                .then()
                .body("username", equalTo("usertest"))
                .body("firstname", equalTo("User"))
                .body("lastname", equalTo("Test"))
                .body("email", equalTo(" user.test@mytest.com.br"));
    }
}
