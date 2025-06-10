package models;

public final class Organizador extends Pessoa {
    private String cargo;

    public Organizador(String nome, int idade, String cargo) {
        super(nome, idade);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
