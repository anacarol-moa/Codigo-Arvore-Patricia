package arvorepatricia;

public class Main {

    public static void main(String[] args) {
        Palavra[] v = new Palavra[100];
        ExtraiPalavra e = new ExtraiPalavra("exemplo1.txt");
        e.lerArquivo(v);
    }
    
}
