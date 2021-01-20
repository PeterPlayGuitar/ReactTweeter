package com.a_peter0.react_tweeter.tweet.routes;

import com.a_peter0.react_tweeter.base.routes.BaseApiRoutes;

public class TweetApiRoutes extends BaseApiRoutes {

    public static final String SEARCH = V1 + "/tweets";
    public static final String FIND_BY_ID = V1 + "/tweets" + "/{id}";
    public static final String POST = V1 + "/tweets";
    public static final String DELETE = V1 + "/tweets" + "/{id}";
    public static final String PUT = V1 + "/tweets";
    public static final String LIKE = V1 + "/tweets" + "/{id}";
}
