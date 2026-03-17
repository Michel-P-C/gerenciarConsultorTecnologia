package equipe;

import consultorAbstract.Consultor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipe {
    //atributos
    private String nome;

    //Lista
    public List<Consultor> consultor = new ArrayList<>();

    //construtor
    public Equipe(String nome){
        this.nome = nome;
    }

    //metodo de adicionar
    public void adicionar(Consultor c){
        consultor.add(c);
    }

    //metodo de lista o resultado ordenados
    public  List<Consultor> ordenados(){
        List<Consultor> lista = new ArrayList<>(consultor);
        Collections.sort(lista);
        return lista;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
