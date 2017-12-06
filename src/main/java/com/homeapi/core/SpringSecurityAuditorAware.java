package com.homeapi.core;

import com.homeapi.user.User;
import com.homeapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

//@Component
public class SpringSecurityAuditorAware implements AuditorAware<User>
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getCurrentAuditor()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated())
        {
            return null;
        }

        return userRepository.findByName(authentication.getName());
    }
}
