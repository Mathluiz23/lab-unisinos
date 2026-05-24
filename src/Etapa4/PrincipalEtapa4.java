package Etapa4;

public class PrincipalEtapa4 {
    public static void main(String[] args) {
        LinkedStack<Integer> pilha = new LinkedStack<>();
        pilha.push(10);
        pilha.push(20);
        System.out.println("Topo da pilha: " + pilha.top());

        LinkedQueue<String> fila = new LinkedQueue<>();
        fila.enqueue("primeiro");
        fila.enqueue("segundo");
        System.out.println("Frente da fila: " + fila.front());
        System.out.println("Fim da fila: " + fila.back());
    }
}
