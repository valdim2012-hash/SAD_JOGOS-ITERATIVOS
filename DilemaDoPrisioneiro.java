
package sad;
import java.util.Scanner;
/**
 *
 * @author VALDIM ZEFERINO
 */
public class DilemaDoPrisioneiro {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Parâmetros da fórmula
        double delta = 0.1 + (Math.random() * (0.99 - 0.1)); // Fator de desconto (0 a 1)
        double v1 = 0;      // Valor total acumulado Jogador 1
        double v2 = 0;      // Valor total acumulado Jogador 2
        int t = 0;          // Rodada atual

        System.out.println("--- Dilema do Prisioneiro: Calculo de Valor Presente (V) ---");
        System.out.println("Factor de Desconto (Delta): " + delta);

        while (true) {
            System.out.println("\n--- RODADA " + t + " ---");
            System.out.println("[1] Cooperar | [0] Trair | [9] Sair");
            
            System.out.print("Jogador 1: ");
            int p1 = scanner.nextInt();
            if (p1 == 9) break;

            System.out.print("Jogador 2: ");
            int p2 = scanner.nextInt();
            if (p2 == 9) break;

            // Definindo os ganhos (pi) de cada um nesta rodada
            int pi1 = 0, pi2 = 0;

            if (p1 == 1 && p2 == 1) {
                pi1 = 3; pi2 = 3; // Ambos cooperam: Ganho moderado
                System.out.println(">> Ambos cooperaram (Recompensa).");
            } else if (p1 == 1 && p2 == 0) {
                pi1 = 0; pi2 = 5; // J2 traiu: J2 ganha muito, J1 nada
                System.out.println(">> J1 foi traido!");
            } else if (p1 == 0 && p2 == 1) {
                pi1 = 5; pi2 = 0; // J1 traiu
                System.out.println(">> J2 foi traido!");
            } else if (p1 == 0 && p2 == 0) {
                pi1 = 1; pi2 = 1; // Ambos trairam: Ganho baixo
                System.out.println(">> Ambos trairam (Punicão).");
            }

            // Aplicação da fórmula: V = soma de (delta^t * pi)
            v1 += Math.pow(delta, t) * pi1;
            v2 += Math.pow(delta, t) * pi2;

            System.out.printf("Valor Acumulado (V) -> J1: %.2f | J2: %.2f\n", v1, v2);
            
            t++; // Avança o tempo na fórmula
        }

        System.out.println("\nJogo terminado. Resultados finais:");
        System.out.printf("V1 total: %.2f\nV2 total: %.2f\n", v1, v2);
        scanner.close();
    }
}
