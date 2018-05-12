package app.repositories;

import app.entities.User;
import app.entities.mappers.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }

    public User getUserByLogin(String login) {

        return jdbcTemplate.query("select * from users where login='"+login+"'", new UserRowMapper()).get(0);
    }

    public void addUser(String login, String password, String name, String role){
        String sql = "insert into users (login, password, fio, role,activity) values(?,?,?,?, true) ";
        Object [] args ={login,password,name,role};
        jdbcTemplate.update(sql,args);
    }
}