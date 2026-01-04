package com.adapterpattern.legacyapi;

import com.adapterpattern.OutputParser;
import com.adapterpattern.XMLApiAdapter;

public class Client {
    static void main() {
        // based on the user selection, hit the adapter pattern. so that it interacts with the
        // legacy api whether it will be internal api call / external api call.
        OutputParser parser = new XMLApiAdapter();
        parser.parse(null);
    }
}
