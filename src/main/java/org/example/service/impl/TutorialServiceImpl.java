package org.example.service.impl;

import org.example.dao.TutorialDAO;
import org.example.model.Tutorial;
import org.example.service.TutorialService;

import java.util.List;

public class TutorialServiceImpl implements TutorialService {

    private TutorialDAO tutorialDAO;

    {
        tutorialDAO = new TutorialDAO();
    }

    @Override
    public boolean addTutorial(Tutorial tutorial) {
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
    public Tutorial getTutorialById(Long id) {
        return tutorialDAO.getTutorialById(id);
    }

    @Override
    public boolean updateTutorial(Tutorial tutorial) {
        return tutorialDAO.updateTutorial(tutorial);
    }

    @Override
    public boolean deleteTutorialById(Long id) {
        return tutorialDAO.deleteTutorialById(id);
    }
}
