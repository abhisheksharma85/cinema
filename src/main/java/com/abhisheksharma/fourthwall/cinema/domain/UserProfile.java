package com.abhisheksharma.fourthwall.cinema.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A UserProfile.
 */
@Entity
@Table(name = "fw_cinema_user_profile")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "country")
    private String country;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "two_factor_authentication")
    private Boolean twoFactorAuthentication;

    @OneToOne
    @MapsId
    private User user;

    public UserProfile(){}

    public UserProfile(User user, String streetAddress, String postalCode, String city, String stateProvince, String country, String countryCode, Long phone, Boolean twoFactorAuthentication) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country = country;
        this.countryCode = countryCode;
        this.phone = phone;
        this.twoFactorAuthentication = twoFactorAuthentication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public UserProfile streetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public UserProfile postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public UserProfile city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public UserProfile stateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
        return this;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public UserProfile country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public UserProfile countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getPhone() {
        return phone;
    }

    public UserProfile phone(Long phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Boolean isTwoFactorAuthentication() {
        return twoFactorAuthentication;
    }

    public UserProfile twoFactorAuthentication(Boolean twoFactorAuthentication) {
        this.twoFactorAuthentication = twoFactorAuthentication;
        return this;
    }

    public void setTwoFactorAuthentication(Boolean twoFactorAuthentication) {
        this.twoFactorAuthentication = twoFactorAuthentication;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserProfile)) {
            return false;
        }
        return id != null && id.equals(((UserProfile) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + getId() +
                ", streetAddress='" + getStreetAddress() + "'" +
                ", postalCode='" + getPostalCode() + "'" +
                ", city='" + getCity() + "'" +
                ", stateProvince='" + getStateProvince() + "'" +
                ", country='" + getCountry() + "'" +
                ", countryCode='" + getCountryCode() + "'" +
                ", phone=" + getPhone() +
                ", twoFactorAuthentication='" + isTwoFactorAuthentication() + "'" +
                "}";
    }
}
