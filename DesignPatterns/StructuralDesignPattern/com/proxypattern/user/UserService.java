package com.proxypattern.user;

public class UserService implements UserRepo{
    @Override
    public User getUser(User curr, User target) {
        System.out.println("User : "+curr.name()+" requesting user : "+target.name());
        return null;
    }

    @Override
    public User deleteUser(User curr, User target) {
        System.out.println("User : "+curr.name()+" deleting user : "+target.name());
        return null;
    }
}
