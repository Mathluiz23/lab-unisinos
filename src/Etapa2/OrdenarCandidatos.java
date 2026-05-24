package Etapa2;

public class OrdenarCandidatos {
    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        insertionSort(candidatos, "nome");
    }

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        insertionSort(candidatos, "votos");
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        insertionSort(candidatos, "partido");
    }

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int inicio = 0;
        int fim = candidatos.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = candidatos[meio].getNome().compareToIgnoreCase(nome);

            if (comparacao == 0) {
                return meio;
            }
            if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    private static void insertionSort(Candidato[] candidatos, String criterio) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato atual = candidatos[i];
            int j = i - 1;

            while (j >= 0 && compara(candidatos[j], atual, criterio) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }

            candidatos[j + 1] = atual;
        }
    }

    private static int compara(Candidato a, Candidato b, String criterio) {
        if ("votos".equals(criterio)) {
            return Integer.compare(a.getIntencoesVotos(), b.getIntencoesVotos());
        }
        if ("partido".equals(criterio)) {
            return a.getPartido().compareToIgnoreCase(b.getPartido());
        }
        return a.getNome().compareToIgnoreCase(b.getNome());
    }
}
