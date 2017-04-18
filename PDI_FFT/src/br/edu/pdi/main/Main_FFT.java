/**
 * Este programa não implementa um algoritimo performático de transformada de
 * Fourier, em vez disso, a fins acadêmicos, este programa ilutra e simplifica
 * os conseitos de uma transformada rápida de Fourier(FFT), seguindo as
 * seguintes etapas:
 *
 * Etapa 1. Decompor uma série complexa de N pontos em N valores complexos
 * individuais, constituindo uma única amostra complexa.
 *
 * Etapa 2. Calcular a transformada de cada uma das N amostras complexas,
 * tranatando cada uma como se estivesse localizada no início da série complexa
 *
 * Etapa 3. Corrigir cada um dos resultados da transformada de N para refletir a
 * posição real da amostra complexa na série. Esta etapa envolve a aplicação
 * de curvas de seno e cosseno às partes reais e imaginárias da transformada.
 *
 * Etapa 4. Recombinar os resultados da transformada de N em um único resultado
 * que represente a série original complexa.
 *
 * Este programa demonstra 3 exemplos de casos de séries complexas separadas,
 * aplica os processos listados acima para cada uma das séries e exibe o
 * resultado na tela. Lembrando que o algoritimo ilustra o processo de uma FTT,
 * e não apresenta a verdadeira velocidade/performace de um algoritimo FFT.
 *
 * @version 1.0
 * @author Matheus Felipe Bonetti Castegnaro
 */
package br.edu.pdi.main;

import br.edu.pdi.transformada.Transformada;

public class Main_FFT {

    public static void main(String[] args) {
        Transformada transformada = new Transformada();
        System.out.println("Caso A: ");

        /*
         * Arrays que recebem os valores de entrada, reais e imaginários, do caso 'A'
         */
        double[] entradaRealA = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        double[] entradaImaginariaA = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        /*
         * Arrays que receberam os valores de saida, reais e imaginários, do caso 'A'
         */
        double[] saidaRealA = new double[16];
        double[] saidaImaginariaA = new double[16];

        // Executa a transformada
        transformada.execute(entradaRealA, entradaImaginariaA, 2.0, saidaRealA, saidaImaginariaA);

        // Exibe os resultados transformados para a série complexa original.
        exibir(saidaRealA, saidaImaginariaA);

        /*
         * CASO B
         */
        System.out.println("\nCaso B:");

        /*
         * Arrays que recebem os valores de entrada, reais e imaginários, do caso 'B'
         */
        double[] entradaRealB = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        double[] entradaImaginariaB = {0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1};

        /*
         * Arrays que recebem os valores de saida, reais e imaginários, do caso 'B'
         */
        double[] saidaRealB = new double[16];
        double[] saidaImaginariaB = new double[16];

        // Executa a transformada
        transformada.execute(entradaRealB, entradaImaginariaB, 2.0, saidaRealB, saidaImaginariaB);

        // Exibe os resultados transformados para a série complexa original.
        exibir(saidaRealB, saidaImaginariaB);
        
        /*
         * CASO B
         */
        System.out.println("\nCaso C:");
        
        /*
         * Arrays que recebem os valores de entrada, reais e imaginários, do caso 'C'
         */
        double[] entradaRealC = {1.0, 0.923, 0.707, 0.382, 0.0, -0.382, -0.707,
                    -0.923, -1.0, -0.923, -0.707, -0.382, 0.0,
                    0.382, 0.707, 0.923};
        
        double[] entradaImaginariaC = {0.0, -0.382, -0.707, -0.923, -1.0, -0.923,
                    -0.707, -0.382, 0.0, 0.382, 0.707, 0.923,
                    1.0, 0.923, 0.707, 0.382};

        /*
         * Arrays que recebem os valores de saida, reais e imaginários, do caso 'C'
         */
        double[] saidaRealC = new double[16];
        double[] saidaImaginariaC = new double[16];

        // Executa a transformada
        transformada.execute(entradaRealC, entradaImaginariaC, 2.0, saidaRealC, saidaImaginariaC);
        
        // Exibe os resultados transformados para a série complexa original.
        exibir(saidaRealC, saidaImaginariaC);
    }

    /**
     * Método que exibe o resultado final.
     *
     * @param real recebe um array da transformada real
     * @param imaginario recebe um array da transformada imaginária
     */
    public static void exibir(double[] real, double[] imaginario) {
        System.out.println("Valor Real: ");

        for (int i = 0; i < real.length; i++) {
            System.out.print(((int) (1000.0 * real[i])) / 1000.0 + ", ");
        }

        System.out.println();
        System.out.println("Valor Imaginário: ");

        for (int i = 0; i < imaginario.length; i++) {
            System.out.print(((int) (1000.0 * imaginario[i])) / 1000.0 + ", ");
        }
        System.out.println();
    }
}
