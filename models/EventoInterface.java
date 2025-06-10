package models;

import java.util.ArrayList;

public interface EventoInterface {
    String getNome();

    void setNome(String nome);

    String getData();

    void setData(String data);

    String getLocal();

    void setLocal(String local);

    ArrayList<Organizador> getOrganizadores();

    void setOrganizadores(ArrayList<Organizador> organizadores);

    ArrayList<Participante> getParticipantes();

    void setParticipantes(ArrayList<Participante> participantes);

    ArrayList<Colaborador> getColaboradores();

    void setColaboradores(ArrayList<Colaborador> colaboradores);

    void gerarRelatorioParticipantes();
}
