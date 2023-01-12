package it.lucia_collenz.librettovoti.db;

import it.lucia_collenz.librettovoti.model.Voto;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrettoDAO {

    public boolean creaVoto(Voto v){
        try {
            Connection conn = DBConnect.getConnection();

            String sql = "INSERT INTO voti (nome, punti, data) VALUES(?,?,?)";
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, v.getNome());
            ps.setInt(2, v.getPunti());
            ps.setString(3, v.getData().toString());

            int res = ps.executeUpdate();
            ps.close();
            conn.close();

            return (res == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Voto> readAllVoto(){
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM voti";
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet res = ps.executeQuery();

            List<Voto> result = new ArrayList<>();
            while (res.next()){
                String nome = res.getString("nome");
                int punti = res.getInt("punti");
                LocalDate data = LocalDate.parse(res.getString("data"));
                result.add(new Voto(nome, punti, data));
            }
            ps.close();
            conn.close();

            return result;
        } catch (SQLException | NullPointerException e) {
            System.out.print(e);
            e.printStackTrace();
            return null;
        }
    }


}
