package Etapa3;

public class Etapa3 {
    public boolean checkBrackets(Stack stack) {
        int fechamentosPendentes = 0;

        while (!stack.isEmpty()) {
            Object item = stack.pop();
            String caractere = String.valueOf(item);

            if (")".equals(caractere)) {
                fechamentosPendentes++;
            } else if ("(".equals(caractere)) {
                fechamentosPendentes--;
                if (fechamentosPendentes < 0) {
                    return false;
                }
            }
        }

        return fechamentosPendentes == 0;
    }
}
