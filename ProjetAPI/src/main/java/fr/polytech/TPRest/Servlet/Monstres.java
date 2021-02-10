package fr.polytech.TPRest.Servlet;

import javax.persistence.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "monstres")

public class Monstres implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
	String nom;
    int lvl;
    int atk;
    int def;
    @OneToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "generation", referencedColumnName = "id")
    private Generation generation;

    public Monstres(){}

    public Monstres(int id, String nom, int lvl, int atk, int def) {
        this.id = id;
        this.nom = nom;
        this.lvl = lvl;
        this.atk = atk;
        this.def = def;
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

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getAtk() {
    	return atk;
    }
    
    public void setAtk(int atk) {
        this.atk = atk;
    }
    
    public int getDef() { return def; }
    
    public void setDef(int def) {
        this.def = def;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    @Override
    public String toString() {
        return "montres yu gi oh [nom=" + nom + ", lvl=" + lvl + ", atk =" + atk + ", def =" + def + ']';
    }


}

