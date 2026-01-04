package com.proxypattern.user;

public interface UserRepo {
    User getUser(User curr , User target);
    User deleteUser(User curr , User target);
}
