package com.proxypattern.user;

import com.proxypattern.Role;

public class UserProxyService implements UserRepo {
    // we have to restrict team to user proxy service instead of using UserService.
    private final UserService service;

    public UserProxyService() {
        service = new UserService();
    }

    @Override
    public User getUser(User curr, User target) {
        return service.getUser(curr,target);
    }

    @Override
    public User deleteUser(User curr, User target) {
        if(curr.role().equals(Role.ADMIN)) {
            return service.deleteUser(curr,target);
        }
        System.out.println("User : "+curr.name()+" is not authorized to do the operation..");
        return null;
    }
}
