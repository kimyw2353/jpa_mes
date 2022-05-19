package com.mes.dao;

import java.util.Set;

public class QueryDao {
    protected String where(String column, String value) {
        String where = "";
        if (value != null && value.trim().length() > 0) {
            where += "and " + column + " = '" + value + "' ";
        }

        return where;
    }

    protected String whereLike(String column, String value) {
        String where = "";
        if (value != null && value.trim().length() > 0) {
            where += "and " + column + " like '%" + value + "%' ";
        }

        return where;
    }

    protected String orderBy(String column, String direction) {
        if (direction == null) {
            direction = "desc";
        }

        return "order by " + column + " " + direction;
    }
}
