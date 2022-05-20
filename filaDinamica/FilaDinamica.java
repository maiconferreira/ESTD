public class FilaDinamica {
    class Elemento {
        private Object valor;
        private Elemento proximo;

        public Elemento(Object valor){
            this.valor = valor;
        }
    }

    private Elemento cabeca;
    private Elemento cauda;

    public boolean vazia(){
        return cabeca == null && cauda == null;
    }

    public void adicionar(Object valor){
        Elemento elemento = new Elemento(valor);

        if (vazia()){
            cabeca = elemento;
        }else{
            cauda.proximo = elemento;
        }

        cauda = elemento;
    }

    

    public Object pop() throws FilaVaziaException{
        if (vazia()){
            throw new FilaVaziaException();
        }
        Object valor = cabeca.valor;
        cabeca = cabeca.proximo;

        if (cabeca == null){
            cauda = null;
        }
        return valor;
    }
    
}