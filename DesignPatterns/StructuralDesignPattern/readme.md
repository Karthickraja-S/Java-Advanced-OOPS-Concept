## Fascade pattern
    1. With fascade pattern, a complex logic can be written in a method which wraps all those complex logic
    and client can call the wrapped method directly without writing their own code.
    2. EX : A withdraw method which will validate accDetails , pin , balance and proceed, send notification
    Without the pattern ( which we dont have withdraw method , ) the client need to validate in every place

## Adapter pattern
    1. Say an legacy api gives me xml as output , and another api gives me json as output and might be in future
    we dont know how many api we will interact and our DB accept only a POJO which will be inserted to DB.
    2. We can introduce adapter pattern here. ( an interface , an impl by all the api's which will hit api,
    convert to the POJO ) and then client code ( inserting to DB ) will be called.
        Usage : ThirdParty API Usage , Payment Gateway (where payment client jars will have different method 
            but u can have only pay and it will be impl by others),
        -> Want Unified Interface ; Dealing with legacy code / 3rd party API's

## PROXY PATTERN
    1. When we need some filtering , logging / caching the response we can use a proxy pattern.
    2. Simple : An client calls a proxy class which this internally calls service class with filtering/
        caching. Thats it!