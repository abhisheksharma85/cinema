package com.abhisheksharma.fourthwall.cinema.security;

import com.abhisheksharma.fourthwall.cinema.domain.User;
import com.abhisheksharma.fourthwall.cinema.repository.UserRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Service
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UserRepository userRepository;

    public DomainUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);

        if (new EmailValidator().isValid(login, null)) {
            return userRepository.findOneWithAuthoritiesByEmailIgnoreCase(login)
                    .map(user -> createSpringSecurityDomainUser(login, user))
                    .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
        }

        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        return userRepository.findOneWithAuthoritiesByLogin(lowercaseLogin)
                .map(user -> createSpringSecurityDomainUser(lowercaseLogin, user))
                .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));



    }

    private DomainUser createSpringSecurityDomainUser(String lowercaseLogin, User user) {
        log.debug("Create SpringSecurity DomainUser {}",lowercaseLogin);
        if (!user.getActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        }
        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());

        DomainUser domainUser =  new DomainUser(user.getId(), user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(),
                grantedAuthorities, user.getLangKey(), user.getUserProfile().isTwoFactorAuthentication(), user.getEmail(),
                user.getUserProfile().getCountryCode(), user.getUserProfile().getPhone());

        return domainUser;
    }


}
