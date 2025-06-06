package models;
public interface Pessoa {
    public int getId();

    public void setId(int id);

    public String getNome();

    public void setNome(String nome);

    public int getIdade();

    public void setIdade(int idade);

    public Evento[] getEventos();

    public void setEventos(Evento[] eventos);
}