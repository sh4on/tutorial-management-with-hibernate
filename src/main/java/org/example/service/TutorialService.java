package org.example.service;

import org.example.model.Tutorial;

import java.util.List;

public interface TutorialService {
    String addTutorial(Tutorial tutorial);

    List<Tutorial> getAllTutorials();

    List<Tutorial> getAllPublishedTutorials();

    Tutorial getTutorialById(long id);

    String updateTutorial(Tutorial tutorial);

    String deleteTutorialById(long id);
}
