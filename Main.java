// package projeto_poo;

// import java.io.FileWriter;
// import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Time time = null;

        time = GerenciadorArquivo.carregarTime("meu_time.ser");

        if(time == null) {
            time = new Time();
            time.nomePresidente();
            System.out.println("Criando novo time!");
        }else {
            System.out.println("Carregando time existente!");
        }
        
        System.out.println("\nEntão, " + time.getPresidente() + " será que você é tão bom quanto dizem? Nos mostre seu potencial administrando o time!\n");

        System.out.println("Time carregado:\n" + time);

        while(true) {

            GerenciadorArquivo.salvarTime(time, "meu_time.ser");

            time.ganhouPts();

            System.out.println(
                "\nO que quer fazer agora?\n(0) - Mostrar informações do time\n(1) - Comprar goleiro\n(2) - Comprar Fixo\n(3) - Comprar Ala\n(4) - Comprar Pivo\n(5) - Escolher capitao\n(6) - Jogar partida\n(7) - Adicionar titular\n(8) - Adcicionar reserva\n(9) - Fazer substituição\n(10) - Vender jogador\n(11) - Mandar jogador para fisioterapia\n(12) - Treinar jogador\n(-1) - Finalizar gerenciamento\n");

            var line = scanner.nextLine();
            var comando = line.split(" ");

            try {

                switch(comando[0]) {

                    case "0":
                        System.out.println(time);
                        break;
                    
                    case "1":
                    // String nome, int camisa, double passe, double finalizacao, double reflexo, Posicao posicao, Nivel nivel

                        System.out.println("O seu time tem " + time.getRiqueza() + " de riqueza!");
                        Nivel nivelGol = time.nivelMostrarPerguntas();
                        String nomeGol = time.nomeMostrarPerguntas();
                        int numeroGol = time.numeroMostrarPerguntas();
                        double passeGol = time.passeMostrarPerguntas();
                        System.out.println("· O nivel parcial do jogador e: " + (passeGol + 0 + 0) / 4 + "/" + nivelGol.getNotaMax());
                        double finalizacaoGol = time.finalizacaoMostrarPerguntas();
                        System.out.println("· O nivel parcial do jogador e: " + (passeGol + finalizacaoGol + 0) / 4 + "/" + nivelGol.getNotaMax());
                        

                        System.out.println("\nQual e a qualidade dos reflexos dele?");
                        var reflexoAux = scanner.nextLine();
                        double reflexo = Double.parseDouble(reflexoAux);
                        System.out.println("· O nivel parcial do jogador e: " + (passeGol + finalizacaoGol + 2 * reflexo) / 4 + "/" + nivelGol.getNotaMax());

                        time.comprarJogador(new Goleiro(nivelGol, nomeGol.toUpperCase(), numeroGol, passeGol, finalizacaoGol, reflexo, Posicao.GOLEIRO));
                        break;

                    case "2":

                        System.out.println("O seu time tem " + time.getRiqueza() + " de riqueza!");
                        Nivel nivelFix = time.nivelMostrarPerguntas();
                        String nomeFix = time.nomeMostrarPerguntas();
                        int numeroFix = time.numeroMostrarPerguntas();
                        double passeFix = time.passeMostrarPerguntas();
                        System.out.println("· O nivel parcial do jogador e: " + (passeFix + 0 + 2 * 0) / 4 + "/" + nivelFix.getNotaMax());
                        double finalizacaoFix = time.finalizacaoMostrarPerguntas();
                        System.out.println("· O nivel parcial do jogador e: " + (passeFix + finalizacaoFix + 2 * 0) / 4 + "/" + nivelFix.getNotaMax());

                        System.out.println("\nQual e a qualidade da marcacao dele?");
                        var marcacaoAux = scanner.nextLine();
                        double marcacao = Double.parseDouble(marcacaoAux);
                        System.out.println("· O nivel parcial do jogador e: " + (passeFix + finalizacaoFix + 2 * marcacao) / 4 + "/" + nivelFix.getNotaMax());

                        time.comprarJogador(new Fixo(nivelFix, nomeFix.toUpperCase(), numeroFix, passeFix, finalizacaoFix, marcacao, Posicao.FIXO));
                        break;

                    case "3":

                        System.out.println("O seu time tem " + time.getRiqueza() + " de riqueza!");
                        Nivel nivelAla = time.nivelMostrarPerguntas();
                        String nomeAla = time.nomeMostrarPerguntas();
                        int numeroAla = time.numeroMostrarPerguntas();
                        double passeAla = time.passeMostrarPerguntas();
                        System.out.println("· O nivel parcial do jogador e: " + (passeAla + 0 + 2 * 0) / 4 + "/" + nivelAla.getNotaMax());
                        double finalizacaoAla = time.finalizacaoMostrarPerguntas();
                        System.out.println("· O nivel parcial do jogador e: " + (passeAla + finalizacaoAla + 2 * 0) / 4 + "/" + nivelAla.getNotaMax());

                        System.out.println("\nQual e a qualidade da condução dele?");
                        var conducaoAux = scanner.nextLine();
                        double conducao = Double.parseDouble(conducaoAux);
                        System.out.println("· O nivel parcial do jogador e: " + (passeAla + finalizacaoAla + 2 * conducao) / 4 + "/" + nivelAla.getNotaMax());

                        time.comprarJogador(new Ala(nivelAla, nomeAla.toUpperCase(), numeroAla, passeAla, finalizacaoAla, conducao, Posicao.ALA));
                        break;

                    case "4":

                        System.out.println("O seu time tem " + time.getRiqueza() + " de riqueza!");
                        Nivel nivelPiv = time.nivelMostrarPerguntas();
                        String nomePiv = time.nomeMostrarPerguntas();
                        int numeroPiv = time.numeroMostrarPerguntas();
                        double passePiv = time.passeMostrarPerguntas();
                        System.out.println("· O nivel parcial do jogador e: " + (passePiv + 2 * 0 + 2 * 0) / 5 + "/" + nivelPiv.getNotaMax());
                        double finalizacaoPiv = time.finalizacaoMostrarPerguntas();
                        System.out.println("· O nivel parcial do jogador e: " + (passePiv + 2 * finalizacaoPiv + 2 * 0) / 5 + "/" + nivelPiv.getNotaMax());

                        System.out.println("\nQual e a força dele?");
                        var forcaAux = scanner.nextLine();
                        double forca = Double.parseDouble(forcaAux);
                        System.out.println("· O nivel parcial do jogador e: " + (passePiv + 2 * finalizacaoPiv + 2 * forca) / 5 + "/" + nivelPiv.getNotaMax());

                        time.comprarJogador(new Pivo(nivelPiv, nomePiv.toUpperCase(), numeroPiv, passePiv, finalizacaoPiv, forca, Posicao.PIVO));
                        break;
                    
                    case "5":
                        System.out.println("Qual o nome do jogador que sera capitao?");
                        String nomeCap = scanner.nextLine();
                        time.tornarCap(nomeCap.toUpperCase());
                        System.out.println(nomeCap.toUpperCase() + " tornou-se capitao do time!");
                        break;

                    case "6":
                        System.out.println("Em qual liga quer jogar?\n(1) - Copa CPP\n(2) - RecopaJS\n(3) - Liga Cafe");
                        String cmpt = scanner.nextLine();
                        switch (cmpt) {
                            case "1":
                                time.jogar(Competicao.COPA_CPP);
                                break;
                            case "2":
                                time.jogar(Competicao.RECOPA_JS);
                                break;
                            case "3":
                                time.jogar(Competicao.LIGA_CAFE);
                            default:
                                break;
                        }
                        break;

                    case "7":
                        System.out.println("Qual o nome do jogador que sera titular?");
                        var nomeTit = scanner.nextLine();
                        time.addTitular(nomeTit.toUpperCase());
                        System.out.println(nomeTit.toUpperCase() + " adicioando a titular como sucesso!");
                        break;

                    case "8":
                        System.out.println("Qual o nome do jogador que sera reserva?");
                        var nomeRes = scanner.nextLine();
                        time.addReserva(nomeRes.toUpperCase());
                        System.out.println(nomeRes.toUpperCase() + " adicioando a reserva como sucesso!");
                        break;

                    case "9":
                        System.out.println("Qual o nome do jogador que saira?");
                        var nomeSai = scanner.nextLine();
                        System.out.println("Qual o nome do jogador que entrara?");
                        var nomeEntra = scanner.nextLine();
                        time.substituir(nomeEntra.toUpperCase(), nomeSai.toUpperCase());
                        System.out.println("Saiu " + nomeSai.toUpperCase() + " para entrar " + nomeEntra.toUpperCase() + " no time");
                        break;

                    case "10":
                        System.out.println("Qual é o nome do jogador que será vendido?");
                        String nomeVende = scanner.nextLine();
                        time.venderJogador(nomeVende.toUpperCase());
                        break;

                    case "11":
                        System.out.println("Qual o nome jogador que fará fisioterapia?");
                        String nomeFisio = scanner.nextLine();
                        time.fisioterapiaJogador(nomeFisio.toUpperCase());
                        break;

                    case "12":
                        System.out.println("Qual e o nome do jogador que sera treinado?");
                        String nomeTreino = scanner.nextLine();
                        time.treinarJogador(nomeTreino.toUpperCase());
                        break;

                    case "-1":
                        return;

                    default:
                        System.out.println("Comando invalido");
                        break;
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    private static Scanner scanner =  new Scanner(System.in);
}