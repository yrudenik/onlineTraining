package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.entity.JournalLine;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.util.List;

public interface JournalLineService {

    List<JournalLine> getJournal() throws ServiceException;

    JournalLine getJournalLineById(Long id) throws ServiceException;

    void saveJournalLine(Long courseId, Long studentId, boolean isDeleted) throws ServiceException;

    void deleteJournalLineById(Long journalLineId) throws ServiceException;
}
