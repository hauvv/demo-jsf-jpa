/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vivas.demo.primefaces.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vn.vivas.demo.primefaces.bean.Users;

/**
 *
 * @author HAU
 */
public class DataBaseUtil {

    EntityManagerFactory emf;
    EntityManager em;

    public DataBaseUtil() {
        emf = Persistence.createEntityManagerFactory("demo-primefacePU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public boolean login(String username, String pass) {
        boolean isLogin = false;
        try {
            Users u = em.createNamedQuery("Users.login", Users.class).setParameter("username", username).setParameter("password", pass).getSingleResult();
            System.out.println("vn.vivas.demo.primefaces.repository.DataBaseUtil.login()"+ u.getUserName());
            if (null != u) {
                isLogin = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isLogin;
    }
}
