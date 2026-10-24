package Atividades;

public class SelectionSort {

    public static void main(String [] args){
        int [] numeros = {2,5,6,7,1,8};

        for (int i=0; i < numeros.length; i++){
            int menor = i;

            for (int j= i+1; j < numeros.length; j++){

                if (numeros[j] < numeros[menor]){
                    menor = j;
                }
            }

            int temp = numeros[i];
            numeros[i] = numeros[menor];
            numeros[menor] = temp;
        }

        for (int i=0; i < numeros.length; i++){
            System.out.println(numeros[i] + "");
        }

    }
}
