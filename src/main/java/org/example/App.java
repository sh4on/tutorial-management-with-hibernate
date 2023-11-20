package org.example;

import org.example.model.Tutorial;
import org.example.service.TutorialService;
import org.example.service.impl.TutorialServiceImpl;
import org.example.util.HibernateUtil;

import java.sql.Date;

public class App {
    public static void main(String[] args) {
        // Create TutorialService instance
        TutorialService tutorialService = new TutorialServiceImpl();

        // Create tutorial instances
        Tutorial tutorial1 = new Tutorial();
        tutorial1.setTitle("Getting Started with Hibernate");
        tutorial1.setDescription("Learn the basics of Hibernate for database operations.");
        tutorial1.setPublished(true);
        tutorial1.setPublishedDate(Date.valueOf("2023-3-13"));

        Tutorial tutorial2 = new Tutorial();
        tutorial2.setTitle("Advanced Hibernate Techniques");
        tutorial2.setDescription("Explore advanced Hibernate features and techniques.");
        tutorial2.setPublished(true);
        tutorial2.setPublishedDate(Date.valueOf("2023-4-14"));

        Tutorial tutorial3 = new Tutorial();
        tutorial3.setTitle("Hibernate Best Practices");
        tutorial3.setDescription("Learn best practices for using Hibernate effectively.");
        tutorial3.setPublished(false);
        tutorial3.setPublishedDate(null); // Not published, so no published date.

        // Save tutorials to database
        tutorialService.addTutorial(tutorial1);
        tutorialService.addTutorial(tutorial2);
        tutorialService.addTutorial(tutorial3);

        // Retrieve a tutorial
        System.out.println("\n\nRetrieve a tutorial");
        System.out.println("--------------------------------------------");

        Tutorial tutorial = tutorialService.getTutorialById(1L);
        System.out.println(tutorial.getTitle());

        // Retrieve all published tutorials
        System.out.println("\n\nRetrieve all published tutorials");
        System.out.println("--------------------------------------------");

        for (Tutorial tut : tutorialService.getAllPublishedTutorials()) {
            System.out.println(tut.getTitle());
        }

        // Retrieve all tutorials
        System.out.println("\n\nRetrieve all tutorials");
        System.out.println("--------------------------------------------");

        for (Tutorial tut : tutorialService.getAllTutorials()) {
            System.out.println(tut.getTitle());
        }

        // Update a tutorial
        System.out.println("\n\nUpdate a tutorial");
        System.out.println("--------------------------------------------");

        Tutorial updatedTutorial = new Tutorial();
        updatedTutorial.setTutorialID(1L);
        updatedTutorial.setTitle("Getting Started with Hibernate (Updated)");
        updatedTutorial.setDescription("For database operations, learn the basics of Hibernate.");
        updatedTutorial.setPublished(true);
        updatedTutorial.setPublishedDate(Date.valueOf("2023-3-13"));

        tutorialService.updateTutorial(updatedTutorial);

        // Delete a tutorial
        System.out.println("\n\nDelete a tutorial");
        System.out.println("--------------------------------------------");

        tutorialService.deleteTutorialById(3L);

        // Let's once again check all the tutorials currently in the database.
        System.out.println("\n\nRetrieve all the tutorials currently in the database");
        System.out.println("--------------------------------------------");

        for (Tutorial tut : tutorialService.getAllTutorials()) {
            System.out.println(tut.getTitle());
        }

        // Close session factory
        HibernateUtil.closeSessionFactory();
    }
}