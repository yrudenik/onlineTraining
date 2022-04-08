package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.dao.DaoHelper;
import com.epam.training.onlineTraining.dao.DaoHelperFactory;
import com.epam.training.onlineTraining.dao.JournalLineDao;
import com.epam.training.onlineTraining.entity.JournalLine;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class JournalLineServiceImpl implements JournalLineService{

    private final DaoHelperFactory daoHelperFactory;

    public JournalLineServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public List<JournalLine> getJournal() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            JournalLineDao dao = helper.createJournalLineDao();
            List<JournalLine> journalLineList = dao.getJournal();
            helper.endTransaction();
            return journalLineList;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public JournalLine getJournalLineById(Long id) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            JournalLineDao dao = helper.createJournalLineDao();
            Optional<JournalLine> journalLine = dao.getById(id);
            if (!journalLine.isPresent()) {
                throw new ServiceException("This journal line doesn't exist");
            }
            helper.endTransaction();
            return journalLine.get();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveJournalLine(Long courseId, Long studentId, boolean isDeleted) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            JournalLineDao dao = helper.createJournalLineDao();
            JournalLine journalLine = new JournalLine(null, courseId, studentId, isDeleted);
            dao.save(journalLine);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteJournalLineById(Long journalLineId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create() ){
            helper.startTransaction();
            JournalLineDao dao = helper.createJournalLineDao();
            dao.removeById(journalLineId);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
