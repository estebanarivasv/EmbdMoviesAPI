package com.erivas.embd.utilities.constants;

public class Endpoints {

    public static final String API_VERSION = "/api/v1";
    public static final String ALL_ACTOR = API_VERSION + "/actors";
    public static final String ALL_DIRECTOR = API_VERSION + "/directors";
    public static final String ALL_MOVIES = API_VERSION + "/movies";
    public static final String ALL_PLAYLISTS = API_VERSION + "/playlists";

    public static final String SPECIFIC_ACTOR = API_VERSION + "/actor/{id}";
    public static final String SPECIFIC_COMMENT = API_VERSION + "/comment/{id}";
    public static final String SPECIFIC_DIRECTOR = API_VERSION + "/movie/{id}";
    public static final String SPECIFIC_MOVIE = API_VERSION + "/movie/{id}";
    public static final String SPECIFIC_PLAYLIST = API_VERSION + "/playlist/{id}";
    public static final String SPECIFIC_USER = API_VERSION + "/user/{id}";

    public static final String COMMENTS_FROM_MOVIE = SPECIFIC_MOVIE + "/comments";

    public Endpoints() {
    }
}
