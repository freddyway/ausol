/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redsys.mci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.redsys.llaa.model.h2.Ip0040;
import com.redsys.llaa.model.h2.Ip0090;

/**
 *
 * @author S3316AM
 */
public class MciSeEmi {
    private static final Logger log = Logger.getLogger(MciSeEmi.class.getName());
    private static final String IP0090_FILE = "C:/temp/IBM/RBIP90Q0.TXT";
    private static final String MCISEEMI_NEW = "MCISEEMI_ADD.TXT";
    private static final String[] TARJETA =
    {               
    "5115000000000001",
    "5117244400000001",
    "5131623900000001",
    "5155487200000001",
    "5167680100000001",
    "5168822300000001",
    "5168822400000001",
    "5180602400000001",
    "5210786600000001",
    "5275120000000001",
    "5301280100000001",
    "5352190100000001",
    "5372286500000001",
    "5373170000000001",
    "5374690100000001",
    "5440000000000001",
    "5542654000000001",
    "5558040200000001",
    };
    private EntityManagerFactory emf;
    public MciSeEmi() {
        
        PrintWriter out = null;
        
        try {
            log.info("MCISEEMI expedientes....");
            
            emf = Persistence.createEntityManagerFactory("llaaH2");
            
            out = new PrintWriter(new BufferedWriter(new FileWriter(MCISEEMI_NEW)));
            
//            loadIP0090();
            
            for (int i = 0; i < TARJETA.length; i++) {
                String pan = TARJETA[i];
                buscarRango(pan,out);
            }   emf.close();
            
            log.info("fin.");
            
        } catch (IOException ex) {
            Logger.getLogger(MciSeEmi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MciSeEmi();
    }

    
    private void loadIP0090() {

        log.info("loadIP0090....");
        
        String reg = "";

        try {

            try (BufferedReader reader = new BufferedReader(new FileReader(new File(IP0090_FILE)))) {
                while ((reg = reader.readLine()) != null) {
                    createIP0090(reg);                    
                }
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, "ERROR GRAVE !!!!", e);
        }

    }

    private void createIP0090(String reg) {

        Ip0090 ip0090 = new Ip0090();

        ip0090.setDatefile(reg.substring(0, 10));
        ip0090.setCodact(reg.substring(10, 11));
        ip0090.setTabla(reg.substring(11, 19));
        ip0090.setRanmen(reg.substring(19, 38));
        ip0090.setBuseartyprico(new Short(reg.substring(38,40)));
        ip0090.setBusearty(reg.substring(40,41));
        ip0090.setBuseidcode(reg.substring(41,47));
        ip0090.setAcbrprio(new Short(reg.substring(47,49)));
        ip0090.setAcepbrand(reg.substring(49,52));
        ip0090.setRanmay(reg.substring(52, 71));
        ip0090.setLifecycle(reg.substring(71, 72));

//        log.info(ip0040.toString());
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(ip0090);
        em.getTransaction().commit();

        em.close();
    }
    
    private String buscarRango(String TARJETA, PrintWriter out) {
        String rango = ""      ;
        
        log.log(Level.INFO, "TARJETA:{0}", TARJETA);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Ip0090.findByRango");
        query.setParameter("ranmen", TARJETA);
        query.setParameter("ranmay", TARJETA);

        List<Ip0090> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
//            Ip0040 ip0040 = list.get(0);
            for (Ip0090 ip0090 : list) {
//            list.forEach(ip0090 -> {
                log.log(Level.INFO, "{0}", ip0090.toString());

                StringBuilder builder = new StringBuilder();
                builder.append(ip0090.getRanmen());
                builder.append(ip0090.getRanmay());
                builder.append(String.format("%02d",ip0090.getAcbrprio()));
                builder.append(ip0090.getAcepbrand());
                builder.append(String.format("%02d",ip0090.getBuseartyprico()));
                builder.append(ip0090.getBuseidcode());
                builder.append(ip0090.getBusearty());
                builder.append(ip0090.getLifecycle());
                
                out.println(builder.toString());
                
                log.log(Level.INFO, "{0}", builder.toString());
            }
//            });
        } else {
            log.log(Level.WARNING, "NO EXISTE!!! {0}", TARJETA);
        }

        em.getTransaction().commit();
        em.close();
        
        return rango;
    }


    
}
