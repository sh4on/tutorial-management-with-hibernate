package org.example.dao;

import org.example.model.Tutorial;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TutorialDAO {

    // Save a Tutorial entity to the database.
    public boolean saveTutorial(Tutorial tutorial) {
        boolean tutorialSavedSuccessfully = false;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.persist(tutorial);
                session.getTransaction().commit();

                tutorialSavedSuccessfully = true;
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }

        return tutorialSavedSuccessfully;
    }

    // Retrieve all Tutorial entities from the database.
    public List<Tutorial> getAllTutorials() {
        List<Tutorial> tutorials = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                Query<Tutorial> query = session.createQuery("from Tutorial", Tutorial.class);
                tutorials = query.list();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }

        return tutorials;
    }

    // Retrieve all published Tutorial entities from the database.
    public List<Tutorial> getAllPublishedTutorials() {
        List<Tutorial> tutorials = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                String queryHQL = "FROM Tutorial WHERE isPublished = :status";

                Query<Tutorial> query = session.createQuery(queryHQL, Tutorial.class);
                query.setParameter("status", true);

                tutorials = query.list();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }

        return tutorials;
    }

    // Retrieve a Tutorial entity by its ID.
    public Tutorial getTutorialById(Long id) {
        Tutorial tutorial = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                tutorial = session.get(Tutorial.class, id);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }

        return tutorial;
    }

    // Update a Tutorial entity in the database.
    public boolean updateTutorial(Tutorial updatedTutorial) {
        boolean tutorialUpdatedSuccessfully = false;

        if (getTutorialById(updatedTutorial.getTutorialID()) == null) {
            System.err.println(String.format("No tutorial found with ID no. %d to update.", updatedTutorial.getTutorialID()));
            return tutorialUpdatedSuccessfully;
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.merge(updatedTutorial);
                session.getTransaction().commit();

                tutorialUpdatedSuccessfully = true;
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }

        return tutorialUpdatedSuccessfully;
    }

    // Delete a Tutorial entity by its ID.
    public boolean deleteTutorialById(Long id) {
        boolean tutorialDeletedSuccessfully = false;

        if (getTutorialById(id) == null) {
            System.err.println(String.format("No tutorial found with ID no. %d to delete.", id));
            return tutorialDeletedSuccessfully;
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.remove(getTutorialById(id));
                session.getTransaction().commit();

                tutorialDeletedSuccessfully = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return tutorialDeletedSuccessfully;
    }
}
