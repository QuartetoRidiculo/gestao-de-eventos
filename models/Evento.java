package models;

import javax.swing.*;
import java.util.ArrayList;

public class Evento {
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
        this.participantes = new ArrayList<>();
        this.colaboradores = new ArrayList<>();
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

    public void gerarRelatorioParticipantes() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Participantes do Evento: ").append(nome).append("\n\n");

        if (participantes == null || participantes.isEmpty()) {
            relatorio.append("Nenhum participante cadastrado.");
        } else {
            for (Participante p : participantes) {
                relatorio.append("- ").append(p.getNome()).append("\n");
            }
        }

        // Criar JTextArea para melhor formatação do texto
        JTextArea textArea = new JTextArea(relatorio.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        // Adicionar JTextArea em JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); // tamanho da janela

        // Mostrar no JOptionPane com o scroll
        JOptionPane.showMessageDialog(null, scrollPane, "Relatório de Participantes", JOptionPane.INFORMATION_MESSAGE);
    }

    public void adicionarParticipante(Participante participante) {
        participantes.add(participante);
    }
}