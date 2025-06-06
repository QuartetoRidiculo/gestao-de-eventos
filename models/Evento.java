package models;

public class Evento {
    private int id;
    private String nome;
    private int data;
    private String local;
    private Organizador[] organizadores;
    private Participante[] participantes;

    public int getId() {
        return id;
    }

    public Evento(int id, String nome, int data, String local, Organizador[] organizadores,
            Participante[] participantes) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.organizadores = organizadores;
        this.participantes = participantes;
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Organizador[] getOrganizadores() {
        return organizadores;
    }

    public void setOrganizadores(Organizador[] organizadores) {
        this.organizadores = organizadores;
    }

    public Participante[] getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Participante[] participantes) {
        this.participantes = participantes;
    }
}
