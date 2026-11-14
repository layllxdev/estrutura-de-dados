package Atividades;

public class PercursosArvore {

    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.adicionar(50);
        arvore.adicionar(30);
        arvore.adicionar(70);
        arvore.adicionar(20);
        arvore.adicionar(40);

        System.out.print("Pre-ordem: ");
        preOrdem(arvore.raiz);

        System.out.print("\nEm-ordem: ");
        emOrdem(arvore.raiz);

        System.out.print("\nPos-ordem: ");
        posOrdem(arvore.raiz);
    }

    public static void preOrdem(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdem(raiz.esquerda);
            preOrdem(raiz.direita);
        }
    }

    public static void emOrdem(No raiz) {
        if (raiz != null) {
            emOrdem(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdem(raiz.direita);
        }
    }

    public static void posOrdem(No raiz) {
        if (raiz != null) {
            posOrdem(raiz.esquerda);
            posOrdem(raiz.direita);
            System.out.print(raiz.valor + " ");
        }
    }
}
