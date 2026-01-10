## Strategy Pattern
    1. Based on the user selection, we are calling its 
    stragegy. If it is not implemented, then we need to create more classes.
    2. An interface, and different strategy that implements that interface, an class which have a 
    constructor that accepts interface & triggers that strategy.
## Chain of responsibility
    1. It is a principle which allows objects to pass a request
    along a chain of handlers.
    2. Ex : After bar raiser interview round, we have tech round,  
    after that we have manager round & hr round. But all rounds will be asked questions & reply answer object.

    IMPLEMENTATION  :
        An Abstract class that have an setNext(AbstractClass) and callNext which 
    checks for !=null & triggers the businessLogic
## Decorator pattern 
    1. Similar to COR principle, however the sending object will be converted in each stage.
    Ex : Say an Document Object is being passed, in first class header footer is added , 
    second class adds data to it , third class adds signature to it and so on..
## State Design pattern
    1. Calling the respective method based on the current state of the object. If the object state changes,
        then its behaviour needs to be changed.
    Ref : https://www.geeksforgeeks.org/system-design/state-design-pattern/
    