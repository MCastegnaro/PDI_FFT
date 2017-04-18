package br.edu.pdi.transformada;

/**
 *
 * @author matheus.fbc
 */
public class Transformada {

    /**
     * O método execute, recebe 5 parâmetros de entrada. 
     * @param entradaReal Array que recebe os valores da séria real.
     * @param entradaImaginaria Array que recebe os valores da série imaginária.
     * @param scala Valor de escala que que é aplicado a saida da transformada.
     * @param saidaReal Array que recebe os valores de saída da transformada real.
     * @param saidaImaginaria Array que recebe os valores de saída da transformada imaginária.
     */
    public void execute(double[] entradaReal, double[] entradaImaginaria, double scala, double[] saidaReal, double[] saidaImaginaria) {
        /*
         * O corpo do programa contem um for que itera nos arrays de entrada,
         * passando cada amostra complexa contida nesses dois arrays para um
         * método chamado corrigirRecombinar
         */
        for (int i = 0; i < entradaReal.length; i++) {
            corrigirRecombinar(entradaReal[i], entradaImaginaria[i], i, entradaReal.length, scala, saidaReal, saidaImaginaria);
        }
    }
    /**
     * O método corrigirRecombinar corrige o resultado da transformada para cada
     * uma das amostras complexas, de modo a refletir a posição real da amostra
     * na série original de entrada. Em seguida, o metodo adiciona o resultado 
     * da transformada corrigida em um par de arrays (Acumuladores), um para o
     * real e outro para o imaginário. Isto realiza a recombinação das 
     * transformações corrigidas das amostras de entrada para produzir a 
     * transformação de toda série de entrada.
     * @param amostraReal
     * @param amostraImaginaria
     * @param posicao
     * @param tamanho
     * @param scala
     * @param saidaReal
     * @param saidaImaginaria
     */
    public void corrigirRecombinar(double amostraReal, double amostraImaginaria, int posicao, int tamanho, double scala, double[] saidaReal, double[] saidaImaginaria) {
        /* 
         * Note o uso dos métos Math.cas e Math.sin para aplicar as curvas de 
         * Seno e cosseno na correção da transformação. Note também o uso do
         * parêmetro posição e tamanho na coputação do angulo que é passado
         * como argumento para os métodas Math.sin e Math.cos. Observe como a 
         * a correção é aplicada separadamente para nas partes reais e imaginarias.
         * 
         */
        for (int i = 0; i < tamanho; i++) {
            double angulo = (2.0 * Math.PI * i / tamanho) * posicao;

          
            saidaReal[i] += amostraReal * Math.cos(angulo) / scala;
            saidaImaginaria[i] += amostraReal * Math.sin(angulo) / scala;

          
            saidaReal[i] += amostraImaginaria * Math.sin(angulo) / scala;
            saidaImaginaria[i] += amostraImaginaria * Math.cos(angulo) / scala;

        }
    } 
} 
