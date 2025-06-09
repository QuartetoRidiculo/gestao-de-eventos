package models;

import java.util.ArrayList;

public interface Pessoa {
    public int getId();

    public void setId(int id);

    public String getNome();

    public void setNome(String nome);

    public int getIdade();

    public void setIdade(int idade);

    public ArrayList<Evento> getEventos();

    public void setEventos(ArrayList<Evento> eventos);
}