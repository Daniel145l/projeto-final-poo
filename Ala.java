// package projeto_poo;

// import java.io.Serializable;
import java.text.DecimalFormat;

public class Ala extends Jogador {
    private double conducao;

    public Ala(Nivel nivel, String nome, int camisa, double passe, double finalizacao, double conducao, Posicao posicao) {
        super(nivel, nome, camisa, passe, finalizacao, posicao);
        this.conducao = conducao;
    }

    // @Override
    // public void treinarJogador(Jogador jogador) throws Exception{
    //     // System.out.println("O custo do treino do jogador e 30");
    //     super.treinarJogador(jogador);
    //     this.conducao += 1;
    // }

    @Override
    public double getNota() {
        return (passe + finalizacao + 2 * this.conducao) / 4;
    }

    @Override
    public String toString() {
        String saida = "\n" + this.posicao + ":\n";
        DecimalFormat df = new DecimalFormat("#.##");

        saida += "   · Nome: " + this.nome + "\n";
        saida += "   · Camisa: " + this.camisa + "\n";
        saida += "   · Passe: " + this.passe + "\n";
        saida += "   · Finalização: " + this.finalizacao + "\n";
        saida += "   · Conducao: " + this.conducao + "\n";
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
        saida += "\n   · Nível: " + df.format(getNota());
        
        return saida;
    }
}
