package Atividades;

public class ListaEncadeada {

    class Nodo {
        int valor;
        Nodo prox;

        public Nodo(int valor) {
            this.valor = valor;
            this.prox = null;
        }
    }

    Nodo primeiro;
    int tamanho;

    public ListaEncadeada() {
        primeiro = null;
        tamanho = 0;
    }

    public int size() {
        return tamanho;
    }

    public void add(int elemento) {
        Nodo novo = new Nodo(elemento);

        if (primeiro == null) {
            primeiro = novo;
        } else {
            Nodo atual = primeiro;

            while (atual.prox != null) {
                atual = atual.prox;
            }

            atual.prox = novo;
        }

        tamanho++;
    }

    public Nodo get(int index) {
        if (index < 0 || index >= tamanho) {
            return null;
        }

        Nodo atual = primeiro;

        for (int i = 0; i < index; i++) {
            atual = atual.prox;
        }

        return atual;
    }

    public void add(int index, int elemento) {
        if (index < 0 || index > tamanho) {
            return;
        }

        Nodo novo = new Nodo(elemento);

        if (index == 0) {
            novo.prox = primeiro;
            primeiro = novo;
        } else {
            Nodo anterior = get(index - 1);

            novo.prox = anterior.prox;
            anterior.prox = novo;
        }

        tamanho++;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            return;
        }

        if (index == 0) {
            primeiro = primeiro.prox;
        } else {
            Nodo anterior = get(index - 1);
            anterior.prox = anterior.prox.prox;
        }

        tamanho--;
    }
}