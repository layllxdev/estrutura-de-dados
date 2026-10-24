package Atividades;

class Nodo2 {
    int valor;
    Nodo2 ant;
    Nodo2 prox;

    public Nodo2(int valor) {
        this.valor = valor;
        this.ant = null;
        this.prox = null;
    }
}

class ListaDuplamenteEncadeada {
    Nodo2 primeiro;
    int tamanho;

    public ListaDuplamenteEncadeada() {
        primeiro = null;
        tamanho = 0;
    }

    public int size() {
        return tamanho;
    }

    public void add(int elemento) {
        Nodo2 novo = new Nodo2(elemento);

        if (primeiro == null) {
            primeiro = novo;
        } else {
            Nodo2 atual = primeiro;

            while (atual.prox != null) {
                atual = atual.prox;
            }

            atual.prox = novo;
            novo.ant = atual;
        }

        tamanho++;
    }

    public Nodo2 get(int index) {
        if (index < 0 || index >= tamanho) {
            return null;
        }

        Nodo2 atual = primeiro;

        for (int i = 0; i < index; i++) {
            atual = atual.prox;
        }

        return atual;
    }

    public void add(int index, int elemento) {
        if (index < 0 || index > tamanho) {
            return;
        }

        Nodo2 novo = new Nodo2(elemento);

        if (index == 0) {
            novo.prox = primeiro;

            if (primeiro != null) {
                primeiro.ant = novo;
            }

            primeiro = novo;
        } else {
            Nodo2 atual = get(index - 1);

            novo.prox = atual.prox;
            novo.ant = atual;

            if (atual.prox != null) {
                atual.prox.ant = novo;
            }

            atual.prox = novo;
        }

        tamanho++;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            return;
        }

        Nodo2 removido = get(index);

        if (index == 0) {
            primeiro = removido.prox;

            if (primeiro != null) {
                primeiro.ant = null;
            }
        } else {
            removido.ant.prox = removido.prox;

            if (removido.prox != null) {
                removido.prox.ant = removido.ant;
            }
        }

        tamanho--;
    }
}
