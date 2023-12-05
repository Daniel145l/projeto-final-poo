import java.text.DecimalFormat;

public class Pivo extends Jogador {
    private double forca;

    //inicializa o atributo novo e passa para o construtor do pai os atributos
    public Pivo(Nivel nivel, String nome, int camisa, double passe, double finalizacao, double forca, Posicao posicao) {
        super(nivel, nome, camisa, passe, finalizacao, posicao);
        this.forca = forca;
    }

    //polimorfismo da nota desse jogador
    @Override
    public double getNota() {
        return (passe + 2 * finalizacao + 2 *this.forca) / 5;
    }

    //polimorfismo da toString
    @Override
    public String toString() {
        String saida = "\n" + this.posicao + ":\n";
        DecimalFormat df = new DecimalFormat("#.##");

        saida += "   · Nome: " + this.nome + "\n";
        saida += "   · Camisa: " + this.camisa + "\n";
        saida += "   · Passe: " + this.passe + "\n";
        saida += "   · Finalização: " + this.finalizacao + "\n";
        saida += "   · Forca: " + this.forca + "\n";
        saida += "   · Energia: " + this.energia + " / " + this.energiaMax + "\n";
        saida += "   · Posição: " + this.posicao + "\n";
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
