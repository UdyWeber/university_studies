public class Game {
    private Teclado t = new Teclado();
    private Player p1, p2;
    private int rodada;

    public Game() {
        System.out.println("Criando jogador 1...");
        this.p1 = createPlayer();

        System.out.println("Criando jogador 2...");
        this.p2 = createPlayer();

        this.rodada = 0;
    }

    private Player createPlayer() {
        String playerName = t.leString("Digite o nome do jogador: ");

        Dice redDice = new Dice("vermelho");
        Dice whiteDice = new Dice("branco");

        return new Player(playerName, redDice, whiteDice);
    }

    private void deduceWinner() {
        int playerOneScore = p1.getScore();
        int playerTwoScore = p2.getScore();

        if ((playerOneScore == playerTwoScore) || (playerOneScore > 21 && playerTwoScore > 21)) {
            System.out.println("O jogo terminou empatado!");
        } else if (playerOneScore > 21) {
            System.out.println("O jogador 2 ganhou o jogo!");
        } else if (playerTwoScore > 21) {
            System.out.println("O jogador 1 ganhou o jogo!");
        } else {
            int playerOnefinalScore = 21 - playerOneScore;
            int playerTwofinalScore = 21 - playerOneScore;

            System.out.println(
                playerOnefinalScore > playerTwofinalScore ? "O jogador 1 ganhou o jogo!" : "O jogador 2 ganhou o jogo!"
            );
        }
    }

    private void playOrPass(Player player) {
        String confirmation;

        while (true) {
            confirmation = t.leString(player.getName() + " digite P para passar a rodada ou J para jogar os dados [P/J]: ")
                .trim()
                .toUpperCase();

            switch (confirmation) {
                case "P": {
                    return;
                }
                case "J": {
                    player.rollDices();
                    return;
                }
                default:
                    System.out.println("Opção invalida!");
            }
        }
    }

    public void comecaJogo() {
        System.out.println("Começando jogo!");

        while(rodada++ != 3) {
            System.out.println(rodada);

            playOrPass(p1);
            playOrPass(p2);
        }

        deduceWinner();
    }
}
