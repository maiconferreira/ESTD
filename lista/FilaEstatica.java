public class FilaEstatica {
    private int cabeca;
    private int cauda;
    private Object[] vetor;

    public FilaEstatica(int tamanho){
        vetor = new Object[tamanho];
        cabeca = -1;
        cauda = -1;
    }

    public boolean vazia(){
        return cabeca == -1 && cauda == -1;
    }

    public void adicionar(Object valor){
        cauda = (cauda + 1) % vetor.length;
        vetor[cauda] = valor;
        if(cabeca == -1){
            cabeca = cauda;
        }
    }
}