package it.unifi.ing.swam.model;

import javax.persistence.*;

@Entity
public class User extends BaseEntity {

    private String nome;
    private String cognome;

    public User() {
    }

    public User(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

}
