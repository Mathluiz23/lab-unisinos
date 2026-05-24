package Etapa2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {
    public static void main(String[] args) {
        Candidato[] candidatos = carregaCandidatos();

        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        imprime("Ordenados por nome", candidatos);

        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
        imprime("Ordenados por votos", candidatos);

        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
        imprime("Ordenados por partido", candidatos);

        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        String nomePesquisado = leNomePesquisado(candidatos[0].getNome());
        int posicao = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nomePesquisado);

        System.out.println();
        if (posicao >= 0) {
            System.out.println("Candidato encontrado:");
            System.out.println(candidatos[posicao]);
        } else {
            System.out.println("Candidato nao encontrado: " + nomePesquisado);
        }
    }

    private static Candidato[] carregaCandidatos() {
        try {
            List<String> nomes = leArquivo("nomes.txt");
            List<String> partidos = leArquivo("partidos.txt");
            Random random = new Random();
            int quantidade = random.nextInt(100) + 1;
            Candidato[] candidatos = new Candidato[quantidade];

            for (int i = 0; i < quantidade; i++) {
                String nome = nomes.get(random.nextInt(nomes.size()));
                String partido = partidos.get(random.nextInt(partidos.size()));
                int votos = random.nextInt(1000);
                candidatos[i] = new Candidato(nome, partido, votos);
            }

            return candidatos;
        } catch (IOException e) {
            return new Candidato[] {
                    new Candidato("Ana", "PT", 40),
                    new Candidato("Bruno", "PL", 25),
                    new Candidato("Carla", "PSD", 55)
            };
        }
    }

    private static List<String> leArquivo(String nomeArquivo) throws IOException {
        Path caminhoSrc = Path.of("src", "Etapa2", nomeArquivo);
        if (Files.exists(caminhoSrc)) {
            return Files.readAllLines(caminhoSrc);
        }

        return Files.readAllLines(Path.of("Etapa2", nomeArquivo));
    }

    private static String leNomePesquisado(String nomePadrao) {
        System.out.println();
        System.out.print("Informe o nome para pesquisa binaria ou pressione Enter para usar " + nomePadrao + ": ");

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String nome = scanner.nextLine().trim();
            if (!nome.isEmpty()) {
                return nome;
            }
        }

        return nomePadrao;
    }

    private static void imprime(String titulo, Candidato[] candidatos) {
        System.out.println();
        System.out.println(titulo);
        for (int i = 0; i < Math.min(candidatos.length, 5); i++) {
            System.out.println(candidatos[i]);
        }
    }
}
