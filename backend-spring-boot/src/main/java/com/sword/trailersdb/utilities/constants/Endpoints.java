package com.sword.trailersdb.utilities.constants;

public class Endpoints {

    public static final String API_VERSION = "/api/v1";
    public static final String GLOBAL_COMMENTS = API_VERSION + "/comments";
    public static final String GLOBAL_MOVIES = API_VERSION + "/movies";
    public static final String GLOBAL_USERS = API_VERSION + "/users";

    public static final String SPECIFIC_COMMENT = API_VERSION + "/comment/{id}";
    public static final String SPECIFIC_MOVIE = API_VERSION + "/movie/{id}";
    public static final String SPECIFIC_USER = API_VERSION + "/user/{id}";

    public static final String COMMENTS_IN_MOVIE = API_VERSION + "/comment/{commentId}/movie/{movieId}";

    public Endpoints() {
    }
}
