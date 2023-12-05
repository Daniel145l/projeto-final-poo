import java.io.Serializable;

abstract class Jogador implements Serializable {
    protected Nivel nivel;
    protected String nome;
    protected int camisa;
    protected double passe;
    protected double finalizacao;
    protected double energia;
    protected double energiaMax;
    protected Posicao posicao;
    protected boolean lesionado;
    protected boolean capitao;

    //inicializa os atributos
    public Jogador(Nivel nivel, String nome, int camisa, double passe, double finalizacao, Posicao posicao) {
        this.nivel = nivel;
        this.nome = nome;
        this.camisa =  camisa;
        this.passe = passe;
        this.finalizacao = finalizacao;
        this.posicao = posicao;
        this.energiaMax = 10;
        this.energia = this.energiaMax;
        this.lesionado = false;
        this.capitao = false;
    }

    public Jogador() {}

    //verifica se pode subir de nivel
    public void subirNivel() {
        if(this.nivel == Nivel.PROFISSIONAL && getNota() == Nivel.PROFISSIONAL.getNotaMax()) {
            throw new ExceptionMessage("O seu jogador já atingiu o máximo de suas capacidades");
        }

        if(getNota() > this.nivel.getNotaMax()){
            switch (this.nivel.getLabel()) {
                case "iniciante":
                    System.out.println("Parabéns, seu jogador subiu do nivel " + this.nivel + " para o nivel Intermediario!");
                    this.nivel = Nivel.INTERMEDIARIO;
                    break;
                case "intermediario":
                    System.out.println("Parabéns, seu jogador subiu do nivel " + this.nivel + " para o nivel Profissional!");
                    this.nivel = Nivel.PROFISSIONAL;
                    break;
            }
        }
    }

    //set de energia
    public void setEnergia(double valor) throws Exception {
        if(this.energia + valor >= 0 && this.energia + valor <= 10) {
            this.energia += valor;
        }else if(valor > 0) {
            this.energia = 10;
        }else {
            this.energia = 0;
        }
    }

    //set de passe
    public void setPasse(double valor) throws Exception {
        this.passe += valor;
        subirNivel();
    }

    //set de finalização
    public void setFinalizacao(double valor) throws Exception {
        this.finalizacao += valor;
        subirNivel();
    }

    //set de capitao
    public void setCap(boolean valor) {
        this.capitao = valor;
    }

    //get de energia
    public double getEnergia() {
        return this.energia;
    }

    //get de nome
    public String getNome() {
        return this.nome;
    }

    //get de numero da camisa
    public int getCamisa() {
        return this.camisa;
    }

    //get do enum posicao
    public Posicao getPosicao() {
        return this.posicao;
    }

    //get situação da lesao
    public boolean getLesao() {
        if(energia <= 0) {
            this.lesionado = true;
        }
        return this.lesionado;
    }

    //get nota dos filhos
    abstract public double getNota();

    //get do enum nivel
    public Nivel getNivel() {
        return this.nivel;
    }
    
    //get do capitão
    public boolean getCapitao() {
        return this.capitao;
    }
}