/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvorepatricia;

/**
 *
 * @author anaca
 */
public class ArvorePatricia {
      private abstract class No {
        
    }

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
}
