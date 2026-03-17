package menu;

import equipe.Equipe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    //criar um map para mapear os objetos
    Map<String, Equipe> equipes = new HashMap<>();

    int opcao;

    do {
        System.out.println("======MENU======");
        System.out.println("1 - Criar equipe");
        System.out.println("2 - adicionar consultor");
        System.out.println("3 - Lista equipe");
        System.out.println("0 - Sair");
        System.out.println("Escolha: ");

        opcao = scan.nextInt();
        scan.nextLine();

    }while (opcao != 0);
}
