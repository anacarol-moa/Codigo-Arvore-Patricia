package arvorepatricia;

public class No {
    private int difBit; //talvez seja redundante essa variavel, pode ser usada bitAcumulado.length()
    private String bitAcumulado;
    private Palavra palavra;
    private No pai;
    private No filho0E;
    private No filho1D;

    public No(int difBit, String bitAcumulado, Palavra palavra, No pai, No filho0E, No filho1D){
        this.difBit = difBit;
        this.bitAcumulado = bitAcumulado;
        this.palavra = palavra;
        this.pai = pai;
        this.filho0E = filho0E;
        this.filho1D = filho1D;
        }

    public int getDifBit() {
        return difBit;
    }

    public void setDifBit(int difBit) {
        this.difBit = difBit;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getFilho0E() {
        return filho0E;
    }

    public void setFilho0E(No filho0e) {
        filho0E = filho0e;
    }

    public No getFilho1D() {
        return filho1D;
    }

    public void setFilho1D(No filho1d) {
        filho1D = filho1d;
    }

    public Palavra getPalavra() {
        return palavra;
    }

    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }

    public String getBitAcumulado() {
        return bitAcumulado;
    }

    public void setBitAcumulado(String bitAcumulado) {
        this.bitAcumulado = bitAcumulado;
    }
}
