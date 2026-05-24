package Etapa3;

public class PrincipalEtapa3 {
    public static void main(String[] args) {
        StaticList<String> lista = new StaticList<>(5);
        lista.insert("A", 0);
        lista.insert("B", 1);
        lista.insert("A", 2);
        System.out.println("Quantidade de A: " + lista.contaElementos("A"));

        StaticStack<String> pilha = new StaticStack<>(5);
        pilha.push("(");
        pilha.push(")");
        System.out.println("Parenteses balanceados: " + new Etapa3().checkBrackets(pilha));
    }
}
