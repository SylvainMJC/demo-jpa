package fr.epsi.b3devc1.sylvainmjc;

import fr.epsi.b3devc1.sylvainmjc.bo.Client;
import fr.epsi.b3devc1.sylvainmjc.bo.Emprunt;
import fr.epsi.b3devc1.sylvainmjc.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
            EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            //Livre livre = new Livre("Harry Potter et le prisonnier d'Azkaban", "J.K. Rowling");

//            Livre livre = em.find(Livre.class, 1);
//            if(livre != null) {
//                System.out.println(livre);
//                livre.setTitre("Vingt mille lieues sous les mers 2 : Le Sequel");
//                System.out.println(livre);
//                livre.setAuteur("Jules Verne Junior");
//                System.out.println(livre);
//                livre.setTitre("Vingt mille lieues sous les mers");
//                livre.setAuteur("Jules Verne");
//            }



            /*
            //C -> création du fournisseur
            Fournisseur fournisseur = new Fournisseur("Fournisseur 1", "123456789");
            em.persist(fournisseur);

            //R -> Récupération du Fournisseur
            Fournisseur fournisseur3 = em.find(Fournisseur.class, 3);
            System.out.println(fournisseur3);

            //U -> Mise à jour du Fournisseur
            Fournisseur fournisseur4 = em.find(Fournisseur.class, 4);
            if(fournisseur4 != null) {
                fournisseur4.setRaisonSociale("Fournisseur 4");
            }

            //D -> Suppression du Fournisseur
            Fournisseur fournisseur5 = em.find(Fournisseur.class, 5);
            if(fournisseur5 != null) {
                em.remove(fournisseur5);
            }
            */


            // TP 3 : Réaliser une requête qui permet d’extraire un emprunt en fonction son id.
            Emprunt emprunt = em.find(Emprunt.class, 1);
            System.out.println("emprunt");
            System.out.println(emprunt);

            //o Affichez tous les livres associés
            System.out.println("emprunt.getLivres()");
            System.out.println(emprunt.getLivres());
            System.out.println("for (Livre livre : emprunt.getLivres())");
            for (Livre livre : emprunt.getLivres()) {
                System.out.println(livre);
            }

            //• Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné
            Client  client = em.find(Client.class, 1);
            System.out.println("client.getEmprunts()");
            System.out.println(client.getEmprunts());
            System.out.println("for (Emprunt emprunt2 : client.getEmprunts())");
            for (Emprunt emprunt2 : client.getEmprunts()) {
                System.out.println(emprunt2);
            }


            em.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection failed.");
        }
    }
}