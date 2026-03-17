package Especializacao;

import consultorAbstract.Consultor;

public class ConsultorBackend extends Consultor {
    //construtor
    public ConsultorBackend(String nome, String nivel) {
        super(nome, nivel, "Backend");
    }
}
