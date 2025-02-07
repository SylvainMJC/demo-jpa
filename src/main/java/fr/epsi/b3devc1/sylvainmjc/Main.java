package fr.epsi.b3devc1.sylvainmjc;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa")) {
            emf.close();
            System.out.println("Database connection successful.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection failed.");
        }
    }
}