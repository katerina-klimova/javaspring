package app.entities.mappers;

import app.entities.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item>{

    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        Item result = new Item();
        result.setId(resultSet.getLong("id"));
        result.setName(resultSet.getString("name"));
        result.setDescription(resultSet.getString("description"));
        result.setCost(resultSet.getDouble("cost"));
        result.setStatus(resultSet.getBoolean("status"));
        result.setIdUser(resultSet.getLong("id_user"));
        return result;
    }
}
