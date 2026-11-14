package Atividades;

public class ArvoreAVL {

    class NoAVL {
        int valor;
        int altura;
        NoAVL esquerda;
        NoAVL direita;

        NoAVL(int valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }

    NoAVL raiz;

    int altura(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    int fatorBalanceamento(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerda) - altura(no.direita);
    }

    NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda),
                altura(y.direita)) + 1;

        x.altura = Math.max(altura(x.esquerda),
                altura(x.direita)) + 1;

        return x;
    }

    NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda),
                altura(x.direita)) + 1;

        y.altura = Math.max(altura(y.esquerda),
                altura(y.direita)) + 1;

        return y;
    }

    public void adicionar(int valor) {
        raiz = adicionarRecursivo(raiz, valor);
    }

    NoAVL adicionarRecursivo(NoAVL no, int valor) {

        if (no == null) {
            return new NoAVL(valor);
        }

        if (valor < no.valor) {
            no.esquerda = adicionarRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = adicionarRecursivo(no.direita, valor);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(
                altura(no.esquerda),
                altura(no.direita)
        );

        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && valor < no.esquerda.valor) {
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && valor > no.direita.valor) {
            return rotacaoEsquerda(no);
        }

        if (balanceamento > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void emOrdem(NoAVL no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }

    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        arvore.adicionar(10);
        arvore.adicionar(20);
        arvore.adicionar(30);
        arvore.adicionar(40);
        arvore.adicionar(50);
        arvore.adicionar(25);

        System.out.print("Em-ordem: ");
        arvore.emOrdem(arvore.raiz);
    }
}
