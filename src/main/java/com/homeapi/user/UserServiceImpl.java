package com.homeapi.user;

import javafx.scene.shape.PathBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired EntityManager em;

    @Override
    public User getAuthenticatedUser()
    {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        TypedQuery<User> query = em.createQuery("SELECT user FROM User user WHERE user.name = :username", User.class)
                .setParameter("username", username)
                .setFlushMode(FlushModeType.COMMIT);

        User user = query.getSingleResult();

        em.detach(user);

        return user;
    }
}
