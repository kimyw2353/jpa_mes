package com.mes.dao;

import com.mes.entity.User;

import java.util.List;

public class UserDao extends JpaDao<User> {
    public User findByUserId(String userId) {
        List<User> result = super.findWithNamedQuery("User.findByUserId", "user_id", userId);
        if (result != null && result.size() > 0) {
            return result.get(0);
        }

        return null;
    }
}
