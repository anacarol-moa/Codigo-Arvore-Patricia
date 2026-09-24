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
     
    public void fecharArquivoLeitura(){
        if(leitor!=null)
            leitor.close();
    }
}
