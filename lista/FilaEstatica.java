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

    public boolean cheia(){
        return (cauda + 1) %  vetor.length == cabeca;
    }

    public void adicionar(Object valor) throws FilaCheiaException {
        if (cheia()) {
            throw new FilaCheiaException();
        }        
        cauda = (cauda + 1) % vetor.length;
        vetor[cauda] = valor;
        if(cabeca == -1){
            cabeca = cauda;
        }
    }

    public Object remover() throws FilaVaziaException {
        if (vazia()){
            throw new FilaVaziaException();
        }
        Object valor = vetor[cabeca];
        if (cabeca == cauda) { //Só tem um elemento
            cabeca = cauda = -1;
        } else {
            cabeca = (cabeca + 1) % vetor.length;
        }
        return valor;
    }

    public void limpar() {
        cabeca = -1;
        cauda = -1;
    }

    public void percorrer() {
        if (!vazia()){
            for ( int i = cabeca; i != cauda; i = (i + 1) % vetor.length) {
                System.out.println(vetor[i]);
            }
            System.out.println(vetor[cauda]);
        }
    }
}