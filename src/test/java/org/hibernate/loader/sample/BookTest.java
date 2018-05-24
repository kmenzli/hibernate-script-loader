package org.hibernate.loader.sample;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         https://github.com/agoncal
 *         --
 */
public class BookTest {

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test
    public void shouldFindABook() throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateLoaderPU");
        EntityManager em = emf.createEntityManager();

        Book book = em.find(Book.class, 1234L);
/** to enable if needed */
/**
        assertNotNull(book);
        assertEquals("H2G2", book.getTitle());
        assertEquals("The universal answser to everything", book.getDescription());
 */
    }
}