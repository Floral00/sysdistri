package fr.polytech.TPRest.Servlet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="generation")

public class Generation implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nom;
    @OneToMany
    @JoinColumn(name = "monstres", referencedColumnName = "id")
    private List<Monstres> monstres;

    public Generation() {
    }

    public Generation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
