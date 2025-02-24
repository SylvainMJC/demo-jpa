package fr.epsi.b3devc1.sylvainmjc.bo;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="emprunt")
public class Emprunt {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date_debut;

    private String date_fin;

    private Integer delai;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToMany
    @JoinTable(name = "compo",
            joinColumns = @JoinColumn(name = "id_emp"),
            inverseJoinColumns = @JoinColumn(name = "id_liv"))
    private Set<Livre> livres;

    public Set<Livre> getLivres() {
        return livres;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Emprunt() {
    }

}
