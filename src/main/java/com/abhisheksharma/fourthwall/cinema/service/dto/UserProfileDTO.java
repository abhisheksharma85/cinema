package com.abhisheksharma.fourthwall.cinema.service.dto;

import com.abhisheksharma.fourthwall.cinema.domain.UserProfile;

import java.io.Serializable;

/**
 * A DTO for the {@link UserProfile} entity.
 */
public class UserProfileDTO implements Serializable {

    private Long id;

    private String streetAddress;

    private String postalCode;

    private String city;

    private String stateProvince;

    private String country;

    private String countryCode;

    private Long phone;

    private Boolean twoFactorAuthentication;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Boolean isTwoFactorAuthentication() {
        return twoFactorAuthentication;
    }

    public void setTwoFactorAuthentication(Boolean twoFactorAuthentication) {
        this.twoFactorAuthentication = twoFactorAuthentication;
    }

    public UserProfileDTO(){
        // Empty constructor needed for Jackson.
    }

    public UserProfileDTO(UserProfile userProfile){
        this(userProfile.getId(),userProfile.getStreetAddress(),userProfile.getPostalCode(), userProfile.getCity(),
                userProfile.getStateProvince(),userProfile.getCountry(),userProfile.getCountryCode(),userProfile.getPhone(),
                userProfile.isTwoFactorAuthentication());

    }

    public UserProfileDTO(Long id, String streetAddress, String postalCode, String city, String stateProvince, String country,
                          String countryCode, Long phone, Boolean twoFactorAuthentication) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country = country;
        this.countryCode = countryCode;
        this.phone = phone;
        this.twoFactorAuthentication = twoFactorAuthentication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserProfileDTO)) {
            return false;
        }

        return id != null && id.equals(((UserProfileDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore

    @Override
    public String toString() {
        return "UserProfileDTO{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", phone=" + phone +
                ", twoFactorAuthentication=" + twoFactorAuthentication +
                '}';
    }
}
