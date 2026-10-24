package Atividades;

class Nodo3 {
    int valor;
    Nodo3 ant;
    Nodo3 prox;

    public Nodo3(int valor) {
        this.valor = valor;
        this.ant = null;
        this.prox = null;
    }
}

class ListaDuplamenteEncadeadaCircular {
    private Nodo3 primeiro;
    private int tamanho;

    public ListaDuplamenteEncadeadaCircular() {
        primeiro = null;
        tamanho = 0;
    }

    public int size() {
        return tamanho;
    }

    public void add(int elemento) {
        Nodo3 novo = new Nodo3(elemento);

        if (primeiro == null) {
            primeiro = novo;
            novo.prox = novo;
            novo.ant = novo;
        } else {
            Nodo3 ultimo = primeiro.ant;

            novo.prox = primeiro;
            novo.ant = ultimo;

            ultimo.prox = novo;
            primeiro.ant = novo;
        }

        tamanho++;
    }

    public Nodo3 get(int index) {
        if (index < 0 || index >= tamanho) {
            return null;
        }

        Nodo3 atual = primeiro;

        for (int i = 0; i < index; i++) {
            atual = atual.prox;
        }

        return atual;
    }

    public void add(int index, int elemento) {
        if (index < 0 || index > tamanho) {
            return;
        }

        if (index == tamanho) {
            add(elemento);
            return;
        }

        Nodo3 atual = get(index);
        Nodo3 novo = new Nodo3(elemento);

        novo.prox = atual;
        novo.ant = atual.ant;

        atual.ant.prox = novo;
        atual.ant = novo;

        if (index == 0) {
            primeiro = novo;
        }

        tamanho++;
    }

    public Nodo3 remove(int index) {
        if (index < 0 || index >= tamanho) {
            return null;
        }

        Nodo3 removido = get(index);

        if (tamanho == 1) {
            primeiro = null;
        } else {
            removido.ant.prox = removido.prox;
            removido.prox.ant = removido.ant;

            if (index == 0) {
                primeiro = removido.prox;
            }
        }

        tamanho--;

        return removido;
    }
}