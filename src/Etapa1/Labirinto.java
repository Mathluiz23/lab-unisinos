package Etapa1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Labirinto {
    public static final char PAREDE = 'X';
    public static final char CAMINHO_ABERTO = ' ';
    public static final char SAIDA = 'D';
    public static final char CAMINHO_SOLUCAO = '.';

    private char[][] labirinto;

    public void criaLabirinto(String nomeArquivo) {
        try {
            List<String> linhas = Files.readAllLines(Path.of(nomeArquivo));
            if (linhas.isEmpty()) {
                throw new IllegalArgumentException("Arquivo de labirinto vazio.");
            }

            int colunas = 0;
            for (String linha : linhas) {
                if (linha.length() > colunas) {
                    colunas = linha.length();
                }
            }

            labirinto = new char[linhas.size()][colunas];
            for (int i = 0; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                for (int j = 0; j < colunas; j++) {
                    labirinto[i][j] = j < linha.length() ? linha.charAt(j) : CAMINHO_ABERTO;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Nao foi possivel ler o arquivo: " + nomeArquivo, e);
        }
    }

    public boolean percorreLabirinto() {
        if (labirinto == null || labirinto.length == 0) {
            return false;
        }

        for (int linha = 0; linha < labirinto.length; linha++) {
            for (int coluna = 0; coluna < labirinto[linha].length; coluna++) {
                if (ehEntrada(linha, coluna) && percorreLabirinto(linha, coluna)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean percorreLabirinto(int linha, int coluna) {
        if (!posicaoValida(linha, coluna) || labirinto[linha][coluna] == PAREDE || labirinto[linha][coluna] == CAMINHO_SOLUCAO) {
            return false;
        }

        if (labirinto[linha][coluna] == SAIDA) {
            return true;
        }

        labirinto[linha][coluna] = CAMINHO_SOLUCAO;

        if (percorreLabirinto(linha - 1, coluna)
                || percorreLabirinto(linha + 1, coluna)
                || percorreLabirinto(linha, coluna - 1)
                || percorreLabirinto(linha, coluna + 1)) {
            return true;
        }

        labirinto[linha][coluna] = CAMINHO_ABERTO;
        return false;
    }

    private boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < labirinto.length && coluna >= 0 && coluna < labirinto[linha].length;
    }

    private boolean ehEntrada(int linha, int coluna) {
        boolean borda = linha == 0 || coluna == 0 || linha == labirinto.length - 1 || coluna == labirinto[linha].length - 1;
        return borda && labirinto[linha][coluna] == CAMINHO_ABERTO;
    }

    public void imprimeLabirinto() {
        if (labirinto == null) {
            System.out.println("Labirinto nao carregado.");
            return;
        }

        for (char[] linha : labirinto) {
            System.out.println(new String(linha));
        }
    }
}
