package com.htcursos.resom.Model;

import java.io.Serializable;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

/**
 * Created by Murilo Ribeiro on 10/06/2017.
 */
@Table("cliente")
public class Client extends Model implements Serializable{
    @AutoIncrement
    @Key
    @Column("id")
    private Long id;
    @Column("nome")
    private String name;
    @Column("image")
    private int image;
    @Column("email")
    private String email;
    @Column("CPF")
    private String CPF;
    @Column("CEL")
    private String celular;


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return CPF;
    }

    public String getCelular() {
        return celular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (image != client.image) return false;
        if (!id.equals(client.id)) return false;
        if (!name.equals(client.name)) return false;
        if (!email.equals(client.email)) return false;
        if (!CPF.equals(client.CPF)) return false;
        return celular.equals(client.celular);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + image;
        result = 31 * result + email.hashCode();
        result = 31 * result + CPF.hashCode();
        result = 31 * result + celular.hashCode();
        return result;
    }



}
