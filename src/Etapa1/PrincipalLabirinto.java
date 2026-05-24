package Etapa1;

public class PrincipalLabirinto {
    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();
        labirinto.criaLabirinto("src/Etapa1/labirinto.txt");

        System.out.println("Labirinto original:");
        labirinto.imprimeLabirinto();
        System.out.println();

        if (labirinto.percorreLabirinto()) {
            System.out.println("Solução encontrada:");
            labirinto.imprimeLabirinto();
        } else {
            System.out.println("Solucao nao encontrada.");
        }
    }
}
