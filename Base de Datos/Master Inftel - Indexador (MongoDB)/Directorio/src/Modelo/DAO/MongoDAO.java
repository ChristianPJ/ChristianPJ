/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import directorio.Conexion;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Samu
 */
public class MongoDAO {

    private static MongoClient mongoClient = null;

    public static void insertarFoto(BasicDBObject foto) {

        try {
            Conexion c = new Conexion();
            mongoClient = c.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        DBCollection coll = db.getCollection("fotitos");
        coll.insert(foto);
    }

    @SuppressWarnings("empty-statement")
    public static List<String> AllCamara() {

        List<BasicDBObject> marca = new ArrayList<>();
        List<String> marca1 = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");

        DBCollection docs = db.getCollection("fotitos");

        BasicDBObject query = new BasicDBObject();

        BasicDBObject fields = new BasicDBObject("marca", true).append("_id", false);

        try (DBCursor cursor = docs.find(query, fields)) {
            while (cursor.hasNext()) {
                marca.add((BasicDBObject) cursor.next());

            }

            for (BasicDBObject objeto : marca) {
                if (objeto.getString("marca") != null && !marca1.contains(objeto.getString("marca"))) {
                    marca1.add(objeto.getString("marca"));

                };
            }
        }

        return (marca1);
    }

    public static List<String> AllModelo(String camara) {

        List<BasicDBObject> modelo1 = new ArrayList<>();
        List<String> modelo = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        DBCollection docs = db.getCollection("fotitos");

        try (DBCursor cur = docs.find(new BasicDBObject("marca", camara),
                new BasicDBObject("modelo", 1))) {
            while (cur.hasNext()) {
                modelo1.add((BasicDBObject) cur.next());

            }
            for (BasicDBObject objeto : modelo1) {
                if (objeto.getString("modelo") != null && !modelo.contains(objeto.getString("modelo"))) {

                    modelo.add(objeto.getString("modelo"));

                }
            }
        }

        return (modelo);
    }

    public static List<BasicDBObject> AllFotosShop() {
        List<BasicDBObject> FotosShop = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        DBCollection docs = db.getCollection("fotitos");

        try (DBCursor cur = docs.find(new BasicDBObject("Photoshop", true))) {
            while (cur.hasNext()) {
                FotosShop.add((BasicDBObject) cur.next());

            }
        }

        return (FotosShop);
    }

    public static List<BasicDBObject> AllNoFotosShop() {
        List<BasicDBObject> FotosShop = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        DBCollection docs = db.getCollection("fotitos");

        try (DBCursor cur = docs.find(new BasicDBObject("Photoshop", false))) {
            while (cur.hasNext()) {
                FotosShop.add((BasicDBObject) cur.next());
            }
        }

        return (FotosShop);
    }

    public static List<BasicDBObject> AllFotosFlash() {
        List<BasicDBObject> FotosFlash = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        DBCollection docs = db.getCollection("fotitos");

        try (DBCursor cur = docs.find(new BasicDBObject("Flash", true))) {
            while (cur.hasNext()) {
                FotosFlash.add((BasicDBObject) cur.next());

            }
        }

        return (FotosFlash);
    }

    public static List<BasicDBObject> AllFotosNoFlash() {
        List<BasicDBObject> FotosNoFlash = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        DBCollection docs = db.getCollection("fotitos");

        try (DBCursor cur = docs.find(new BasicDBObject("Flash", false))) {
            while (cur.hasNext()) {
                FotosNoFlash.add((BasicDBObject) cur.next());

            }
        }

        return (FotosNoFlash);
    }

    public static List<BasicDBObject> AllFotosFecha(Date inicio, Date fin) {
        List<BasicDBObject> FotosFecha = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        DBCollection docs = db.getCollection("fotitos");
        BasicDBObject gtQuery = new BasicDBObject("fecha", new BasicDBObject("$gt", inicio).append("$lte", fin));

        try (DBCursor cursor = docs.find(gtQuery)) {
            while (cursor.hasNext()) {
                FotosFecha.add((BasicDBObject) cursor.next());
            }
        }

        return (FotosFecha);
    }

    public static List<BasicDBObject> AllFotosDimensiones(int alto, int ancho) {
        List<BasicDBObject> FotosPeso = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        DBCollection docs = db.getCollection("fotitos");
        BasicDBObject gtQuery = new BasicDBObject("alto", new BasicDBObject("$lte", alto)).append("ancho", new BasicDBObject("$lte", ancho));

        try ( // gtQuery.put("alto", new BasicDBObject("$gte", inicio));
                //gtQuery.put("alto", new BasicDBObject("$lte", fin));
                DBCursor cursor = docs.find(gtQuery)) {
            while (cursor.hasNext()) {
                FotosPeso.add((BasicDBObject) cursor.next());
            }
        }

        return (FotosPeso);
    }

    public static List<BasicDBObject> AllFotosCamaraModelo(String camara, String modelo) {
        List<BasicDBObject> FotosPeso = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        DBCollection docs = db.getCollection("fotitos");
        //new BasicDBObject("marca", camara),new BasicDBObject("modelo", 1));
        BasicDBObject gtQuery = new BasicDBObject("marca", camara).append("modelo", modelo);

       // gtQuery.put("alto", new BasicDBObject("$gte", inicio));
        //gtQuery.put("alto", new BasicDBObject("$lte", fin));
        DBCursor cursor = docs.find(gtQuery);

        while (cursor.hasNext()) {
            FotosPeso.add((BasicDBObject) cursor.next());
        }

        return (FotosPeso);
    }
    
    public static void borrarMongo(){
        
        try {
            Conexion con = new Conexion();
            mongoClient = con.conectarMongo();
        } catch (UnknownHostException ex) {
            System.out.println("Imposible realizar la conexión: " + ex.getMessage());
        }
        DB db = mongoClient.getDB("test");
        
        DBCollection docs = db.getCollection("fotitos");
        DBCursor cur2 = docs.find();
        while (cur2.hasNext())
            docs.remove(cur2.next());
    }
}
