package com.abhisheksharma.fourthwall.cinema.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

public class DomainUser extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean twoFactorAuthentication;
    private String email;
    private String countryCode;
    private Long phone;
    private String langKey;
    private String source;

    public DomainUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public DomainUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public DomainUser(Long id, String username, String password, String firstName, String lastName,
                      Collection<? extends GrantedAuthority> authorities){
        super(username,password,authorities);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName == null ? "" : lastName;
    }


    public DomainUser(Long id,String username, String password,String firstName, String lastName,
                      Collection<? extends GrantedAuthority> authorities,String langKey,
                      Boolean twoFactorAuthentication,String email,String countryCode, Long phone){
        super(username,password,authorities);
        this.id = id;
        this.twoFactorAuthentication = twoFactorAuthentication;
        this.firstName = firstName;
        this.lastName = lastName == null ? "" : lastName;
        this.email = email;
        this.langKey = langKey;
        this.countryCode = countryCode;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean isTwoFactorAuthentication() {
        return twoFactorAuthentication;
    }

    public void setTwoFactorAuthentication(Boolean twoFactorAuthentication) {
        this.twoFactorAuthentication = twoFactorAuthentication;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getAuthoritiesData(){
        return getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    public String getSource() { return source; }

    public void setSource(String source) { this.source = source; }

    @Override
    public String toString() {
        return "DomainUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", twoFactorAuthentication=" + twoFactorAuthentication +
                ", email='" + email + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", phone=" + phone +
                ", langKey='" + langKey + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
