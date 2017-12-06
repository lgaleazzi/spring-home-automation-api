package com.homeapi.core;

import com.homeapi.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;


@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class RestConfig extends RepositoryRestConfigurerAdapter
{
    @Autowired
    @Lazy
    private Validator validator;

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener)
    {
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeSave", validator);
    }

    @Bean
    AuditorAware<User> auditorProvider() {
        return new SpringSecurityAuditorAware();
    }
}
