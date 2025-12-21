## Issue without builder pattern :
1) What if the attributes are more, say 50 and you need to pass null for other variables in
        initialization.
2) To pass only needed variables, we can create specific constructor. But how much?
Constructor Overload problem arrises. 2^50 constructor need to be created for 50 attributes.
The builder pattern resolves complex object creation , also gives immutability nature.
