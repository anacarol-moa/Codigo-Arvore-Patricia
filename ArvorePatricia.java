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

    public void inserirPalavra (Palavra palavra) {

        if (raiz == null) {
            raiz = new NoExterno(palavra);  // arvore vazia
            return;
        }

        No atual = raiz;

        while (atual instanceof NoInterno) {   

            NoInterno interno = (NoInterno) atual;
            
            int bit = palavra.getBits().charAt(interno.bit) - '0';
            
            if (bit == 0) {
                atual = interno.esquerda;
            } else {
                atual = interno.direita;
            }
        }
        NoExterno externo = (NoExterno) atual;

        if (externo.palavra.getBits().equals(palavra.getBits())) { // se já existe essa palavra
            externo.palavra.adicionarPosicao(palavra.getLinha(), palavra.getColuna()); // aumenta a posição
            return;
        }

        int novoBit = primeiroBitDiferente(externo.palavra, palavra); // procurando diferença

        No pai = null;
        atual = raiz;

        while (atual instanceof NoInterno) {

            NoInterno interno = (NoInterno) atual;
            if (interno.bit >= novoBit) { // onde inserir
                break;
            }

            pai = atual;
            int bit = palavra.getBits().charAt(interno.bit) - '0';

            if (bit == 0) {
                atual = interno.esquerda;
            } else {
                atual = interno.direita;
            }
        }

        NoExterno novoExterno = new NoExterno(palavra);
        NoInterno novoInterno;
        int bitPalavra = palavra.getBits().charAt(novoBit) - '0';

        if (bitPalavra == 0) {
            novoInterno = new NoInterno(novoBit, novoExterno, atual);
        } else {novoInterno = new NoInterno(novoBit, atual, novoExterno);
        }

        if (pai == null) {
            raiz = novoInterno;
        } else {
            NoInterno internoPai = (NoInterno) pai;

            int bitPai = palavra.getBits().charAt(internoPai.bit) - '0';

            if (bitPai == 0) {
                internoPai.esquerda = novoInterno;
            } else {
                internoPai.direita = novoInterno;
            }
        }
    }

    public void buscarPalavra (String palavra) {
        if (raiz == null) {
            System.out.println("Palavra não encontrada.");
        }
    }
}