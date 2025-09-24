package com.example;

import com.example.controller.ControllerKishor;
import com.example.entity.EntityKishor;
import com.example.repository.RepositoryKishor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class KishorTest {
@Autowired
private RepositoryKishor repositoryKishor;

@Autowired
private ControllerKishor controllerKishor;


    @Test
    @DisplayName("Should add user successfully")
    public void testAddUserSuccess() throws Exception {
        EntityKishor user = new EntityKishor(null, "Kishor", "Qwerty123!@#");

        ResponseEntity<?> response = controllerKishor.addUserKishor(user);

        assertEquals(200, response.getStatusCodeValue());


    }

    @Test
    @DisplayName("Should handle exception and return error response")
    public void testAddUserExceptionHandling() {
        // To simulate error, pass an invalid entity (e.g. null username which violates @NotBlank)
        EntityKishor invalidUser = new EntityKishor(null, "", "somepass");

        ResponseEntity<?> response = null;
        try {
            response = controllerKishor.addUserKishor(invalidUser);
            // You may want to check if it returns 401 and "Error" in body
            assertEquals(401, response.getStatusCodeValue());
            assertEquals("Error", response.getBody());
        } catch (Exception e) {
            fail("Exception was thrown instead of being handled");
        }
    }

    @Test
    @DisplayName("Should find user by ID successfully")
    public void testFindUserByIdSuccess() throws Exception {
        // First, save a user to repository to ensure it exists
        EntityKishor savedUser = repositoryKishor.save(new EntityKishor(null, "Kishor", "Qwerty123!@#"));

        // Call the controller method with saved user's id
        ResponseEntity<?> response = controllerKishor.findUserByIdKishor(savedUser.getId());

        // Verify response status is 200 OK
        assertEquals(200, response.getStatusCodeValue());


    }

    @Test
    @DisplayName("Should return 401 for user not found")
    public void testFindUserByIdNotFound() {
        Long invalidId = 9999L; // ID that doesn't exist

        ResponseEntity<?> response = controllerKishor.findUserByIdKishor(invalidId);

        // Expecting 401 status and specific error message
        assertEquals(401, response.getStatusCodeValue());
        assertEquals("Sama id koda", response.getBody());
    }


    public void testMain() {
        // Call the main method with empty args
        ExamkishorApplication.main(new String[]{});
    }



}
