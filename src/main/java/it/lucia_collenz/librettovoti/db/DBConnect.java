package it.lucia_collenz.librettovoti.db;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnect {
    static private HikariDataSource ds = null;
    static private String url = "jdbc:sqlite:libretto.db";

    public static Connection getConnection(){

        if (ds == null){
            ds = new HikariDataSource();
            ds.setJdbcUrl(url);
        }
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

/*
1.  Creare una classe per ogni tabella db che rappresenta una entità, eccetto per le tabelle di relazione n:m
2.  Il nome della classe deve essere uguale a quello della tabella al singolare
3.  La classe deve avere una proprietà privata per ogni colonna nella tabella, mantenendo gli stessi nomi,
    ignorando le colonne che rappresentano chiavi esterne
4.  Il costruttore principale deve contenere tutti i campi
5.  Aggiungere getters e setters per ogni proprietà
6.  Aggiungere i medoti hashCode e Equals usando lo stesso set di campi che compongono la chiave primaria
 */
