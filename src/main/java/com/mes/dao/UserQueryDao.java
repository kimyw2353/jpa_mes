package com.mes.dao;

import com.mes.dto.system.UserListDto;
import com.mes.entity.User;
import com.mes.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserQueryDao extends QueryDao {
    private User newUser(ResultSet result) throws SQLException {
        User user = new User();
        user.setId(result.getInt("id"));
        user.setUserId(result.getString("user_id"));
        user.setName(result.getString("name"));
        user.setDepartment(result.getString("department"));
        user.setPosition(result.getString("position"));
        user.setTel(result.getString("tel"));
        user.setPhone(result.getString("phone"));
        user.setEmail(result.getString("email"));
        user.setCreatedAt(result.getDate("created_at"));
        user.setUpdatedAt(result.getDate("updated_at"));

        return user;
    }

    private String makeUserSearchQuery(String type, UserListDto dto) {
        String sql = "select ";
        sql += type.equals("list") ? "* " : "count(*) as cnt ";
        sql += "from users where 1 = 1 ";
        sql += whereLike("user_id", dto.getUserId());
        sql += whereLike("name", dto.getUserName());
        if (type.equals("list")) {
            sql += orderBy("created_at", "desc");
        }

        System.out.println(type + " query");
        System.out.println(sql);
        return sql;
    }

    public List<User> searchUsers(UserListDto dto) {
        List<User> users = new ArrayList<>();

        String sql = makeUserSearchQuery("list", dto);

        try (Connection connection = DBUtil.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                User user = newUser(result);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public long countOfSearchUsers(UserListDto dto) {
        long count = 0;

        String sql = makeUserSearchQuery("count", dto);

        try (Connection connection = DBUtil.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            if (result.next()) {
                count = result.getLong("cnt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
