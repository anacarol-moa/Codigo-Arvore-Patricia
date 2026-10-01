package arvorepatricia;

public class Main {

    public static void main(String[] args) {

        System.out.println("========== EXEMPLO 1 ==========");

        ArvorePatricia arvore1 = new ArvorePatricia();
        ExtraiPalavra e1 = new ExtraiPalavra("exemplo1.txt");
        e1.lerArquivo(arvore1);

        arvore1.buscarPalavra("trabalho");
        arvore1.buscarPalavra("computacao");
        arvore1.buscarPalavra("governo");
        arvore1.buscarPalavra("educacao");
        arvore1.buscarPalavra("tecnologia");
        arvore1.buscarPalavra("formacao");
        arvore1.buscarPalavra("desenvolvimento");
        arvore1.buscarPalavra("que");
        arvore1.buscarPalavra("informatica");
        arvore1.buscarPalavra("em");
        arvore1.buscarPalavra("crise");


        System.out.println("\n========== EXEMPLO 2 ==========");

        ArvorePatricia arvore2 = new ArvorePatricia();
        ExtraiPalavra e2 = new ExtraiPalavra("exemplo2.txt");
        e2.lerArquivo(arvore2);

        arvore2.buscarPalavra("sociedade");
        arvore2.buscarPalavra("software");
        arvore2.buscarPalavra("ideia");
        arvore2.buscarPalavra("pessoa");
        arvore2.buscarPalavra("Informatica");
        arvore2.buscarPalavra("etica");
        arvore2.buscarPalavra("muito");
        arvore2.buscarPalavra("ciencia");
        arvore2.buscarPalavra("computacao");
        arvore2.buscarPalavra("que");
        arvore2.buscarPalavra("area");
        arvore2.buscarPalavra("moral");
    }
}
