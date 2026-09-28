package arvorepatricia;


public class ArvorePatricia {

    private class NoInterno extends No {
        int bit;
        No esquerda;
        No direita;

        public NoInterno(int bit, No esquerda, No direita) { // se o bit for 17, nesse ponto vamos olhar o 17ºbit para ver se vai pra esquerda ou direita
            this.bit = bit;
            this.esquerda = esquerda;
            this.direita = direita;
        }
    }

    private class NoExterno extends No {
        Palavra palavra;

        public NoExterno(Palavra palavra) {
            this.palavra = palavra;
        }
    }

    private No raiz;

    public void Avorepatricia(){
        raiz = null;
    }

    private int primeiroBitDiferente(Palavra p1, Palavra p2) {

        String bits1 = p1.getBits();
        String bits2 = p2.getBits();

        for (int i = 0; i < bits1.length(); i++) {
            if (bits1.charAt(i) != bits2.charAt(i)) {  // testa se os bits são diferentes
                return i;
            }
        }

        return -1;
    }

    public void inserir(Palavra palavra) {

        if (raiz == null) {
            raiz = new NoExterno(palavra);  // arvore vazia
            return;
        }

        if (raiz instanceof NoExterno) {  // segunda palavra a ser inserida  

            NoExterno externo = (NoExterno) raiz;

            if (externo.palavra.getBits().equals(palavra.getBits())) { // testa se já tem a palavra
                externo.palavra.adicionarPosicao(palavra);     //ta errado 
                return;
            }

            int bit = primeiroBitDiferente(  // procura o bit de diferença
                    externo.palavra,
                    palavra
            );

            NoExterno novoExterno = new NoExterno(palavra);

            if (palavra.getBits().charAt(bit) - '0' == 0) {
                raiz = new NoInterno(bit, novoExterno, externo); // insere a esquerda
            } else {
                raiz = new NoInterno( bit, externo, novoExterno); // insere a direita
            }

            return;
        }
    }

    public Palavra buscar(String palavra) {

        if (raiz == null) {
            return null;
        }

        
    }
}