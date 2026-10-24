package Atividades;

public class SomaVetores {

    public static int somaVetores(int [] v, int i){
        if ( i == v.length) return 0;
        return v[i] + somaVetores(v,i+1);
    }

    public static void main(String[] args){
        int [] numeros = {4,1,6,7,3};
        System.out.println(somaVetores(numeros, 0));
    }
}

