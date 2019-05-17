/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employes.modele;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jacques
 */
@Stateless
public class EmployeSB {

    @PersistenceContext(unitName = "EmployesServleTryStuffPU")
    private EntityManager em;

    public Collection<Employe> getEmployes() {
        
        // Exécution d'une requête équivalente à un select *  
        //Query q = em.createQuery("select e from Employe e");
        //return q.getResultList();

        Query findAllQuery = em.createNamedQuery("recupererTousLesEmployes");
        return findAllQuery.getResultList();

    }

    public void supprimerEmploye(String id) {

        int idEmp = Integer.parseInt(id);
        Query q = em.createQuery("delete from Employe e where e.id = :emplId");
        q.setParameter("emplId", idEmp);
        q.executeUpdate();

    }

    public void modifierEmploye(Employe empl) {

        Employe employe = (Employe) em.find(Employe.class, empl.getId());
        
        employe.setPrenom(empl.getPrenom());
        employe.setNom(empl.getNom());
        employe.setAdresse(empl.getAdresse());
        employe.setCodepostal(empl.getCodepostal());
        employe.setEmail(empl.getEmail());
        employe.setTeldom(empl.getTeldom());
        employe.setTelport(empl.getTelport());
        employe.setTelpro(empl.getTelpro());
        employe.setVille(empl.getVille());

        this.persist(employe);

    }

    public Employe getEmployeParId(int id) {
        
        Query findById = em.createQuery("SELECT e FROM Employe e WHERE e.id = :idEmp");
        findById.setParameter("idEmp", id);
        Employe empl = (Employe) findById.getSingleResult();
        return empl;
        
    }
    
    
        public Collection<Utilisateur> getIdentifiants() {
        
        // Exécution d'une requête équivalente à un select *  
        //Query q = em.createQuery("select e from Employe e");
        //return q.getResultList();

        Query findAllQuery = em.createNamedQuery("recupererLesIdentifiants");
        return findAllQuery.getResultList();

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
