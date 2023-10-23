package org.example.dao;

import org.example.model.Tutorial;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TutorialDAO {

    // Save a Tutorial entity to the database.
    public String saveTutorial(Tutorial tutorial) {
        String message;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.persist(tutorial);
                session.getTransaction().commit();

                message = String.format("Tutorial with ID %d Saved successfully.", tutorial.getId());
            } catch (HibernateException e) {
                message = e.getMessage();
            }
        }

        return message;
    }

    // Retrieve all Tutorial entities from the database.
    public List<Tutorial> getAllTutorials() {
        List<Tutorial> tutorials = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                String queryHQL = "from Tutorial";
                Query<Tutorial> query = session.createQuery(queryHQL, Tutorial.class);

                tutorials = query.list();
            } catch (HibernateException e) {
                System.err.println(e.getMessage());
            }
        }

        return tutorials;
    }

    // Retrieve all published Tutorial entities from the database.
    public List<Tutorial> getAllPublishedTutorials() {
        List<Tutorial> tutorials = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                String queryHQL = "FROM Tutorial WHERE isPublished = :p ";

                Query<Tutorial> query = session.createQuery(queryHQL, Tutorial.class);
                query.setParameter("p", true);

                tutorials = query.list();
            } catch (HibernateException e) {
                System.err.println(e.getMessage());
            }
        }

        return tutorials;
    }

    // Retrieve a Tutorial entity by its ID.
    public Tutorial getTutorialById(long id) {
        Tutorial tutorial = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                String queryHQL = "FROM Tutorial WHERE id = :id";

                Query<Tutorial> query = session.createQuery(queryHQL, Tutorial.class);
                query.setParameter("id", id);

                tutorial = query.uniqueResult();
            } catch (HibernateException e) {
                System.err.println(e.getMessage());
            }
        }

        return tutorial;
    }

    // Update a Tutorial entity in the database.
    public String updateTutorial(Tutorial updateTutorial) {
        String message;

        if (getTutorialById(updateTutorial.getId()) == null) {
            message = String.format("No tutorial found with ID no. %d to update.", updateTutorial.getId());
            return message;
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.merge(updateTutorial);
                session.getTransaction().commit();

                message = String.format("Tutorial with ID %d updated successfully.", updateTutorial.getId());
            } catch (HibernateException e) {
                message = e.getMessage();
            }
        }

        return message;
    }

    // Delete a Tutorial entity by its ID.
    public String deleteTutorialById(long id) {
        String message;

        if (getTutorialById(id) == null) {
            message = String.format("No tutorial found with ID no. %d to delete.", id);
            return message;
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.remove(getTutorialById(id));
                session.getTransaction().commit();

                message = String.format("Tutorial with ID %d deleted successfully.", id);
            } catch (Exception e) {
                message = e.getMessage();
            }
        }

        return message;
    }
}
