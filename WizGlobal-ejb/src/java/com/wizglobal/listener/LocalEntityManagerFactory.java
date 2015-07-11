/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizglobal.listener;

import javax.persistence.EntityManager;  
import javax.persistence.EntityManagerFactory;  
import javax.persistence.Persistence;  
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;  
import javax.servlet.annotation.WebListener;  
@WebListener  
public class LocalEntityManagerFactory implements ServletContextListener{  
    private static EntityManagerFactory emf;  
    @Override  
    public void contextInitialized(ServletContextEvent event) {  
        emf = Persistence.createEntityManagerFactory("WizGlobal-ejbPU");  
    }  
    @Override  
    public void contextDestroyed(ServletContextEvent event) {  
        emf.close();  
    }  
    public static EntityManager createEntityManager() {  
        if (emf == null) {  
            throw new IllegalStateException("Context is not initialized yet.");  
        }  
        return emf.createEntityManager();  
    }  
} 