package com.mySpringProject.demo.modules;

public class CelebrationUrls {
  public static class CelebrantController {
    public static final String PATH = "/celebrants";
    public static final String POST_CELEBRANT = "/{userId}";

  }

  public static class CelebrationController {
    public static final String PATH = "/celebrations";
    public static final String POST_CELEBRATION = "/{celebrantId}";
    public static final String GET_LIST_CELEBRATION ="/{celebrantId}";

  }
  public static class UserController {
    public static final String PATH = "/users";
    public static final String POST_CELEBRATION = "/{celebrantId}";

  }
}
