package arvorepatricia;


public class ArvorePatricia {
    private No raiz;

    public ArvorePatricia() {
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
            raiz = new No(129, palavra.getBits(), palavra, null, null, null);  // arvore vazia
            return;
        }

        No atual = raiz;
        boolean controle = false;
        while (atual.getFilho0E() != null || atual.getFilho1D() != null) {

            int bit = palavra.getBits().charAt(atual.getDifBit());

            if (palavra.getBits().substring(0, atual.getDifBit()).equals(atual.getBitAcumulado())){ //verifica se não precisa criar nos no meio do caminho
                if (bit == 48) { //0 em ascii
                    if (atual.getFilho0E() != null){
                        atual = atual.getFilho0E();
                    }
                    else{
                        No n = new No(129, palavra.getBits(), palavra, atual, null, null);
                        atual.setFilho0E(n);
                        return;
                    }
                } else {
                    if (atual.getFilho1D() != null){
                        atual = atual.getFilho1D();
                    }
                    else{
                        No n = new No(129, palavra.getBits(), palavra, atual, null, null);
                        atual.setFilho1D(n);
                        return;
                    }
                }
            }
            else{
                controle = true; //dedine algumas pequenas alteraçoes na hora de inserir
                break;
            }
        }

        int diffbit;
        if (controle){
            Palavra p = new Palavra(atual.getBitAcumulado()); //so pra achar o primeiro bit diferente
            diffbit = primeiroBitDiferente(p, palavra);
        }
        else{
            if (atual.getPalavra().getBits().equals(palavra.getBits())) { // se já existe essa palavra
                atual.getPalavra().adicionarPosicao(palavra.getLinha(), palavra.getColuna()); // aumenta a posição
                return;
            }
            diffbit = primeiroBitDiferente(palavra, atual.getPalavra());
        }

        No r = new No(diffbit, palavra.getBits().substring(0, diffbit), null, atual.getPai(), null, null);
        No n = new No(129, palavra.getBits(), palavra, r, null, null);
        int bit = palavra.getBits().charAt(diffbit);
        if (atual == raiz){
            raiz = r;
        }
        else if (atual.getPai().getFilho0E() == atual){
            atual.getPai().setFilho0E(r);
        }
        else{
            atual.getPai().setFilho1D(r);
        }
        atual.setPai(r);
        if (bit == 48){
            r.setFilho0E(n);
            r.setFilho1D(atual);
        }
        else{
            r.setFilho1D(n);
            r.setFilho0E(atual);
        }
    }

    public void buscarPalavra (String palavra) {
        if (raiz == null) {
            System.out.println("Palavra não encontrada.");
        }
        Palavra procurada = new Palavra(palavra,0,0);
        No atual = raiz;
        while (atual.getFilho0E() != null || atual.getFilho1D() != null) { // procura nó interno
            if (procurada.getBits().substring(0, atual.getDifBit()).equals(atual.getBitAcumulado())){
                int bit = procurada.getBits().charAt(atual.getDifBit());
                if (bit == 48){
                    if (atual.getFilho0E() != null){
                        atual = atual.getFilho0E();
                    }
                    else{
                        System.out.println("Palavra não encontrada.");
                        return;
                    }
                }
                else{
                    if (atual.getFilho1D() != null){
                        atual = atual.getFilho1D();
                    }
                    else{
                        System.out.println("Palavra não encontrada.");
                        return;
                    }
                }
            }
            else{
                System.out.println("Palavra não encontrada.");
                return;
            }
        }
        if (atual.getPalavra().getPalavra().trim().equals(palavra)){
            System.out.println("Palavra encontrada nas posições: " + atual.getPalavra().getPosicoes());
            return;
        }
        System.out.println("Palavra não encontrada.");
    }
}