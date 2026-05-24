package Etapa3;

public class Etapa3 {
    public boolean checkBrackets(Stack stack) {
        int abertos = 0;

        while (!stack.isEmpty()) {
            Object item = stack.pop();
            if (")".equals(String.valueOf(item))) {
                abertos++;
            } else if ("(".equals(String.valueOf(item))) {
                abertos--;
                if (abertos < 0) {
                    return false;
                }
            }
        }

        return abertos == 0;
    }
}
