package it.lucia_collenz.librettovoti.model;

import java.time.LocalDate;
import java.util.Objects;

public class Voto {
    private String nome;
    private int punti;
    private LocalDate data;

    public Voto(String nome, int punti, LocalDate data) {
        this.nome = nome;
        this.punti = punti;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    @Override
    public String toString() {
        return nome + ": " + punti + " " + data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return nome.equals(voto.nome) && punti == voto.punti;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, punti);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
