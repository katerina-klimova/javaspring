package app.repositories;

import app.entities.Item;
import app.entities.User;
import app.entities.mappers.ItemRowMapper;
import app.entities.mappers.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> getAllItems() {
        return jdbcTemplate.query("select * from items", new ItemRowMapper());
    }
}
