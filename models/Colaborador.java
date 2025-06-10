package models;

public class Colaborador extends Pessoa {
    private String funcao;

    public Colaborador(String nome, int idade, String funcao) {
        super(nome, idade);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}