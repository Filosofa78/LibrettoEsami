package it.lucia_collenz.librettovoti.db;

import java.sql.*;

public class prova_db {
    public static void main(String[] args) {
        //String url = "jdbc:sqlite:\\C:\\Users\\kamau\\Desktop\\SQLiteStudio\\Miei db\\libretto.db";
        String url = "jdbc:sqlite:libretto.db";

        try {
            Connection conn = DriverManager.getConnection(url);

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM voti";
            ResultSet res = st.executeQuery(sql);

            while (res.next()){
                String nome = res.getString("nome");
                int voto = res.getInt("punti");
                System.out.println(nome + " " + voto);
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
