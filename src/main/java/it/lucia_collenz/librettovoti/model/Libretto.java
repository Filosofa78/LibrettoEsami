package it.lucia_collenz.librettovoti.model;

import it.lucia_collenz.librettovoti.db.LibrettoDAO;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
    private List<Voto> esami  = null;
    public Libretto() {
    }

    public boolean add(Voto v){
        LibrettoDAO dao = new LibrettoDAO();
        boolean result = dao.creaVoto(v);
        return result;
    }

    public List<Voto> getVoti(){
        if (this.esami == null) {
            LibrettoDAO dao = new LibrettoDAO();
            this.esami =  dao.readAllVoto();
        }
        return this.esami;
    }

   /* public Libretto filtraPunti(int punti){
        Libretto result = new Libretto();
        for (Voto v: this.voti) {
            if (v.getPunti() == punti)
                result.add(v);
        }
        return result;
    }*/

    /*public Integer puntiEsame(String nome){
        for (Voto v: this.voti) {
            if (v.getNome().equals(nome))
                return v.getPunti();
        }
        //throw new IllegalArgumentException("Corso non trovato");
        return null;
    }*/

    /*public boolean isDuplicato(Voto v){
        for (Voto v1: this.voti) {
            if (v1.getNome().equals(v.getNome()) && v1.getPunti() == v.getPunti())
                return true;
        }
        return false;
    }*/

   /* public boolean isConflitto(Voto v){
        Integer punti = this.puntiEsame(v.getNome());
        if (punti != null && punti != v.getPunti())
            return true;
        else
            return false;
    }*/

    /*public String toString(){
        return this.voti.toString();
    }*/
}
