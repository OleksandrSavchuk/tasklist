package com.example.tasklist.repository.impl;

import com.example.tasklist.domain.exception.ResourceMappingException;
import com.example.tasklist.domain.task.Task;
import com.example.tasklist.repository.DataSourceConfig;
import com.example.tasklist.repository.TaskRepository;
import com.example.tasklist.repository.mappers.TaskRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

//@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final DataSourceConfig dataSourceConfig;

    private final String FIND_BY_ID = """
            SELECT t.id              as task_id,
                   t.title           as task_title,
                   t.description     as task_description,
                   t.expiration_date as task_expiration_date,
                   t.status          as task_status
            FROM tasks t
            WHERE t.id = ?""";

    private final String FIND_ALL_BY_USER_ID = """
            SELECT t.id              as task_id,
                   t.title           as task_title,
                   t.description     as task_description,
                   t.expiration_date as task_expiration_date,
                   t.status          as task_status
            FROM tasks t
                     JOIN users_tasks ut on t.id = ut.task_id
            WHERE ut.user_id = ?""";

    private final String ASSIGN = """
            INSERT INTO user_tasks (task_id, user_id)
            VALUES (?, ?)""";

    private final String CREATE = """
            INSERT INTO tasks (title, description, expiration_date, status)
            VALUES (?, ?, ?, ?)""";

    private final String UPDATE = """
            UPDATE tasks
            SET title = ?, 
                description = ?, 
                expiration_date = ?, 
                status = ?
            WHERE id = ?""";

    private final String DELETE = """
            DELETE FROM tasks
            WHERE id = ?""";

    @Override
    public Optional<Task> findById(Long id) {
        try {
            Connection connection = dataSourceConfig.getconnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return Optional.ofNullable(TaskRowMapper.mapRow(resultSet));
        } catch (SQLException throwables) {
            throw new ResourceMappingException("Error while finding task by id: " + id);
        }
    }

    @Override
    public List<Task> findAllByUserId(Long userId) {
        try {
            Connection connection = dataSourceConfig.getconnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_USER_ID);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            return TaskRowMapper.mapRows(resultSet);
        } catch (SQLException throwables) {
            throw new ResourceMappingException("Error while finding all tasks by userId: " + userId);
        }
    }

    @Override
    public void assignToUserById(Long taskId, Long userId) {
        try {
            Connection connection = dataSourceConfig.getconnection();
            PreparedStatement statement = connection.prepareStatement(ASSIGN);
            statement.setLong(1, taskId);
            statement.setLong(2, userId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new ResourceMappingException("Error while assing to user");
        }
    }

    @Override
    public void update(Task task) {
        try {
            Connection connection = dataSourceConfig.getconnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, task.getTitle());
            if (task.getDescription() == null) {
                statement.setNull(2, Types.NULL);
            } else {
                statement.setString(2, task.getDescription());
            }
            if (task.getExpirationDate() == null) {
                statement.setNull(3, Types.TIMESTAMP);
            } else {
                statement.setTimestamp(3, Timestamp.valueOf(task.getExpirationDate()));
            }
            statement.setString(4, task.getStatus().name());
            statement.setLong(5, task.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new ResourceMappingException("Error while updating task");
        }
    }

    @Override
    public void create(Task task) {
        try {
            Connection connection = dataSourceConfig.getconnection();
            PreparedStatement statement = connection.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, task.getTitle());
            if (task.getDescription() == null) {
                statement.setNull(2, Types.NULL);
            } else {
                statement.setString(2, task.getDescription());
            }
            if (task.getExpirationDate() == null) {
                statement.setNull(3, Types.TIMESTAMP);
            } else {
                statement.setTimestamp(3, Timestamp.valueOf(task.getExpirationDate()));
            }
            statement.setString(4, task.getStatus().name());
            try (ResultSet rs = statement.getGeneratedKeys()) {
                rs.next();
                task.setId(rs.getLong(1));
            }
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new ResourceMappingException("Error while creating task");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = dataSourceConfig.getconnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new ResourceMappingException("Error while deleting to user");
        }
    }

}
