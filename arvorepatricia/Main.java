package arvorepatricia;

public class Main {

    public static void main(String[] args) {
        ArvorePatricia arvore = new ArvorePatricia();
        ExtraiPalavra e = new ExtraiPalavra("exemplo1.txt");
        e.lerArquivo(arvore);
        arvore.buscarPalavra("Brasil");
    }
}
