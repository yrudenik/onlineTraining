package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.JournalLine;
import com.epam.training.onlineTraining.exception.DaoException;

import java.util.List;

public interface JournalLineDao extends Dao<JournalLine>{

    List<JournalLine> getJournal() throws DaoException;
}
