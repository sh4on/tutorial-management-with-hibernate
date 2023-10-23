package org.example.service.impl;

import org.example.dao.TutorialDAO;
import org.example.model.Tutorial;
import org.example.service.TutorialService;

import java.util.List;

public class TutorialServiceImpl implements TutorialService {

    private TutorialDAO tutorialDAO;

    public TutorialServiceImpl(TutorialDAO tutorialDAO) {
        this.tutorialDAO = tutorialDAO;
    }

    @Override
    public String addTutorial(Tutorial tutorial) {
        return tutorialDAO.saveTutorial(tutorial);
    }

    @Override
    public List<Tutorial> getAllTutorials() {
        return tutorialDAO.getAllTutorials();
    }

    @Override
    public List<Tutorial> getAllPublishedTutorials() {
        return tutorialDAO.getAllPublishedTutorials();
    }

    @Override
    public Tutorial getTutorialById(long id) {
        return tutorialDAO.getTutorialById(id);
    }

    @Override
    public String updateTutorial(Tutorial tutorial) {
        return tutorialDAO.updateTutorial(tutorial);
    }

    @Override
    public String deleteTutorialById(long id) {
        return tutorialDAO.deleteTutorialById(id);
    }

    public TutorialDAO getTutorialDAO() {
        return tutorialDAO;
    }

    public void setTutorialDAO(TutorialDAO tutorialDAO) {
        this.tutorialDAO = tutorialDAO;
    }
}
