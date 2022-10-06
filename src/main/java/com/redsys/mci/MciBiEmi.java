/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redsys.mci;

import java.io.BufferedWriter;
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

/**
 *
 * @author S3316AM
 */
public class MciBiEmi {
    private static final Logger log = Logger.getLogger(MciBiEmi.class.getName());
    private static final String MCIBIEMI_NEW = "MCIBIEMI_ADD.TXT";
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
    public MciBiEmi() {
        
        PrintWriter out = null;
        
        try {
            log.info("MCIBIEMI expedientes....");
            
            emf = Persistence.createEntityManagerFactory("llaaH2");
            
            out = new PrintWriter(new BufferedWriter(new FileWriter(MCIBIEMI_NEW)));
            
            for (int i = 0; i < TARJETA.length; i++) {
                String pan = TARJETA[i];
                buscarRango(pan,out);
            }   emf.close();
            
            log.info("fin.");
            
        } catch (IOException ex) {
            Logger.getLogger(MciBiEmi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MciBiEmi();
    }

    private String buscarRango(String TARJETA, PrintWriter out) {
        String rango = ""      ;
        
        log.log(Level.INFO, "TARJETA:{0}", TARJETA);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Ip0040.findByRango");
        query.setParameter("ranmen", TARJETA);
        query.setParameter("ranmay", TARJETA);

        List<Ip0040> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
//            Ip0040 ip0040 = list.get(0);
            for (Ip0040 ip0040 : list) {
                log.log(Level.INFO, "{0}", ip0040.toString());

                StringBuilder builder = new StringBuilder();
                builder.append(ip0040.getRanmen());
                builder.append(ip0040.getRanmay());
                builder.append(String.format("%02d",ip0040.getAcbrprio()));
                builder.append(ip0040.getIdprod());
                builder.append(ip0040.getAcepbrand());
                builder.append(String.format("%011d",ip0040.getMbrid()));
                builder.append(ip0040.getTipoprod());
                builder.append(String.format("%07d",ip0040.getEndpoint()));
                builder.append(ip0040.getPaisalfa());
                builder.append(String.format("%03d",ip0040.getPaisnum()));
                builder.append(ip0040.getRegion());
                builder.append(String.format("%03d",ip0040.getMoneda()));
                builder.append(ip0040.getExponente());
                builder.append("A N");

                rango = builder.toString();       
                out.println(rango);
                
                log.log(Level.INFO, "{0}", rango);                
            }
        } else {
            log.log(Level.WARNING, "NO EXISTE!!! {0}", TARJETA);
        }

        em.getTransaction().commit();
        em.close();
        
        return rango;
    }
    
}
