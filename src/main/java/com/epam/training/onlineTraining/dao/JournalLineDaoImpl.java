package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.JournalLine;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.mapper.JournalLineRowMapper;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;

public class JournalLineDaoImpl extends AbstractDao<JournalLine> implements JournalLineDao {

    private static final String GET_JOURNAL_QUERY = "select * from %s where is_deleted = false ";
    private static final String REMOVE_JOURNAL_LINE_QUERY = "update courses_journal set is_deleted = true WHERE id = ? ";

    public JournalLineDaoImpl(Connection connection) {
        super(connection, new JournalLineRowMapper(), JournalLine.TABLE);
    }

    @Override
    protected String getTableName() {
        return JournalLine.TABLE;
    }

    @Override
    protected LinkedHashMap<String, Object> getColumnValues(JournalLine entity) {
        LinkedHashMap<String, Object> values = new LinkedHashMap<>();
        values.put(JournalLine.ID, entity.getId());
        values.put(JournalLine.COURSE_ID, entity.getCourseId());
        values.put(JournalLine.STUDENT_ID, entity.getStudentId());
        values.put(JournalLine.IS_DELETED, entity.isDeleted());
        return values;
    }

    @Override
    public List<JournalLine> getJournal() throws DaoException {
        String query = String.format(GET_JOURNAL_QUERY, JournalLine.TABLE);
        return executeQuery(query);
    }

    @Override
    public void removeById(long Id) throws DaoException {
        executeUpdate(REMOVE_JOURNAL_LINE_QUERY, Id);
    }
}
