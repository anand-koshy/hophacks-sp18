package com.example.tony_laptop.myapplication;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;
import org.scribe.model.Verb;

/**
 * Created by Tony_Laptop on 2/17/2018.
 */

class NounProjAPI extends DefaultApi10a{
    @Override
    public Verb getRequestTokenVerb()
    {
        return Verb.GET;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return "http://api.thenounproject.com/";
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "none";
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return "none";
    }
}
