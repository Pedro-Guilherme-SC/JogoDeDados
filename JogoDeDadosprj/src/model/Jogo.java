package model;
import java.util.Scanner;

public class Jogo {
    private int qtdJogadores;
    private int resultado;
    private Dado dado1;
    private Dado dado2;
    private Jogador[] jogadores;

    Scanner escrever = new Scanner(System.in);

    public void inserirJogadores() {
        do {
            System.out.print("Informe a quantidade de jogadores (1 a 11): ");
            qtdJogadores = escrever.nextInt();
        } while (qtdJogadores < 1 || qtdJogadores > 11);

        jogadores = new Jogador[qtdJogadores];
        for (int i = 0; i < qtdJogadores; i++) {
            jogadores[i] = new Jogador();
            System.out.print("Nome do jogador " + (i + 1) + ": ");
            jogadores[i].setNome(escrever.next());
        }
    }

    public void inserirApostas() {
        for (int i = 0; i < qtdJogadores; i++) {
            int aposta;
            do {
                System.out.print("Jogador " + jogadores[i].getNome() + ", insira um valor para apostar (2 a 12): ");
                aposta = escrever.nextInt();
            } while (aposta < 2 || aposta > 12);
            jogadores[i].setValorAposta(aposta);
        }
    }

    public void lancarDados() {
        dado1 = new Dado();
        dado2 = new Dado();
        dado1.setValorFace();
        dado2.setValorFace();
    }

    public void mostrarResultado() {
        resultado = dado1.getValorFace() + dado2.getValorFace();
        System.out.println("\nResultado dos dados:");
        System.out.println("Dado 1: " + dado1.getValorFace());
        System.out.println("Dado 2: " + dado2.getValorFace());
        System.out.println("Soma: " + resultado);
    }

    public void mostrarVencedor() {
        boolean houveVencedor = false;
        for (int i = 0; i < qtdJogadores; i++) {
            if (jogadores[i].getValorAposta() == resultado) {
                System.out.println(jogadores[i].getNome() + " venceu!");
                houveVencedor = true;
            }
        }
        if (!houveVencedor) {
            System.out.println("Máquina venceu!");
        }
    }
}
