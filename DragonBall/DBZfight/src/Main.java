import Races.*;
import Races.Personagems.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lista de personagens disponíveis
        List<PersonagemBase> personagens = new ArrayList<>();
        personagens.add(new Goku      ("Goku", 5000, 150, 250, 100));
        personagens.add(new Vegeta    ("Vegeta", 5000, 150, 250, 100));
        personagens.add(new Android_17("Android 17", 3000, 200, 100));
        personagens.add(new Android_18("Android 18", 4500, 180, 120));
        personagens.add(new Android_16("Android 16", 4000, 140, 180));
        personagens.add(new Picolo    ("Picolo", 6000, 90, 200,250));
        personagens.add(new Broly     ("Broly", 10000, 1000, 1000,500));
        personagens.add(new Cell      ("Perfect Cell",7000,170,200, 150));

        Scanner scanner = new Scanner(System.in);

        // Exibir lista de personagens
        System.out.println("Selecione os personagens para a batalha digitando seus nomes:");
        for (PersonagemBase p : personagens) {
            System.out.println("- " + p.nome);
        }

        // Selecionar o primeiro personagem
        PersonagemBase per1 = null;
        while (per1 == null) {
            System.out.print("Digite o nome do primeiro personagem: ");
            String nome1 = scanner.nextLine();
            per1 = buscarPersonagemPorNome(personagens, nome1);
        }

        // Selecionar o segundo personagem
        PersonagemBase per2 = null;
        while (per2 == null || per2 == per1) {
            System.out.print("Digite o nome do segundo personagem: ");
            String nome2 = scanner.nextLine();
            per2 = buscarPersonagemPorNome(personagens, nome2);
            if (per2 == per1) {
                System.out.println("Você não pode selecionar o mesmo personagem duas vezes! Escolha outro.");
            }
        }

        // Iniciar a batalha
        System.out.println("\nA batalha começa entre " + per1.nome + " e " + per2.nome + "\n\n");

        while (per1.vida > 0 && per2.vida > 0) {
            if (per1.velocidade > per2.velocidade) {
                per1.usarHabilidadeAleatoria(per1, per2);
                if (per2.vida > 0) {
                    per2.usarHabilidadeAleatoria(per2, per1);
                }
            } else {
                per2.usarHabilidadeAleatoria(per2, per1);
                if (per1.vida > 0) {
                    per1.usarHabilidadeAleatoria(per1, per2);
                }
            }

            // Exibir status dos personagens após cada rodada
            System.out.println("\n\n" + per1.nome + " tem " + per1.vida + " HP");
            System.out.println(per2.nome + " tem " + per2.vida + " HP\n\n");
        }

        // Declarar o vencedor
        if (per1.vida > 0) {
            System.out.println(per1.nome + " venceu a batalha!");
        } else {
            System.out.println(per2.nome + " venceu a batalha!");
        }
    }

    // Método auxiliar para buscar personagem pelo nome
    private static PersonagemBase buscarPersonagemPorNome(List<PersonagemBase> personagens, String nome) {
        try {
            // Verificar se o nome está vazio ou é um número
            if (nome == null || nome.trim().isEmpty()) {
                throw new NullException("O nome do personagem não pode ser vazio!!!");
            }
            if(nome.matches("\\d+")) {
                throw new NumException("O nome do personagem não pode conter apenas números!!!");
            }

            // Buscar o personagem pelo nome
            for (PersonagemBase p : personagens) {
                if (p.nome.equalsIgnoreCase(nome)) {
                    return p;
                }
            }

            // Se não encontrou, lança exceção
            throw new DontExistException("Personagem com nome '" + nome + "' não encontrado.");
        } catch (NullException | NumException | DontExistException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
        System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
        return null;
    }

}