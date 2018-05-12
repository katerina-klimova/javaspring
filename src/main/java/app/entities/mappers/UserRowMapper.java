package app.entities.mappers;

import app.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper  implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User result = new User();
        result.setId(resultSet.getLong("id"));
        result.setLogin(resultSet.getString("login"));
        result.setPassword(resultSet.getString("password"));
        result.setRole(resultSet.getString("role"));
        result.setFIO(resultSet.getString("FIO"));
        result.setEmail(resultSet.getString("E-Mail"));
        result.setActivity(resultSet.getBoolean("activity"));
        return result;
    }
}
