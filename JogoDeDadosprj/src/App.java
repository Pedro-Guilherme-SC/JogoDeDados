import model.Jogo;

public class App {
    public static void main(String[] args) {
        Jogo run = new Jogo();
        run.inserirJogadores();
        run.inserirApostas();
        run.lancarDados();
        run.mostrarResultado();
        run.mostrarVencedor();
    }
}