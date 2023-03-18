package com.enigma.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {
    private static String PERSISTENCE_NAME = "default";
    private static EntityManagerFactory entityManagerFactory;

    public static void getFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
    }

    public static EntityManager start() {
        if (entityManagerFactory == null) {
            getFactory();
        }
        System.out.println("success connect");
        return entityManagerFactory.createEntityManager();
    }
}
