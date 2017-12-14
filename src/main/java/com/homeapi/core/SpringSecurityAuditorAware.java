package com.homeapi.core;

import com.homeapi.user.User;
import com.homeapi.user.UserAwareUserDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

//@Component
public class SpringSecurityAuditorAware implements AuditorAware<User>
{
    @Override
    public User getCurrentAuditor()
    {
        return ((UserAwareUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }
}
