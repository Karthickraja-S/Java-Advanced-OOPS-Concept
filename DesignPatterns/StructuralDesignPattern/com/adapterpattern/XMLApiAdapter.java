package com.adapterpattern;

import com.adapterpattern.legacyapi.LegacyXMLAPI;

public class XMLApiAdapter implements OutputParser{
    @Override
    public String parse(String data) {
        // returning just for simplicity. actual data needs to be converted to the required return type
        // what client expects.
        return new LegacyXMLAPI().getData();
    }
}
