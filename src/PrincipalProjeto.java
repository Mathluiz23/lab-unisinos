import Etapa1.PrincipalLabirinto;
import Etapa2.PrincipalCandidatos;
import Etapa3.PrincipalEtapa3;
import Etapa4.PrincipalEtapa4;

public class PrincipalProjeto {
    public static void main(String[] args) {
        System.out.println("===== ETAPA 1 =====");
        PrincipalLabirinto.main(new String[0]);

        System.out.println();
        System.out.println("===== ETAPA 2 =====");
        PrincipalCandidatos.main(new String[0]);

        System.out.println();
        System.out.println("===== ETAPA 3 =====");
        PrincipalEtapa3.main(new String[0]);

        System.out.println();
        System.out.println("===== ETAPA 4 =====");
        PrincipalEtapa4.main(new String[0]);
    }
}
