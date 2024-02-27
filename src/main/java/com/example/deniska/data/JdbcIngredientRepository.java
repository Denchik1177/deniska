package com.example.deniska.data;

import com.example.deniska.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    /**
     * Надстройка позволяющая взаимодействовать с бд
     *
     * @param jdbcTemplate
     */
    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findlAll() {
        String sql = "SELECT id, name, type from Ingredient";
        return jdbcTemplate.query(sql, this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String Id) {
        String sql = "SELECT id, name, type FROM Ingredient WHERE id=?";
        List<Ingredient> results =
                jdbcTemplate.query(sql, this::mapRowToIngredient, Id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        String sql = "INSERT INTO Ingredient(id, name, type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType());
        return ingredient;
    }

    /**
     * @param row - текущ строка рез-та запроса
     * @param numberRow - номер строки
     * @return
     * @throws SQLException
     */
    private Ingredient mapRowToIngredient(ResultSet row, int numberRow) throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type")));
    }
}
