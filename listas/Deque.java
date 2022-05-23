package listas;

public class Deque{
    public class Elemento {
        Elemento proximo, anterior;
        Object valor;

        public Elemento(Object valor) {
            this.valor = valor;
        }
    }

        private Elemento cabeca;
        private Elemento cauda;

        public boolean vazia() {
            return cabeca == null && cauda == null;
        }

        public void adicionarCabeca(Object valor) {
            Elemento elemento = new Elemento(valor);
            
            if (vazia()) {
                cabeca = elemento;
            } else {
                cabeca.anterior = elemento;
            }
            
            cabeca = elemento;
        }

        public void adicionarCauda(Object valor) {
            Elemento elemento = new Elemento(valor);
            
            if (vazia()) {
                cabeca = elemento;
            } else {
                cauda.proximo = elemento;
            }
            
            cauda = elemento;
        }

    public Object removerCabeca() throws DequeVaziaException {
        if (vazia()) {
            throw new DequeVaziaException();
        }

        Object valor = cabeca.valor;
        cabeca = cabeca.proximo;

        if (cabeca == null) {
            cauda = null;
        }

        return valor;
    }

    public Object removerCauda() throws DequeVaziaException {
        if (vazia()) {
            throw new DequeVaziaException();
        }

        Object valor = cauda.valor;
        cauda = cauda.anterior;

        if (cabeca == null) {
            cauda = null;
        }

        return valor;
    }

    public void limpar() {
        while (!vazia()) {
            try {
                removerCauda();
            } catch(DequeVaziaException e) {
            }
        }
    }

    public void percorrerCabeca() {
        Elemento elemento = cabeca;

        while (elemento != null) {
            System.out.println(elemento.valor);
            elemento = elemento.proximo;
        }
    }

    public static void main(String[] args) throws Exception {
        Deque deque = new Deque();

        for (int i = 0; i < 5; i++) {
            deque.adicionarCabeca(i);
        }
        
        
        System.out.println("---------------");
        deque.percorrerCabeca();

        //deque.removerCauda();
        //deque.removerCauda();

        //System.out.println("---------------");
        //deque.percorrer();

        //deque.adicionarCauda(6);
        //deque.adicionarCauda(7);

        //System.out.println("---------------");
        //deque.percorrer();
    }
}