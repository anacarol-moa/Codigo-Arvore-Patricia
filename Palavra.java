package arvorepatricia;

public class Palavra {
   
    private String palavra;
    private String bits;
    private int linha; // aumentei
    private int coluna; // aumentei
    private String posicoes;

    public Palavra(String palavra, int linha, int coluna) {
        this.palavra = palavra;
        this.bits = "";
        this.linha = linha;
        this.coluna = coluna;
        this.posicoes = "(" + linha + ", " + coluna + ")";

        converterParaBits();
    }

    public Palavra (String bits){
        this.bits = bits;
    }

    private void converterParaBits() {

        while (palavra.length() < 16) {
            palavra = palavra + " ";
        }

        for (int i = 0; i < 16; i++) {
            
            //traduzir de char para bits:
            String binario = Integer.toBinaryString(palavra.charAt(i));
            // System.out.println(binario);

            //completar com zeros até ter 8 bits:
            while (binario.length() < 8) {
                binario = "0" + binario;
            }

            bits = bits + binario;
        }
    }

    public String getPalavra() {
        return palavra;
    }

    public String getBits() {
        return bits;
    }

    public String getPosicoes() {
        return posicoes;
    }

    public int getLinha(){
        return linha;
    }

    public int getColuna(){
        return coluna;
    }

    public void adicionarPosicao(int linha, int coluna) {
        posicoes = posicoes + " (" + linha + ", " + coluna + ")";
    }
}