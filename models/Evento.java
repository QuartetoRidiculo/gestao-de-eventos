package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Evento implements EventoInterface {
    private String nome;
    private String data;
    private String local;
    private ArrayList<Organizador> organizadores;
    private ArrayList<Participante> participantes;
    private ArrayList<Colaborador> colaboradores;

    public Evento(String nome, String data, String local, ArrayList<Organizador> organizadores) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.organizadores = organizadores;
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

    @Override
    public void gerarRelatorioParticipantes() {
        String relatorio = "Relatório de Participantes do Evento: " + nome + "\n";
        if (participantes == null || participantes.isEmpty()) {
            relatorio += "Nenhum participante cadastrado.";
            JOptionPane.showMessageDialog(null, relatorio);
            return;
        }

        String listaDeParticipantes = "";

        for (Participante p : participantes) {
            listaDeParticipantes += "- " + p.getNome() + "\n";
        }

        relatorio += listaDeParticipantes;

        JOptionPane.showMessageDialog(null, relatorio);
    }
}
