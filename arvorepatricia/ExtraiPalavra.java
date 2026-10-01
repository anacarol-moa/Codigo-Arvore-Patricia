package arvorepatricia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExtraiPalavra {
    private Scanner leitor;
    
    public ExtraiPalavra(String arquivo) {
        try{
            leitor = new Scanner(new File(arquivo));
        }
        catch (FileNotFoundException ex){
            System.err.print("Ocorreu erro ao abrir o arquivo para leitura");
        }
    }

    //Separa as palavras por espaço, mas se tiver uma vírgula após uma palavra "exemplo," tudo isso será identificado como palavra
    public void lerArquivo(ArvorePatricia arvore){
        for(int i=0; leitor.hasNextLine(); i++){
            String linha = leitor.nextLine();
            Scanner l = new Scanner(linha);
            for(int j=0; l.hasNext(); j++){
                String s = normalizar(l.next());
                Palavra p = new Palavra(s, i, j);
                arvore.inserirPalavra(p);
            }
        }

        fecharArquivoLeitura();
    }

      
    private boolean ehLetra(char c) { //nos textos nao tem acento nenhum
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean ehDigito(char c) {
        return c >= '0' && c <= '9';
    }
     
    public void fecharArquivoLeitura(){
        if(leitor!=null)
            leitor.close();
    }

    private String normalizar(String s){
        String n = "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (ehDigito(c) || ehLetra(c)) {
                n = n + c;
            } else {
                count++;
            }
        }
        for (int i = 0; i < count; i++){
            n = n + ' ';
        }
        return n;
    }
}
