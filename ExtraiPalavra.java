package arvorepatricia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class ExtraiPalavra {
    private String arquivo;
    private Scanner leitor;
    private Formatter gravador;
    
    public ExtraiPalavra(){
    }
    
    public ExtraiPalavra(String arquivo) {
        this.arquivo = "exemplo1.txt";
    }
    
    public void abrirArquivoLeitura(){
        try{
            leitor = new Scanner(new File(arquivo));
        }catch (FileNotFoundException ex){
            System.err.print("Ocorreu erro ao abrir o arquivo para leitura");
        }    }
    
    public lerArquivo(){
        
        }
     
    public void fecharArquivoLeitura(){
        if(leitor!=null)
            leitor.close();
    }
}
