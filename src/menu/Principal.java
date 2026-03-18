package menu;

import Especializacao.ConsultorBackend;
import Especializacao.ConsultorDados;
import Especializacao.ConsultorFrontend;
import consultorAbstract.Consultor;
import equipe.Equipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public void menu(){
        Scanner scan = new Scanner(System.in);
        //criar um map para mapear os objetos
        Map<String, Equipe> equipes = new HashMap<>();

        int opcao;

        do {
            System.out.println("========MENU========");
            System.out.println("1 - Criar equipe");
            System.out.println("2 - adicionar consultor");
            System.out.println("3 - Procura equipe");
            System.out.println("4 - Lista todas as equipes");
            System.out.println("5 - Excluir equipe");
            System.out.println("0 - Sair");
            System.out.println("Escolha: ");

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao){
                case 1:
                    //adicionar uma equipe
                    System.out.println("Nome da equipe: ");
                    var nomeEquipe = scan.nextLine();

                    Equipe novaEquipe = new Equipe(nomeEquipe);
                    equipes.put(nomeEquipe, novaEquipe);


                    System.out.println("Deseja adiciona um consultor agora? (S/N)");
                    var resp = scan.nextLine();

                    if (resp.equalsIgnoreCase("s")){
                        System.out.println("Nome do consultor");
                        var nome = scan.nextLine();

                        System.out.println("Especialidade (Backend / Frontend/ Dados): ");
                        var esp = scan.nextLine();

                        System.out.println("Nível (Júnior / Pleno / Sênior ): ");
                        var nivel = scan.nextLine();

                        Consultor c = null;

                        if (esp.equalsIgnoreCase("Backend")){
                            c = new ConsultorBackend(nome, nivel);
                        } else if (esp.equalsIgnoreCase("Frontend")) {
                            c = new ConsultorFrontend(nome, nivel);
                        } else if (esp.equalsIgnoreCase("Dados")) {
                            c = new ConsultorDados(nome, nivel);
                        }
                        if (c != null){
                            novaEquipe.adicionar(c);
                            System.out.println("Consultor adicionado à equipe.");
                        }else {
                            System.out.println("Especialidade invalida");
                        }
                    }
                    break;
                case 2:
                    if (equipes.isEmpty()){
                        System.out.println("Nenhuma equipe cadastrada. crie uma equipe primeiro.");
                        break;
                    }

                    System.out.println("Equipes disponível: ");
                    for (var nomeEp : equipes.keySet()){
                        System.out.println("_ " + nomeEp);
                    }

                    System.out.println("Digite o nome da equipe: ");
                    var equipeNome = scan.nextLine();

                    Equipe equipe = equipes.get(equipeNome);

                    if (equipe == null){
                        System.out.println("Equipe não encontrada.");
                        break;
                    }

                    System.out.println("Nome do consultor: ");
                    var nome = scan.nextLine();

                    System.out.println("ESPECIALIDADE (Backend / Frontend / Dados ");
                    var esp = scan.nextLine();

                    System.out.println("NIVEL (Júnior / Pleno / Sênior)");
                    var nivel = scan.nextLine();

                    Consultor c = null;

                    if (esp.equalsIgnoreCase("Backend")) {
                        c = new ConsultorBackend(nome, nivel);
                    } else if (esp.equalsIgnoreCase("Frontend")) {
                        c = new ConsultorFrontend(nome, nivel);
                    } else if (esp.equalsIgnoreCase("Dados")) {
                        c = new ConsultorDados(nome, nivel);
                    }

                    if (c != null){
                        equipe.adicionar(c);
                    System.out.println("Consultor adicionado!");
                    } else{
                        System.out.println("Especialidade invalida.");
                    }
                    break;

                case 3:
                    System.out.println("Nome da Equipe: ");
                    var busca = scan.nextLine();

                    Equipe equi = equipes.get(busca);

                    if (equi == null){
                        System.out.println("Equipe não encontrada");
                    }else {
                        List<Consultor> lista = equi.ordenados();

                        for (Consultor con: lista){
                            System.out.println(con.getNome() + " " + con.getEspecialidade() + " " + con.getNivel());
                        }
                    }
                    break;
                case 4:
                    if (equipes.isEmpty()){
                        System.out.println("Nenhuma equipe cadastrada.");
                    }else{
                        System.out.println("Equipe cadastradas: ");

                        for (Equipe eq : equipes.values()){
                            System.out.println("Equipe: " + " " + eq.getNome());

                            List<Consultor> lista = eq.ordenados();
                            if (lista.isEmpty()){
                                System.out.println("Sem consultores");
                            }else {
                                for (Consultor con : lista){
                                    System.out.println(con.getNome() + " " + con.getEspecialidade() + " " + con.getNivel());
                                }
                            }
                        }
                        System.out.println(); // quebra de linha extra
                    }
                    break;
                case 5:
                    System.out.println("nome da equipe excluir: ");
                    var excluir = scan.nextLine();

                    if (equipes.containsKey(excluir)){
                        equipes.remove(excluir);
                        System.out.println("Equipe removida com sucesso!");
                    }else {
                        System.out.println("Equipe não encontrada");
                    }
                    break;

            }
        }while (opcao != 0);
        scan.close();
    }

}
