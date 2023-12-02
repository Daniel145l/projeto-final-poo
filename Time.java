// package projeto_poo;

import java.util.*;
import java.io.Serializable;
import java.text.DecimalFormat;
// import projeto_poo.Titular;

class Time implements Serializable {
    //tem que ter: lista de relacionados, lista de titulares, lista de reservas, capitao e todas as posicoes
    //tem que fazer: treinar, jogar
    private Map<String, Jogador> time;
    private Map<String, Jogador> titulares;
    private Map<String, Jogador> reservas;
    private double riqueza;
    private int pontos;
    private Random numeroChanceGanhar;
    private String presidente;
    private String nome;

    private static final long serialVersionUID = 1L;

    public Time() {
        this.time = new LinkedHashMap<String, Jogador>();
        this.titulares = new LinkedHashMap<String, Jogador>();
        this.reservas = new LinkedHashMap<String, Jogador>();

        this.riqueza = 400;
    }

    public void nomePresidente() {
        System.out.println("\n============================ BEM-VINDO ============================\nParabéns, você foi contratado para ser o presidente-tecnico do novo time de futsal da UFC! Poderia nos dizer como quer ser chamado...");
        System.out.print("Diga seu nome: ");
        String presidente = scanner.nextLine();
        this.presidente = presidente;
        System.out.println("Certo, " + this.presidente + " e qual e o nome do time?");
        String nome = scanner.nextLine();
        this.nome = nome;
    }

    public void comprarJogador(Jogador jogador) throws Exception{
        if(this.riqueza >= jogador.nivel.getValor()) {
            if(this.time.size() < 12) {
                if(jogador.getNota() <= jogador.nivel.getNotaMax()){
                    this.riqueza -= jogador.nivel.getValor();
                    this.time.put(jogador.getNome(), jogador);
                    System.out.println("Parabens pela contratacao!");
                }else {throw new ExceptionMessage("A nota media do jogador e maior que a permitida para o nivel dele!"); }
            }else { throw new ExceptionMessage("Seu time ja esta cheio!"); }
        }else { throw new ExceptionMessage("Voce nao tem dinheiro suficiente!"); }
    }

    public void venderJogador(String nome) throws Exception{
        if(this.time.size() > 0) {
            if(this.time.containsKey(nome)){
                for(Jogador j : this.time.values()) {
                    if(j.getNome().equals(nome)) {
                        double venda = 0;
                        this.time.remove(nome);
                        if(this.titulares.containsKey(nome)){
                            this.titulares.remove(nome);
                        }else if(this.reservas.containsKey(nome)){
                            this.reservas.remove(nome);
                        }
                        if(j.getNota() > j.nivel.getNotaMax()) {
                            venda = j.nivel.getValor() + 10;
                        }else {
                            venda = j.nivel.getValor() - 10;
                        }
                        this.riqueza += venda;
                        System.out.println("O jogador " + nome + " foi vendido com sucesso por " + venda + "reais!");
                    }
                }
            }else {throw new ExceptionMessage("Esse jogador não está no seu time!");}
        }else { throw new ExceptionMessage("Você não tem jogadores para vender!"); }
    }

    public void addTitular(String nome) throws Exception{
        if(this.time.containsKey(nome)) {
            if(this.titulares.size() < 5) {
                if(!this.time.get(nome).getLesao()){
                    if(this.reservas.containsKey(nome)) {
                        Jogador resTit = this.reservas.remove(nome);
                        this.titulares.put(nome, resTit);
                    }
                    Jogador titular = this.time.get(nome);
                    this.titulares.put(nome, titular);
                }else { throw new ExceptionMessage("Este jogador esta lesionado e nao pode jogar!"); };
            } else { throw new ExceptionMessage("Seu time titular já está completo!"); }
        } else { throw new ExceptionMessage("Nao ha ninguem no time com esse nome!"); }
    }

    public void addReserva(String nome) throws Exception{
        if(this.time.containsKey(nome)) {
            if(this.titulares.containsKey(nome)){
                Jogador titRes = this.titulares.remove(nome);
                this.reservas.put(nome, titRes);
            }
            Jogador reserva = this.time.get(nome);
            this.reservas.put(nome, reserva);
        }else { throw new ExceptionMessage("Nao ha ninguem no time com esse nome!"); }
    }

    public void substituir(String reserva, String titular) throws Exception{
        if(this.reservas.containsKey(reserva)){
            if(this.titulares.containsKey(titular)){
                Jogador titularAux = this.reservas.remove(reserva);
                Jogador reservaAux = this.titulares.remove(titular);

                this.reservas.put(titular, reservaAux);
                this.titulares.put(reserva, titularAux);
            } else {throw new ExceptionMessage("Nao ha titular com esse nome!");}
        }else { throw new ExceptionMessage("Nao ha reserva com esse nome!"); }
    }

    public void tornarCap(String nome) throws Exception {
        if(this.titulares.containsKey(nome)) {
            for(Jogador j : this.titulares.values()) {
                if(j.getCapitao()) {
                    j.setPasse(-0.5);
                    j.setFinalizacao(-0.5);
                    j.setCap(false);
                }
            }

            for(Jogador j : this.titulares.values()) {
                if(j.getNome().equals(nome)) {
                    j.setPasse(0.5);
                    j.setFinalizacao(0.5);
                    j.setCap(true);
                }
            }
        } else { throw new ExceptionMessage("Este jogador nao esta na lista de titulares!"); }
    }

    public void treinarJogador(String nome) throws Exception {
        if(this.time.containsKey(nome)) {
            Jogador jogador = this.time.get(nome);
            if(this.riqueza >= 20) {

                jogador.subirNivel();
                    
                jogador.setPasse(1);
                jogador.setFinalizacao(1);
                jogador.setEnergia(-0.5);
                setRiqueza(-30);

                jogador.subirNivel();

            } else {throw new ExceptionMessage("Treinar o jogador custa 20 de riqueza. O seu time nao tem esse dinheiro");}
        } else {throw new ExceptionMessage("Este jogador não faz parte do time"); }
    }

    public boolean temNome(String nome) {
        for(Jogador j : this.time.values()) {
            if(j.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public boolean temCamisa(int camisa) {
        for(Jogador j : this.time.values()) {
            if(j.getCamisa() == camisa) {
                return true;
            }
        }
        return false;
    }

    public double notaTime() {
        double notaGeral = 0;
        for(Jogador j : this.titulares.values()) {
            notaGeral += j.getNota();
        }
        double mediaTime = notaGeral / 5;
        return mediaTime;
    }

    public boolean timeLesao() {
        boolean timeRuim = false;
        for(Jogador j : this.titulares.values()) {
            if(j.getLesao()) {
                timeRuim = true;
            }
        }
        return timeRuim;
    }

    public double calcularChance(Competicao competicao) {
        double chanceDeGanhar;

        chanceDeGanhar = (this.notaTime() / competicao.getNotaMin());

        return chanceDeGanhar;
    }

    public void jogar(Competicao jogo) throws Exception{
        if(!timeLesao()) {
            boolean temCapitao = false;
            if(this.titulares.size() == 5) {
                for(Jogador j : this.titulares.values()) {
                    if(j.getCapitao()) {
                        temCapitao = true;
                    }
                }
                if(!temCapitao) {throw new ExceptionMessage("Seu time precisa de um capitao!"); }
                ArrayList<String> nomesList = new ArrayList<>(this.titulares.keySet());
                Random perdeEnergia = new Random();
                String jogEnergia = nomesList.get(perdeEnergia.nextInt(nomesList.size()));
                this.titulares.get(jogEnergia).energia -= 1;

                double chanceGanhar = calcularChance(jogo);
                this.numeroChanceGanhar = new Random();
                double numeroSorteio = numeroChanceGanhar.nextDouble();
                if(chanceGanhar >= numeroSorteio){
                    System.out.println("PARABENS SEU TIME GANHOU!\nSeu time recebeu " + jogo.getRiquezaGanha() + " reais e somou " + jogo.getPtsGanhos() + " pontos!\n");
                    this.riqueza += jogo.getRiquezaGanha();
                    this.pontos += jogo.getPtsGanhos();
                }else {
                    System.out.println("QUE PENA, SEU TIME PERDEU!\nSeu time perdeu " + jogo.getRiquezaPerdida() + " reis e nao somou pontos!\n");
                    this.riqueza -= jogo.getRiquezaPerdida();
                }
            } else { throw new ExceptionMessage("Seu time titular nao esta completo"); }
        } else { throw new ExceptionMessage("Ha um jogador lesioanado no time"); }
    }

    public void setRiqueza(double valor) {
        this.riqueza += valor;
    }

    public void fisioterapiaJogador(String nome) throws Exception {
        if(this.time.containsKey(nome)) {
            double energiaGanha = 10 - this.time.get(nome).getEnergia();
            this.time.get(nome).energia += energiaGanha;
            setRiqueza(-50);
            if(this.time.get(nome).getLesao()){
                this.time.get(nome).lesionado = false;
            }
            System.out.println(nome + " recebeu +"+ energiaGanha +" de energia!");
        }else {throw new ExceptionMessage("Nome do jogador não encontrado no time");}
    }

    public Nivel nivelMostrarPerguntas() {
        System.out.println("Qual e o nivel de experiencia dele?");
        System.out.println("(1) - Iniciante: custo = 50\n(2) - Intermediario: custo = 100\n(3) - Profissional: custo = 200");
        var nivelAux = scanner.nextLine();
        Nivel nivel;

        switch (nivelAux) {
            case "1":
                nivel = Nivel.INICIANTE;
                break;
        
            case "2":
                nivel = Nivel.INTERMEDIARIO;
                break;

            default:
                System.out.println("Nivel invalido! O jogador recebeu o nivel iniciante");
                nivel = Nivel.INICIANTE;
                break;
        }

        return nivel;
    }

    public String nomeMostrarPerguntas() {
        System.out.println("\nQual e o nome do jogador?");
        var nomeAux = scanner.nextLine();
        String nome = nomeAux;

        if(temNome(nome)) {
            throw new ExceptionMessage("Ja existe um jogador com esse nome");
        }
        return nome;
    }

    public int numeroMostrarPerguntas() {
        System.out.println("\nQual e o numero da camisa dele?");
        var numeroAux = scanner.nextLine();
        int numero = Integer.parseInt(numeroAux);

        if(temCamisa(numero)) {
            throw new ExceptionMessage("Ja existe um jogador com esse número na camisa!");
        }
        return numero;
    }

    public double passeMostrarPerguntas() {
        System.out.println("\nQual e a qualidade do passe dele?");
        var passeAux = scanner.nextLine();
        double passe = Double.parseDouble(passeAux);

        return passe;
    }

    public double finalizacaoMostrarPerguntas() {
        System.out.println("\nQual e a qualidade da finalizacao dele?");
        var finalizacaoAux = scanner.nextLine();
        double finalizacao = Double.parseDouble(finalizacaoAux);

        return finalizacao;
    }

    public String getPresidente() {
        return this.presidente;
    }

    public double getRiqueza() {
        return this.riqueza;
    }

    public String getNome() {
        return this.nome;
    }

    public void ganhouPts() {
        if(this.pontos >= 50) {
            System.out.println("O seu time ganhou o campeonato! Parabens! Como recompensa voce ganhou +100 de riqueza para a nova fase do campeonato!\nBoa sorte!");
            this.pontos = 0;
            this.riqueza += 100;
        }
    }

    public String toString() {
        String saida = "============== TIME ==============\n";
        if(this.time.isEmpty()) {
            saida += "\nSeu time ainda não tem jogadores!\n";
        }else {
            for(Jogador j : this.time.values()) {
                saida += j.toString() + "\n";
            }
        }
        
        saida += "\n============== TITULARES ==============\n";
        if(this.time.isEmpty()) {
            saida += "\nSeu time ainda não tem jogadores!\n";
        }else {
            for(Jogador j : this.titulares.values()) {
                saida += j.toString() + "\n";
            }
        }

        saida += "\n============== RESERVAS ==============\n";
        if(this.time.isEmpty()) {
            saida += "\nSeu time ainda não tem jogadores!\n";
        }else {
            for(Jogador j : this.reservas.values()) {
                saida += j.toString() + "\n";
            }
        }

        saida += "\n============== INFORMAÇÕES DO TIME ==============\n";
        DecimalFormat df = new DecimalFormat("#.##");
        saida += "* NOME: " + this.nome + "\n* RIQUEZA: " + this.riqueza + "\n" + "* NIVEL DO TIME: " + df.format(this.notaTime()) + "\n" + "* PONTOS DO TIME:" + this.pontos;

        return saida;
    }

    private static Scanner scanner =  new Scanner(System.in);

}