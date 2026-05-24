package Etapa2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
        int posicao = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, candidatos[0].getNome());
        System.out.println("Pesquisa binaria encontrou posicao: " + posicao);
    }

    private static Candidato[] carregaCandidatos() {
        try {
            List<String> nomes = leArquivo("nomes.txt");
            List<String> partidos = leArquivo("partidos.txt");
            int quantidade = Math.min(nomes.size(), partidos.size());
            Candidato[] candidatos = new Candidato[quantidade];

            for (int i = 0; i < quantidade; i++) {
                candidatos[i] = new Candidato(nomes.get(i), partidos.get(i), (i * 37 + 13) % 100);
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

    private static void imprime(String titulo, Candidato[] candidatos) {
        System.out.println();
        System.out.println(titulo);
        for (int i = 0; i < Math.min(candidatos.length, 5); i++) {
            System.out.println(candidatos[i]);
        }
    }
}
