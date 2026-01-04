package com.adapterpattern;

public interface OutputParser {
    String parse(String data); // here the return type would be based on our app ( POJO / an str )
}
