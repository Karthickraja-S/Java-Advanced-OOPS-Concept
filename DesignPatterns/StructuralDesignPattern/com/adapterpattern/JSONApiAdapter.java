package com.adapterpattern;

import com.adapterpattern.legacyapi.JSONApi;

public class JSONApiAdapter implements OutputParser{
    @Override
    public String parse(String data) {
        // interact with the api's convert to the return type so that it acts as adapter
        return new JSONApi().getData();
    }
}
