package com.explain.mindserver.test;

import com.explain.mindserver.model.User;
import com.explain.mindserver.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void cleanup(){
        userRepository.deleteAll();
        testRestTemplate.getRestTemplate().getInterceptors().clear();
    }

    @Test
    public void postUser_whenUserIsValid_reciveOk(){
        User user = User.builder().username("UserTest").displayName("Test-display").password("P4ssw0rd").build();

        ResponseEntity<Object> response = testRestTemplate.postForEntity("/users", user, Object.class);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postUser_whenUserIsValid_userSavedToDatabase(){
        User user = User.builder().username("UserTest").displayName("Test-display").password("P4ssw0rd").build();

        ResponseEntity<Object> response = testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(userRepository.count()).isEqualTo(1);

    }
}
