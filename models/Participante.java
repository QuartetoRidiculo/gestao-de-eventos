package models;

public class Participante extends Pessoa {
    private String cpf;

    public Participante(String nome, int idade, String cpf) {
        super(nome, idade);
        this.cpf = cpf;

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}