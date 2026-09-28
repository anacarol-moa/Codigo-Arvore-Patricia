package arvorepatricia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class ExtraiPalavra {
    private String arquivo;
    private Scanner leitor;
    
    public ExtraiPalavra(){
    }
    
    public ExtraiPalavra(String arquivo) {
        this.arquivo = arquivo;
        try{
            leitor = new Scanner(new File(arquivo));
        }
        catch (FileNotFoundException ex){
            System.err.print("Ocorreu erro ao abrir o arquivo para leitura");
        }
    }
  
    /*
    Separa as palavras por espaço, mas se tiver uma vírgula após uma palavra "exemplo," tudo isso será identificado como palavra
    public void lerArquivo(Palavra[] v){
        for(int i=0; leitor.hasNextLine(); i++){
            String linha = leitor.nextLine();
            Scanner l = new Scanner(linha);
            for(int j=0; l.hasNext(); j++){
                String s = l.next();
                Palavra p = new Palavra(s, i, j);
            }
        }

        fecharArquivoLeitura();
    }
    */

      
    private boolean ehLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean ehDigito(char c) {
        return c >= '0' && c <= '9';
    }

    public void lerArquivo(ArvorePatricia arvore) {
        if (leitor == null) {
            return;
        }

        int numLinha = 0;
        while (leitor.hasNextLine()) {
            numLinha++;
            // remove acentos para que só fiquem caracteres ASCII
            String linha = Palavra.normalizar(leitor.nextLine());

            int i = 0;
            while (i < linha.length()) {
                char c = linha.charAt(i);

                if (ehLetra(c) || ehDigito(c)) {
                    int inicio = i;
                    while (i < linha.length() && (ehLetra(linha.charAt(i)) || ehDigito(linha.charAt(i)))) {
                        i++;
                    }
                    // só é palavra se começar por letra
                    if (ehLetra(linha.charAt(inicio))) {
                        String s = linha.substring(inicio, i);
                        arvore.inserir(new Palavra(s, numLinha, inicio + 1)); // coluna começa em 1
                    }
                } else {
                    i++;
                }
            }
        }
        fecharArquivoLeitura();
    }
     
    public void fecharArquivoLeitura(){
        if(leitor!=null)
            leitor.close();
    }
}
