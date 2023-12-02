// package projeto_poo;

import java.io.Serializable;
import java.text.DecimalFormat;
// import java.util.*;

abstract class Jogador implements Serializable {
    // o que um jogador deve ter?
    // nome, camisa, qld. passe, qld. finalizacao, energia, energia Max, posicao.
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

    // private static final long serialVersionUID = -9156170607499356796;

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

    public Jogador() {
        
    }

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

    public void setEnergia(double valor) throws Exception {
        if(this.energia + valor >= 0 && this.energia + valor <= 10) {
            this.energia += valor;
        }else if(valor > 0) {
            this.energia = 10;
        }else {
            this.energia = 0;
        }
    }

    public void setPasse(double valor) throws Exception {
        this.passe += valor;
        subirNivel();
    }

    public void setFinalizacao(double valor) throws Exception {
        this.finalizacao += valor;
        subirNivel();
    }

    public void serEnergia(double valor) throws Exception {
        if(this.energia + valor < this.energiaMax) {
            this.energia += valor;
        }else { throw new ExceptionMessage("Valor da energia atingiu o maximo!"); }
    }

    public void setCap(boolean valor) {
        this.capitao = valor;
    }

    public double getEnergia() {
        return this.energia;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCamisa() {
        return this.camisa;
    }

    public Posicao getPosicao() {
        return this.posicao;
    }

    public boolean getLesao() {
        if(energia <= 0) {
            this.lesionado = true;
        }
        return this.lesionado;
    }

    public double getNota() {
        return (this.passe + this.finalizacao) / 2;
    }

    public Nivel getNivel() {
        return this.nivel;
    }
    
    public boolean getCapitao() {
        return this.capitao;
    }

    public String toString() {
        String saida = "\n" + this.posicao + ":\n";
        DecimalFormat df = new DecimalFormat("#.##");

        saida += "   · Nome: " + this.nome + "\n";
        saida += "   · Camisa: " + this.camisa + "\n";
        saida += "   · Passe: " + this.passe + "\n";
        saida += "   · Finalização: " + this.finalizacao + "\n";
        saida += "   · Energia: " + this.energia + " / " + this.energiaMax + "\n";
        saida += "   · Posição: " + this.posicao + "\n";
        // saida += "   · Energia: " + this.energia + "\n";
        saida += "   · Saúde: ";
        if(this.energia >= 8) {
            saida += "otima";
        }else if(this.energia >= 6) {
            saida += "boa";
        }else if(this.energia >=4) {
            saida += "ruim";
        }else if(this.energia >= 1) {
            saida += "pessima";
        }else {
            saida += "lesionado";
        }
        saida += "\n   · Nivel: " + df.format(getNota());
        saida += "\n   · Capitao: " + (this.capitao ? "Sim" : "Nao");
        
        return saida;
    }
}