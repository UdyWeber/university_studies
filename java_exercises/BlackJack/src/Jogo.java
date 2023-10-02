public class Jogo {
    private Teclado teclado = new Teclado(); // Cria uma instância de Teclado para entrada de dados.
    private Jogador jogador1, jogador2; // Declara dois jogadores.
    private String resumoDaPartida; // Armazena o resumo da partida.
    private int rodada; // Controla o número da rodada.

    public Jogo() {
        String START_STRING = String.format(
            """
                %s
                %-42s%s
                %s
                """,
            "=".repeat(100),
            "",
            "JOGO 21",
            "=".repeat(100)
        );

        System.out.println(Cores.ROXO + START_STRING);

        imprimeRegras();

        System.out.printf(
            Cores.ROXO +
            """
                %s
                %-35s%s
                %s
                """,
            "=".repeat(100),
            "",
            "CRIANDO JOGADORES",
            "=".repeat(100)
        );

        System.out.println(Cores.VERDE + "Criando jogador 1...");
        this.jogador1 = criaJogador();

        System.out.println(Cores.VERDE + "Criando jogador 2...");
        this.jogador2 = criaJogador();

        this.rodada = 0;
        this.resumoDaPartida = "";
    }

    /**
     * Imprime as regras do Jogo 21 no terminal para serem visualidas pelos jogadores
     */
    private void imprimeRegras() {
        System.out.println(
            Cores.ROXO +
                """
                                                    Como funciona o jogo do 21?
                                                
                    - Neste jogo podem jogar apenas dois jogadores, cada um com dois dados: um branco e um
                    vermelho.
                                    
                    - Todos os jogadores começam com 0 pontos.
                                    
                    - O jogo é dividido em 3 rodadas.
                                    
                    - A cada rodada, cada jogador tem a opção de escolher se vai jogar o dado ou passar a vez.
                                    
                    - Se o jogador passar a vez, não joga os dados.
                                    
                    - Se o jogador escolher jogar os dados, joga primeiro o dado branco. O valor do dado branco soma-se
                    aos pontos que ele possui (por exemplo, se o jogador tinha 5 pontos e tirou 3 no dado branco, agora 
                    ele tem 8 pontos). Logo em seguida, o jogador joga o dado vermelho. Se o valor do dado vermelho for 
                    6, este valor é duplicado e somado aos pontos que ele já possui (por exemplo, se o jogador tinha 8 
                    pontos após jogar o dado branco, e tirou 6 no dado vermelho, ele agora tem 8 + (2 x 6) = 20 pontos).
                    Qualquer outro valor no dado vermelho é simplesmente somado aos pontos do jogador, assim como o 
                    dado branco.
                                    
                    - Depois que um jogador joga os dois dados, é a vez do outro escolher se joga ou se passa a vez, e
                    assim o jogo continua. 
                                    
                    - Uma rodada termina quando todos os jogadores fizerem sua ação (seja esta ação passar a vez ou 
                    jogar). 
                                                         Fim do Jogo
                                    
                    - O jogo termina após 3 rodadas.
                                    
                    - Após as 3 rodadas, o resultado do jogo é o seguinte:
                        ▪ o jogador que passar de 21 pontos perde (se todos passarem, o jogo empata).
                        ▪ se nenhum dos jogadores passar dos 21 pontos, o que mais se aproximar de 21 pontos ganha (caso
                         mais de um jogador faça o mesmo número de pontos, o jogo termina empatado)
                    """
        );
    }

    /**
     * Lê o nome do jogador pelo teclado, cria os dados do mesmo e retorna uma nova instancia de Jogador.
     *
     * @return Jogador
     */
    private Jogador criaJogador() {
        String nomeJogador;

        while (true) {
            nomeJogador = teclado.leString(Cores.AMARELO + "Digite o nome do jogador: ").trim();

            if (nomeJogador.isEmpty()) {
                System.out.println("\nAviso: Nome do jogador não pode estar em branco, tente novamente!\n");
                continue;
            }

            break;
        }

        System.out.println();

        Dado dadoVermelho = new Dado("vermelho");
        Dado dadoBranco = new Dado("branco");

        return new Jogador(nomeJogador, dadoVermelho, dadoBranco);
    }

    /**
     * Imprime na tela os resultados finais do jogo.
     */
    private void imprimeResultadoFinal() {
        resumoDaPartida += String.format(
            """
            %s
            %-45s%s
            %s
            %s: %d pontos
            %s: %d pontos
            %s
            """,
            "=".repeat(100),
            "",
            "FIM",
            "=".repeat(100),
            jogador1.getNome(),
            jogador1.getPontos(),
            jogador2.getNome(),
            jogador2.getPontos(),
            "=".repeat(100)
        );

        String nomeVencedor = getNomeVencendor();

        // Feito if para validar se está empatado e mudar o número de tabulações para manter um espaçamento correto
        if (nomeVencedor == null) {
            System.out.printf(
                Cores.ROXO +
                    """
                        %s
                        %-43sEMPATE
                        """,
                "=".repeat(100),
                ""
            );
        } else {
            System.out.printf(
                Cores.ROXO +
                    """
                        %s
                        %-40s%s
                        """,
                "=".repeat(100),
                "",
                nomeVencedor.toUpperCase() + " VENCEU O JOGO"
            );

        }


        System.out.println(Cores.ROXO + resumoDaPartida);
    }

    /**
     * Analisa os pontos ao fim da partida e retorna o nome do jogador vencedor em String ou null caso o jogo esteja empatado.
     *
     * @return String
     */
    private String getNomeVencendor() {
        int pontuacaoJogador1 = jogador1.getPontos();
        int pontuacaoJogador2 = jogador2.getPontos();

        if ((pontuacaoJogador1 == pontuacaoJogador2) || (pontuacaoJogador1 > 21 && pontuacaoJogador2 > 21)) {
            return null;
        } else if (pontuacaoJogador1 > 21) {
            return jogador2.getNome();
        } else if (pontuacaoJogador2 > 21) {
            return jogador1.getNome();
        } else {
            return pontuacaoJogador1 > pontuacaoJogador2 ? jogador1.getNome() : jogador2.getNome();
        }
    }

    /**
     * Função auxiliar para definir a jogada do jogador recebendo input pelo teclado.
     */
    private void jogaOuPassa(Jogador player) {
        String confirmacao;

        // Loop caso o input do player não atenda os cases do Switch
        while (true) {
            confirmacao = teclado.leString(
                Cores.AMARELO + player.getNome() + " digite P para passar a rodada ou J para jogar os dados [P/J]: "
            ).trim().toUpperCase();

            // Permite que o jogador escolha jogar ou passar a vez.
            switch (confirmacao) {
                case "P": {
                    System.out.println(Cores.VERDE + "\nPassando a vez\n");
                    return;
                }
                case "J": {
                    player.rodarDados();
                    return;
                }
                default:
                    System.out.println(Cores.VERMELHO + "\nOpção invalida!\n");
            }
        }
    }

    /**
     * Imprime na tela o número da rodada e os pontos atuais dos jogadores para ficar visualmente acessível no terminal.
     */
    private void imprimeResumoDaRodada() {
        // Imprime informações da rodada atual.
        String turnSummary = String.format(
            """
            %s
            %-42s%s
            %s
            %s: %d pontos
            %s: %d pontos
            """,
            "=".repeat(100),
            "",
            rodada + "ª RODADA",
            "=".repeat(100),
            jogador1.getNome(),
            jogador1.getPontos(),
            jogador2.getNome(),
            jogador2.getPontos()
        );
        System.out.print(Cores.ROXO + turnSummary);
        System.out.println("=".repeat(100));
        resumoDaPartida += turnSummary;
    }

    /**
     * Loop principal do jogo onde são chamadas todas as outras funções auxiliares da classe.
     */
    public void comecaJogo() {
        // Loop principal do jogo
        while (true) {
            // Loop das rodadas onde são feitas as jogadas dos jogadores
            while (rodada++ != 3) {
                imprimeResumoDaRodada();

                jogaOuPassa(jogador1);
                jogaOuPassa(jogador2);
            }

            imprimeResultadoFinal();

            // Loop de fim de jogo onde pergunta se os jogadores querem reiniciar ou apenas deixar o jogo
            // Caso o input não atenda os cases do switch o loop é reiniciado
            while (true) {
                String confirmacao = teclado.leString(
                    Cores.AMARELO + "Desejam jogar novamente? S para recomeçar N para finalizar [S/N]: "
                ).trim().toUpperCase();

                switch (confirmacao) {
                    case "S": {
                        System.out.println(Cores.VERDE + "\nReiniciando o jogo!\n");
                        break;
                    }
                    case "N": {
                        System.out.printf(
                            "\nObrigado por jogarem %s e %s, até a próxima!", jogador1.getNome(), jogador2.getNome()
                        );
                        return;
                    }
                    default:
                        System.out.println(Cores.VERMELHO + "\nOpção invalida!\n");
                        continue;
                }

                // Resetando as estatisticas do jogo para reiniciar a partida
                rodada = 0;
                jogador1.setPontos(0);
                jogador2.setPontos(0);
                resumoDaPartida = "";
                break;
            }
        }
    }
}
