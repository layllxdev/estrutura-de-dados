package Atividades;

public class QuickSort {

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = vetor[fim];
            int i = inicio - 1;

            for (int j = inicio; j < fim; j++) {
                if (vetor[j] <= pivo) {
                    i++;

                    int temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                }
            }

            int temp = vetor[i + 1];
            vetor[i + 1] = vetor[fim];
            vetor[fim] = temp;

            int posicaoPivo = i + 1;

            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    public static void main(String[] args) {
        int[] vetor = {5, 2, 8, 1, 3};

        quickSort(vetor, 0, vetor.length - 1);

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}