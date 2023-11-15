package org.example;

import org.example.dao.TutorialDAO;
import org.example.model.Tutorial;
import org.example.service.TutorialService;
import org.example.service.impl.TutorialServiceImpl;
import org.example.util.HibernateUtil;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        // Initialize the TutorialService with a TutorialDAO implementation

        TutorialService tutorialService = new TutorialServiceImpl(new TutorialDAO());

        // Create tutorial instances

        Tutorial tutorial1 = new Tutorial();
        tutorial1.setTitle("Getting Started with Hibernate");
        tutorial1.setDescription("Learn the basics of Hibernate for database operations.");
        tutorial1.setPublished(true);
        tutorial1.setPublishedDate(new Date());

        Tutorial tutorial2 = new Tutorial();
        tutorial2.setTitle("Advanced Hibernate Techniques");
        tutorial2.setDescription("Explore advanced Hibernate features and techniques.");
        tutorial2.setPublished(true);
        tutorial2.setPublishedDate(new Date());

        Tutorial tutorial3 = new Tutorial();
        tutorial3.setTitle("Hibernate Best Practices");
        tutorial3.setDescription("Learn best practices for using Hibernate effectively.");
        tutorial3.setPublished(false);
        tutorial3.setPublishedDate(null); // Not published, so no published date.

        // Add tutorials to the database

        tutorialService.addTutorial(tutorial1);
        tutorialService.addTutorial(tutorial2);
        tutorialService.addTutorial(tutorial3);

        // Delete a tutorial

        System.out.println("\n\nDelete a tutorial");
        System.out.println("--------------------------------------------");
        String deletedMessage = tutorialService.deleteTutorialById(2);
        System.out.println(deletedMessage);

        // Trying to delete a tutorial with invalid ID

        System.out.println("\n\nTrying to delete a tutorial with invalid ID");
        System.out.println("--------------------------------------------");
        String deletedMessage2 = tutorialService.deleteTutorialById(Long.MAX_VALUE);
        System.out.println(deletedMessage2);

        // Update a tutorial

        Tutorial updatedTutorial = new Tutorial();
        updatedTutorial.setId(1);
        updatedTutorial.setTitle("Getting Started with Hibernate (Updated)");
        updatedTutorial.setDescription("Learn the basics of Hibernate for database operations.");
        updatedTutorial.setPublished(true);
        updatedTutorial.setPublishedDate(new Date());

        System.out.println("\n\nUpdate a tutorial");
        System.out.println("--------------------------------------------");
        String updatedMessage = tutorialService.updateTutorial(updatedTutorial);
        System.out.println(updatedMessage);

        // Trying to update a tutorial with invalid ID

        Tutorial updatedTutorialWithInvalidID = new Tutorial();
        updatedTutorialWithInvalidID.setId(Long.MAX_VALUE);
        updatedTutorialWithInvalidID.setTitle("Getting Started with Hibernate (Updated)");
        updatedTutorialWithInvalidID.setDescription("Learn the basics of Hibernate for database operations.");
        updatedTutorialWithInvalidID.setPublished(true);
        updatedTutorialWithInvalidID.setPublishedDate(new Date());

        System.out.println("\n\nTrying to update a tutorial with invalid ID");
        System.out.println("--------------------------------------------");
        String updatedMessage2 = tutorialService.updateTutorial(updatedTutorialWithInvalidID);
        System.out.println(updatedMessage2);

        // Retrieve a tutorial

        System.out.println("\n\nRetrieve a tutorial");
        System.out.println("--------------------------------------------");
        Tutorial tutorial = tutorialService.getTutorialById(1);
        System.out.println(tutorial.getTitle());


        // Trying to retrieve a tutorial with invalid ID

        System.out.println("\n\nTrying to retrieve a tutorial with invalid ID");
        System.out.println("--------------------------------------------");
        Tutorial tutorialWithInvalidID = tutorialService.getTutorialById(Long.MAX_VALUE);
        if (tutorialWithInvalidID == null) {
            System.out.println("Data not found!");
        }

        // Retrieve and print all published tutorials

        System.out.println("\n\nRetrieve and print all published tutorials");
        System.out.println("--------------------------------------------");
        for (Tutorial tut : tutorialService.getAllPublishedTutorials()) {
            System.out.println(tut.getTitle());
        }

        // Retrieve and print all tutorials

        System.out.println("\n\nRetrieve and print all tutorials");
        System.out.println("--------------------------------------------");
        for (Tutorial tut : tutorialService.getAllTutorials()) {
            System.out.println(tut.getTitle());
        }

    }
}