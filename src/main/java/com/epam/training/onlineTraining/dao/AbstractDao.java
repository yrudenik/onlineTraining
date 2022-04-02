package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Identifable;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.mapper.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public abstract class AbstractDao <T extends Identifable> implements Dao<T> {

    private final Connection connection;
    private final RowMapper<T> mapper;
    private final String tableName;

    public AbstractDao(Connection connection, RowMapper<T> mapper, String tableName) {
        this.connection = connection;
        this.mapper = mapper;
        this.tableName = tableName;
    }

    protected List<T> executeQuery(String query, Object... parameters) throws DaoException {
        try (PreparedStatement statement = createStatement(query, parameters)) {
            ResultSet resultSet = statement.executeQuery();
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

/*    protected List<T> executeQuery(String query, Map<String, Object> valuesMap) throws DaoException {
        try (PreparedStatement preparedStatement = createPreparedStatementByValues(query, valuesMap)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }*/

/*    protected List<T> executeQuery(String query, RowMapper<T> mapper, Object... parameters) throws DaoException {
        try (PreparedStatement statement = createStatement(query, parameters)) {
            ResultSet resultSet = statement.executeQuery(query);//ResultSet resultSet = statement.executeQuery();
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }*/

    private PreparedStatement createStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 1; i <= params.length; i++) {
            statement.setObject(i, params[i - 1]);
        }
        return statement;
    }

    public List<T> getAll() throws DaoException{
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        return executeQuery("select * from" + table, mapper);
    }

    @Override
    public Optional<T> getById(Long id) throws DaoException {
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        return executeForSingleResult("SELECT * FROM ? WHERE id = ?" + table, mapper, id);
    }

    protected Optional<T> executeForSingleResult(String query, Object... params) throws DaoException {
        List<T> entities = executeQuery(query, params);
        if (entities.size() == 1) {
            return Optional.of(entities.get(0));
        } else if (entities.size() > 1) {
            throw new IllegalArgumentException("More than one result found");
        } else {
            return Optional.empty();
        }
    }

    private String add(Map<String, Object> values, String query) {
        StringBuilder stringBuilder = new StringBuilder(query);
        for (String key : values.keySet()) {
            if (!key.equals("id")) {
                stringBuilder.append(" ? = ?,");
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void removeById(Long id) throws DaoException {
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        executeQuery("UPDATE ? SET is_deleted = true WHERE id = ?" + table, mapper, id);
    }

    private String update(Map<String, Object> values) {
        StringBuilder stringBuilder = new StringBuilder("UPDATE ? SET");
        for (String key : values.keySet()) {
            if (!key.equals("id")) {
                stringBuilder.append(" ? = ?,");
            }
        }
        stringBuilder.append(" WHERE id = ?");
        return stringBuilder.toString();
    }

    private PreparedStatement createPreparedStatementByValues(String query, Map<String, Object> values) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int preparedStatementIndex = 1;
        for (String key : values.keySet()) {
            preparedStatement.setObject(preparedStatementIndex++, values.get(key));
        }
        return preparedStatement;
    }

/*        private PreparedStatement createPreparedStatementByValues(String query, Map<String, Object> values) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setObject(i++, tableName);
        for (String key : values.keySet()) {
            if (!key.equals("id")) {
                preparedStatement.setObject(i++, key);
                preparedStatement.setObject(i++, values.get(key));
            }
        }
        if (values.get("id") != null) {
            preparedStatement.setObject(i, values.get("id"));
        }
        return preparedStatement;
    }*/

    private List<T> getResults(ResultSet resultSet) throws SQLException {
        List<T> entities = new ArrayList<>();
        while (resultSet.next()) {
            T entity = mapper.map(resultSet);
            entities.add(entity);
        }
        return entities;
    }

    protected abstract String getTableName();

/*    @Override
    public void save(T item) throws DaoException {
        Map<String, Object> valuesMap = getColumnValues(item);
        String query = item.getId() == null ? add(valuesMap, "INSERT INTO ? SET") : update(valuesMap);
        try (PreparedStatement preparedStatement = createPreparedStatementByValues(query, valuesMap)) {
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }*/

    @Override
    public void save(T item) throws DaoException {
        Map<String, Object> valuesMap = getColumnValues(item);
        Object id = valuesMap.remove("id");
        String query;
        if (item.getId() == null) {
            query = buildParametrisedQuery(valuesMap, String.format("INSERT INTO %s SET", tableName), ",", "");
        } else {
            query = buildParametrisedQuery(valuesMap, String.format("INSERT INTO %s SET", tableName), ",", "WHERE id = ?");
            valuesMap.put("id", id);
        }
        executeUpdate(query, valuesMap);
    }

    private String buildParametrisedQuery(Map<String, Object> valuesMap, String queryBeginning, String conditionDelimiter, String queryEnd) {
        StringBuilder stringBuilder = new StringBuilder(queryBeginning);
        for (String key : valuesMap.keySet()) {
            stringBuilder.append(" ");
            stringBuilder.append(key);
            stringBuilder.append(" = ? ");
            stringBuilder.append(conditionDelimiter);
        }
        stringBuilder.setLength(stringBuilder.length() - conditionDelimiter.length());
        stringBuilder.append(" ");
        stringBuilder.append(queryEnd);
        stringBuilder.append(" ;");
        return stringBuilder.toString();
    }

    protected void executeUpdate(String query, Object... parameters) throws DaoException {
        try (PreparedStatement preparedStatement = createStatement(query, parameters)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //LOGGER.error(e);
            throw new DaoException(e);
        }
    }

    protected void executeUpdate(String query, Map<String, Object> valuesMap) throws DaoException {
        try (PreparedStatement preparedStatement = createPreparedStatementByValues(query, valuesMap)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //LOGGER.error(e);
            throw new DaoException(e);
        }
    }



    protected abstract LinkedHashMap<String, Object> getColumnValues(T entity);




/*    public List<T> checkDupliсate(T item) throws DaoException {
        Map<String, Object> values = getColumnValues(item);
        String query = add(values, "SELECT * FROM ? WHERE");
        try (PreparedStatement preparedStatement = createPreparedStatementByValues(query, values)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return getResults(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }*/

}

