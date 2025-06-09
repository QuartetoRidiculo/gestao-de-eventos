package models;

import java.util.ArrayList;

public class Evento {
    private int id;
    private String nome;
    private String data;
    private String local;
    private ArrayList<Organizador> organizadores;
    private ArrayList<Participante> participantes;
    private ArrayList<Colaborador> colaboradores;

    public int getId() {
        return id;
    }

    public Evento(int id, String nome, String data, String local, ArrayList<Organizador> organizadores) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.organizadores = organizadores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public ArrayList<Organizador> getOrganizadores() {
        return organizadores;
    }

    public void setOrganizadores(ArrayList<Organizador> organizadores) {
        this.organizadores = organizadores;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
}
