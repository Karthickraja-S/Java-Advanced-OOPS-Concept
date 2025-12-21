## Singleton pattern    
    1. Used for not creating multiple objects like 
    DBConnection , CacheManager etc.,
    2. CacheManager - If it creates more objects, then inside 
    it will not have the cache data for new obj.
## Factory Pattern
    1. A class which can be extended by multiple provider comes under here.
    2. Ex : NotificationService ( Email,SMS,push ) , Payment ( online,offline,debit )
    3. An abstract class, and many class that extend abstract class and a factory which will return the 
    object based on input / setup ( reduces if-else code )
## Builder Pattern
    1. Reduces creating more constructor for many attributes which present in the class.
    Say, a class have 50 attribute, if all constructor needed then, 2^50 need to put.
    2. Also, it provides immutability nature.
    3. A Class with attributes & getters and constructor accepts Builder impl class , and a builder class which will get all those data
    and in build() method, the previous class will be setted based on its constructor.
## Prototype Pattern
    1. A clone of a object 
    2. What if object creation takes time. here we can return the object immediately with minor changes 
    based on the input right!