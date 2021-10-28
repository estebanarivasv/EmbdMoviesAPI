package com.erivas.embd.utilities.constants;

public class Endpoints {

    public static final String API_VERSION = "/api/v1";
    public static final String BASE_ACTORS = API_VERSION + "/actors";
    public static final String BASE_COMMENTS = API_VERSION + "/comments";
    public static final String BASE_DIRECTORS = API_VERSION + "/directors";
    public static final String BASE_MOVIES = API_VERSION + "/movies";
    public static final String BASE_PLAYLISTS = API_VERSION + "/playlists";
    public static final String BASE_USERS = API_VERSION + "/users";

    public static final String SINGLE_GENERIC = "/{id}";
    public static final String COMMENTS_FROM_MOVIE = "/{id}/comments";

    public Endpoints() {
    }
}
