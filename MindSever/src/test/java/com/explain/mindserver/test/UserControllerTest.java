package com.explain.mindserver.test;

import com.explain.mindserver.error.ApiError;
import com.explain.mindserver.model.User;
import com.explain.mindserver.repository.UserRepository;
import com.explain.mindserver.shared.GenericResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepository userRepository;

    private static final String API_USERS = "/users";

    @BeforeEach
    public void cleanup(){
        userRepository.deleteAll();
        testRestTemplate.getRestTemplate().getInterceptors().clear();
    }
    @Test
    public void postUser_whenUserIsInvalid_receiveApiError(){
        ResponseEntity<ApiError> response = postSignUp(new User(),ApiError.class);
        assertThat(response.getBody().getUrl()).isEqualTo(API_USERS);
    }
    @Test
    public void postUser_whenUsernameHasPasswordAllLowcase_receiveBadRequest(){
        User user = User.builder().username("u").password("test1").displayName("Test").build();
        ResponseEntity<Object> response = postSignUp(user,Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    @Test
    public void postUser_whenUsernameHasPasswordAllUpercase_receiveBadRequest(){
        User user = User.builder().username("u").password("TEST1").displayName("Test").build();
        ResponseEntity<Object> response = postSignUp(user,Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    @Test
    public void postUser_whenUsernameHasPasswordNoNumber_receiveBadRequest(){
        User user = User.builder().username("u").password("Test").displayName("Test").build();
        ResponseEntity<Object> response = postSignUp(user,Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    /*@Test
    public void postUser_whenUsernameHasPasswordNoSpecialCaracter_receiveBadRequest(){
        User user = User.builder().username("u").password("Test1").displayName("Test").build();
        ResponseEntity<Object> response = postSignUp(user,Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }*/
    @Test
    public void postUser_whenUsernameWhithLessThanRequired_receiveBadRequest(){
        User user = User.builder().username("u").password("Test").displayName("Test").build();
        ResponseEntity<Object> response = postSignUp(user,Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    @Test
    public void postUser_whenUsernameExceedsTheLengthLimite_receiveBadRequest(){

        String UsernameWhit256Chars = IntStream.rangeClosed(1,256).mapToObj(x-> "u")
                .collect(Collectors.joining());
        User user = User.builder().username(UsernameWhit256Chars).password("Test").displayName("Test").build();
        ResponseEntity<Object> response = postSignUp(user,Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    @Test
    public void postUser_whenUserHasNullUsername_ReciveBadRequest(){
        User user = User.builder().password("Test").displayName("Test").build();
        ResponseEntity<Object> response = postSignUp(user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    @Test
    public void postUser_whenUserHasNullPassword_ReciveBadRequest(){
        User user = User.builder().username("Test").displayName("Test").build();
        ResponseEntity<Object> response = postSignUp(user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    @Test
    public void postUser_whenUserHasNullDisplayName_ReciveBadRequest(){
        User user = User.builder().username("Test").password("Test").build();
        ResponseEntity<Object> response = postSignUp(user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


    @Test
    public void postUser_whenUserIsValid_reciveOk(){
        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_USERS, createValidUser(), Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postUser_whenUserIsValid_userSavedToDatabase(){
        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_USERS, createValidUser(), Object.class);
        assertThat(userRepository.count()).isEqualTo(1);
    }

    @Test
    public void postUser_whenIsValid_reciveSuccessMessage(){
        ResponseEntity<GenericResponse> response = testRestTemplate.postForEntity(API_USERS,createValidUser(),GenericResponse.class);
        assertThat(response.getBody().getMessage()).isNotNull();
    }

    @Test
    @DisplayName("Post User When User Is Valid Password Is Hashed In Database")
    public void postUser_whenUserIsValid_passwordIsHashedInDatabase(){
        var user = createValidUser();
        testRestTemplate.postForEntity(API_USERS,user,Object.class);

        List<User> users = userRepository.findAll();
        var userDB = users.get(0);
        assertThat(userDB.getPassword()).isNotEqualTo(user.getPassword());
    }

    private User createValidUser(){
        return User.builder().username("UserTest").displayName("Test-display").password("P4ssw0rd").build();
    }
    private <T> ResponseEntity<T> postSignUp(Object request, Class<T> responseType){
        return testRestTemplate.postForEntity(API_USERS,request, responseType);
    }
}
