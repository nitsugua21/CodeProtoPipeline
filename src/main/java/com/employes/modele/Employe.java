/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employes.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jacques
 */
@Entity
@XmlRootElement
@Table(name = "EMPLOYES")
@NamedQueries(
        {
            @NamedQuery(name = "recupererTousLesEmployes", query = "SELECT e FROM Employe e")
            , @NamedQuery(name = "Employe.findById", query = "SELECT e FROM Employe e WHERE e.id = :id")
            , @NamedQuery(name = "Employe.findByNom", query = "SELECT e FROM Employe e WHERE e.nom = :nom")
            , @NamedQuery(name = "Employe.findByPrenom", query = "SELECT e FROM Employe e WHERE e.prenom = :prenom")
            , @NamedQuery(name = "Employe.findByTeldom", query = "SELECT e FROM Employe e WHERE e.teldom = :teldom")
            , @NamedQuery(name = "Employe.findByTelport", query = "SELECT e FROM Employe e WHERE e.telport = :telport")
            , @NamedQuery(name = "Employe.findByTelpro", query = "SELECT e FROM Employe e WHERE e.telpro = :telpro")
            , @NamedQuery(name = "Employe.findByAdresse", query = "SELECT e FROM Employe e WHERE e.adresse = :adresse")
            , @NamedQuery(name = "Employe.findByCodepostal", query = "SELECT e FROM Employe e WHERE e.codepostal = :codepostal")
            , @NamedQuery(name = "Employe.findByVille", query = "SELECT e FROM Employe e WHERE e.ville = :ville")
            , @NamedQuery(name = "Employe.findByEmail", query = "SELECT e FROM Employe e WHERE e.email = :email")
        }
)

public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nom;

    private String prenom;

    private String teldom;

    private String telport;

    private String telpro;

    private String adresse;

    private String codepostal;

    private String ville;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    
    private String email;

    public Employe() {
    }

    public Employe(Integer id) {
        this.id = id;
    }

    public Employe(Integer id, String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codepostal, String ville, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.teldom = teldom;
        this.telport = telport;
        this.telpro = telpro;
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTeldom() {
        return teldom;
    }

    public void setTeldom(String teldom) {
        this.teldom = teldom;
    }

    public String getTelport() {
        return telport;
    }

    public void setTelport(String telport) {
        this.telport = telport;
    }

    public String getTelpro() {
        return telpro;
    }

    public void setTelpro(String telpro) {
        this.telpro = telpro;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.controleur.Employe[ id=" + id + " ]";
    }

}
