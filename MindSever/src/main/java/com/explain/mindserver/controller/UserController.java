package com.explain.mindserver.controller;

import com.explain.mindserver.dto.UserDTO;
import com.explain.mindserver.error.ApiError;
import com.explain.mindserver.model.User;
import com.explain.mindserver.repository.UserRepository;
import com.explain.mindserver.service.UserService;
import com.explain.mindserver.shared.GenericResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController @RequestMapping("users")
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public GenericResponse createUser(@Valid @RequestBody UserDTO userDTO) {
        userService.save(modelMapper.map(userDTO, User.class));
        return GenericResponse.builder().message("Successful user saved").build();
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(
            MethodArgumentNotValidException e,
            HttpServletRequest request
    ){
        BindingResult result = e.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();
        for(FieldError error: result.getFieldErrors()){
            validationErrors.put(error.getField(), error.getDefaultMessage());
        }
        return new ApiError(400,"Validation error",request.getServletPath(),validationErrors);
    }
}