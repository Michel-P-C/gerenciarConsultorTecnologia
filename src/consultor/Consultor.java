package consultor;

public abstract class Consultor implements Comparable<Consultor> {

    //atributos
    private String nome;
    private String nivel;
    private String especialidade;

    //construtor
    public Consultor (String nome, String nivel, String especialidade) {
        this.nome = nome;
        this.nivel = nivel;
        this.especialidade = especialidade;
    }
    //get e set
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNivel(){
        return nivel;
    }

    public void setNivel(String nivel){
        this.nivel = nivel;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    //compareto
    @Override
    public int compareTo(Consultor outro){
        return this.nome.compareTo(outro.nome);
    }
}

