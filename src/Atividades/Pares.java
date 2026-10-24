package Atividades;

public class Pares {

    public static void imprimePares(int n){
        if (n < 0) return;
        imprimePares(n - 1);
        if (n % 2 == 0){
            System.out.println(n);
        }
    }

    public static void main(String[] args){
        imprimePares(9);
    }
}
