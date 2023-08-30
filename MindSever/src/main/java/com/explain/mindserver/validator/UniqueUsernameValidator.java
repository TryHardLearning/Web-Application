package com.explain.mindserver.validator;

import com.explain.mindserver.annotation.UniqueUsername;
import com.explain.mindserver.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(userRepository.findUserByUsername(username) == null){
            return true;
        }
        return false;
    }
}
