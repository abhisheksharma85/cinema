package com.abhisheksharma.fourthwall.cinema.config;


/**
 * Application constants.
 */
public  class Constants {
    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";

    public static final String DEFAULT_COUNTRY = "US";
    public static final String DEFAULT_LANGUAGE = "en";

    public static final Float MAX_RATING = 5.0f;

    public static class Source{
        public static final String  WEB      =   "web";
        public static final String  IPAD     =   "ipad";
        public static final String  IPHONE   =   "iphone";
        public static final String  ANDROID  =   "android";
        public static final String  IOS      =   "ios";
    }
}
