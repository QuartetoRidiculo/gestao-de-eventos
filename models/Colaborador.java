package models;

import java.util.ArrayList;

public class Colaborador implements Pessoa {
    private int id;
    private String nome;
    private int idade;
    private String funcao;
    private ArrayList<Evento> eventos;


    public Colaborador(int id, String nome, int idade, String funcao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;
    }

    public int getId() {
        return id;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

}
