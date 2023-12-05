enum Competicao {
    COPA_CPP(80, 20, 1, 15),
    RECOPA_JS(94, 45, 2, 20),
    LIGA_CAFE(110, 70, 3, 30);

    private int notaMin;
    private int riquezaGanha;
    private int ptsGanhos;
    private int riquezaPerdida;

    private Competicao(int notaMin, int riquezaGanha, int ptsGanhos, int riquezaPerdida) {
        this.notaMin = notaMin;
        this.riquezaGanha = riquezaGanha;
        this.ptsGanhos = ptsGanhos;
        this.riquezaPerdida = riquezaPerdida;
    }

    public int getNotaMin() {
        return this.notaMin;
    }

    public int getRiquezaGanha() {
        return this.riquezaGanha;
    }

    public int getPtsGanhos() {
        return this.ptsGanhos;
    }

    public int getRiquezaPerdida() {
        return this.riquezaPerdida;
    }
}
