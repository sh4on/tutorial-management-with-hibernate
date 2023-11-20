package org.example.service;

import org.example.model.Tutorial;

import java.util.List;

public interface TutorialService {
    boolean addTutorial(Tutorial tutorial);

    List<Tutorial> getAllTutorials();

    List<Tutorial> getAllPublishedTutorials();

    Tutorial getTutorialById(Long id);

    boolean updateTutorial(Tutorial tutorial);

    boolean deleteTutorialById(Long id);
}
