public class App {
    public static void main(String[] args) throws Exception {
        FilaEstatica fila = new FilaEstatica(5);
        for (int i = 0; i < 5; i++){
            fila.adicionar(i);
        }
        System.out.println("----------------");
        fila.percorrer();

        fila.remover();
        fila.remover();

        System.out.println("---------------------");
        fila.percorrer();
    }
    
}
