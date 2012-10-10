/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package countingSort;

/**
 *
 * @author douglasgonzalez
 */

/* =================================== COUNTING SORT ==================================  
 *      Não é baseado em comparações.  
 *      Funciona apenas para ordenar um vetor de n elementos, no qual o valor do  
 *   maior elemento pertence a O(n), ou seja, todos os elementos do vetor têm que ter  
 *   valores entre 0 e k, onde k <=n.  
 *      Esse algoritmo percorre o vetor dado e vai somando um na posição correspondente  
 *   do vetor auxiliar criado.  
 *      Por exemplo: no passo i a posição i do vetor tem valor 3, então somo 1 ao valor contido   
 *   na posição três do vetor auxiliar. Isso faz com que no final desse looping, eu tenha guardado  
 *   em um vetor o número de vezes que cada elemento apareceu.  
 *      Depois basta criar um vetor resposta, e copiar os valores do vetor dado com base  
 *   nos indices do vetor auxiliar.  
 */
public class CountingSort {

    public static void CountingSort(int vetor[]) { //recebe o vetor
        // Chama o método que acha o índice do maior valor
        int maior = getIndiceDoMaiorValor(vetor);

        // Cria um vetor auxiliar com tamanho do maior elemento do vetor + 1
        int[] aux = new int[vetor[maior] + 1];

        // Cria um vetor resposta com o mesmo tamanho do vetor
        int[] resposta = new int[vetor.length];

        // Coloca "0" em cada elemento do vetor aux
        for (int i = 0; i < aux.length; i++) {
            aux[i] = 0;
        }
        // Percorre o vetor e cada valor encontrado ele incrementa 1 no índice correspondente no aux
        for (int i = 0; i < vetor.length; i++) {
            aux[vetor[i]] += 1;
        }
        // No vetor aux
        // Soma o valor do índice 1 com o valor do índice anterior, 
        // o valor do índice 2 com o anterior até o final do aux
        for (int i = 1; i < aux.length; i++) {
            aux[i] += aux[i - 1];
        }
        /*
         * Usa o valor do vetor com índice no aux,
         * pegando o valor deste índice e usando índice -1 para inserir o
         * valor do vetor na exata posição no resposta, depois decrementa aux[i]
         */
        for (int i = 0; i < vetor.length; i++) {
            resposta[aux[vetor[i]]-- - 1] = vetor[i];
            /*
             * O que acontece nesta linha é o seguinte:
             *      resposta[aux[vetor[i]]-- - 1] = vetor[i];
             *  - o valor de vetor[i] é utilizado como índice do vetor aux
             *  - o valor do aux[vetor[i]] -1 é utilizado como índice do vetor resposta
             *  - atribuí-se o valor de vetor[i] ao vetor resposta, na posição calculada no passo anterior
             *  - o valor de aux[vetor[i]] é decrementado em uma unidade.
             * 
             * Quando ocorre aux[vetor[i]]--, significa que primeiro você utiliza o valor do aux nesta posição e depois ele é decrementado em uma unidade. 
             * Portanto, o decremento (--) será a última coisa a ser feita.
             */
        }

        /*
         * Copia do vetor resposta para o vetor principal
         */
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = resposta[i];
        }

    }

    /*
     * Método para achar o índice do maior valor
     */
    public static int getIndiceDoMaiorValor(int[] v) {
        int m = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] > v[m]) {
                m = i;
            }
        }
        return m;
    }

    public static void main(String args[]) {
        //int[] vetor = {2, 3, 20, 20, 1, 1, 5, 7, 0, 1, 6, 4, 5};
        /*
         * Gera um array com valores aleatórios
         */
        int[] vetor;
        vetor = new int[100]; 
        for (int i = 0; i < vetor.length; i++) 
        {
            vetor[i] = (int) (Math.random() * 10); // atribui o valoor aleatório à posição i        
        }
        
        for (int i = 0; i < vetor.length; ++i) {
            System.out.print(vetor[i] + ", ");
        }
        System.out.println();
        CountingSort(vetor);
        for (int i = 0; i < vetor.length; ++i) {
            System.out.print(vetor[i] + ", ");
        }
        System.out.println();

    }
}
