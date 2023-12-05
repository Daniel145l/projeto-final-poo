enum Nivel {
    INICIANTE(50, 50, "iniciante"),
    INTERMEDIARIO(100, 65, "intermediario"),
    PROFISSIONAL(200, 100, "profissional");

    private double valor;
    private double notaMax;
    private String label;

    private Nivel(double valor, double notaMax, String label) {
        this.valor = valor;
        this.notaMax = notaMax;
        this.label = label;
    }

    public double getNotaMax() {
        return notaMax;
    }

    public double getValor() {
        return valor;
    }

    public String getLabel() {
        return this.label;
    }
}
