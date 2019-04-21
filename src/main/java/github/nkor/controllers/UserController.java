package github.nkor.controllers;

import github.nkor.services.CustomUserDetailsService.UserDetailsWithUserEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    @PostMapping(value = "/logout")
    public void logout(HttpSession httpSession, UsernamePasswordAuthenticationToken principal) {
        UserDetailsWithUserEntity userDetailsWithUserEntity = (UserDetailsWithUserEntity) principal.getPrincipal();

        httpSession.invalidate();
        LOG.log(Level.INFO, "User {0} has been logged out successfully", userDetailsWithUserEntity.getUsername());
    }
}