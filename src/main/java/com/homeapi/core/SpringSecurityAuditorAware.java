package com.homeapi.core;

import com.homeapi.user.User;
import com.homeapi.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

//@Component
public class SpringSecurityAuditorAware implements AuditorAware<User>
{
    @Autowired
    private UserService userService;

    @Override
    public User getCurrentAuditor()
    {
        return userService.getAuthenticatedUser();
    }
}
