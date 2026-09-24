package arvorepatricia;

public class Palavra {
   
    private String palavra;
    private String bits;
    private String posicoes;

    public Palavra(String palavra, int linha, int coluna) {
        this.palavra = palavra;
        this.bits = "";
        this.posicoes = "(" + linha + ", " + coluna + ")";

        converterParaBits();
    }

    private void converterParaBits() {

        while (palavra.length() < 16) {
            palavra = palavra + " ";
        }

        for (int i = 0; i < 17; i++) {
            
            //traduzir char para bits:
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

    public void adicionarPosicao(int linha, int coluna) {
        posicoes = posicoes + " (" + linha + ", " + coluna + ")";
    }
}