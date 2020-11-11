package com.abhisheksharma.fourthwall.cinema.service;

public class DeviceDTO {

    private String ipAddress;

    private Double lat;

    private Double lng;

    private String source;

    private String deviceToken;

    private String version;

    public DeviceDTO(){}

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "DeviceDTO{" +
                "ipAddress='" + ipAddress + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", source='" + source + '\'' +
                ", deviceToken='" + deviceToken + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
