package com.abhisheksharma.fourthwall.cinema.web.rest;

import com.abhisheksharma.fourthwall.cinema.domain.User;
import com.abhisheksharma.fourthwall.cinema.service.UserService;
import com.abhisheksharma.fourthwall.cinema.service.dto.RegisterDTO;
import com.abhisheksharma.fourthwall.cinema.web.rest.error.InvalidPasswordException;
import com.abhisheksharma.fourthwall.cinema.web.rest.error.EmailAlreadyUsedException;
import com.abhisheksharma.fourthwall.cinema.web.rest.error.LoginAlreadyUsedException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api")
public class AccountResource {

    private static class AccountResourceException extends RuntimeException {
        private AccountResourceException(String message) {
            super(message);
        }
    }

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);


    private final UserService userService;

    public AccountResource(UserService userService) {
        this.userService = userService;
    }

    /**
     * {@code POST  /register} : register the user.
     *
     * @param registerDTO the managed user View Model.
     * @throws InvalidPasswordException {@code 400 (Bad Request)} if the password is incorrect.
     * @throws EmailAlreadyUsedException {@code 400 (Bad Request)} if the email is already used.
     * @throws LoginAlreadyUsedException {@code 400 (Bad Request)} if the login is already used.
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterDTO registerDTO) {
        if (!checkPasswordLength(registerDTO.getPassword())) {
            throw new InvalidPasswordException();
        }
        User user = userService.registerUser(registerDTO, registerDTO.getPassword());
    }

    private static boolean checkPasswordLength(String password) {
        return !StringUtils.isEmpty(password) &&
                password.length() >= RegisterDTO.PASSWORD_MIN_LENGTH &&
                password.length() <= RegisterDTO.PASSWORD_MAX_LENGTH;
    }

    /**
     * {@code GET  /authenticate} : check if the user is authenticated, and return its login.
     *
     * @param request the HTTP request.
     * @return the login if the user is authenticated.
     */
    @GetMapping("/authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        log.debug("REST request to check if the current user is authenticated");
        return request.getRemoteUser();
    }

}
