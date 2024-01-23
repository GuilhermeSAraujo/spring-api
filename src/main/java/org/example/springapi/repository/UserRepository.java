package org.example.springapi.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.example.springapi.domain.models.User;
import org.example.springapi.repository.interfaces.IUserRepository;
import org.example.springapi.repository.models.user.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM public.\"user\" WHERE email = ?";

        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("name"), rs.getInt("age"), rs.getString("email"));
                return user;
            }
        };

        List<User> users = jdbcTemplate.query(sql, rowMapper, email);

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public String create(CreateUserRequest request) {
        String sql = "INSERT INTO public.\"user\" (name, age, email, password) VALUES (?, ?, ?, ?)";

        int rowsAffected = jdbcTemplate.update(sql, request.getName(), request.getAge(), request.getEmail(),
                request.getPassword());

        return rowsAffected > 0 ? request.getEmail() : null;
    }
}
