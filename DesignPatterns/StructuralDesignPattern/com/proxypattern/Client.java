package com.proxypattern;

import com.proxypattern.user.User;
import com.proxypattern.user.UserProxyService;
import com.proxypattern.user.UserRepo;

public class Client {
    static void main() {
        User user = new User("Karthick",Role.USER);
        User user2 = new User("Sundar",Role.ADMIN);

        UserRepo repo = new UserProxyService();

        repo.getUser(user,user2);
        repo.deleteUser(user,user2);

        repo.getUser(user2,user2);
        repo.deleteUser(user2,user2);
    }
}
