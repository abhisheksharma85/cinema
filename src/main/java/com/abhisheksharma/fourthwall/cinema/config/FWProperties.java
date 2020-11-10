package com.abhisheksharma.fourthwall.cinema.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

/**
 * Properties specific to this application.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 */
@ConfigurationProperties(prefix = "fw", ignoreUnknownFields = false)
public class FWProperties {
    private final FWProperties.ClientApp clientApp = new FWProperties.ClientApp();
    private final FWProperties.Security security = new FWProperties.Security();
    private final FWProperties.Mail mail = new FWProperties.Mail();

    private final CorsConfiguration cors = new CorsConfiguration();


    public FWProperties(){}

    public FWProperties.Security getSecurity() {return this.security;}
    public FWProperties.ClientApp getClientApp() {return this.clientApp;}
    public FWProperties.Mail getMail() {return this.mail;}
    public CorsConfiguration getCors() {
        return this.cors;
    }


    public static  class ClientApp{
        private String name = "biologicAPI";
        public ClientApp(){ }
        public String getName() { return name;}
        public void setName(String name) { this.name = name; }
    }

    public static class Security {
        private final FWProperties.Security.Authentication authentication = new FWProperties.Security.Authentication();

        public Security(){}
        public FWProperties.Security.Authentication getAuthentication() { return  this.authentication;}
        public static class Authentication {
            private final FWProperties.Security.Authentication.Jwt jwt = new FWProperties.Security.Authentication.Jwt();

            public Authentication() {}

            public FWProperties.Security.Authentication.Jwt getJwt() {
                return this.jwt;
            }
            public static class Jwt {
                private String base64Secret;
                private long tokenValidityInSeconds;
                private long tokenValidityInSecondsForRememberMe;

                public Jwt() {
                    this.base64Secret = null;
                    this.tokenValidityInSeconds = 1800L;
                    this.tokenValidityInSecondsForRememberMe = 2592000L;
                }

                public String getBase64Secret() {
                    return this.base64Secret;
                }

                public void setBase64Secret(String base64Secret) {
                    this.base64Secret = base64Secret;
                }

                public long getTokenValidityInSeconds() {
                    return this.tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) { this.tokenValidityInSeconds = tokenValidityInSeconds; }

                public long getTokenValidityInSecondsForRememberMe() { return this.tokenValidityInSecondsForRememberMe; }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) { this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe; }
            }
        }
    }
    public static class Mail{

        private String address;
        private String personal;

        public Mail(){}

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }
        public String getPersonal() { return personal; }
        public void setPersonal(String personal) { this.personal = personal; }
    }

}
