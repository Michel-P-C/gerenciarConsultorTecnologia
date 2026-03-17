package Especializacao;

import consultorAbstract.Consultor;

public class ConsultorFrontend extends Consultor {

    //construtor
    public ConsultorFrontend(String nome, String nivel) {
        super(nome, nivel, "Frontend");
    }
}
