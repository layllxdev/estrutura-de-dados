package Atividades;

public class MenorValor {
    public static void main(String[] args){
         int [] vetor = {4,7,9,2,5,1};

         int menor = vetor [0];

         for (int i = 1; i < vetor.length; i++){
             if (vetor [i] < menor){
                 menor = vetor[i];
             }
         }

         System.out.println("O menor número da lista é " + menor);
    }
}
