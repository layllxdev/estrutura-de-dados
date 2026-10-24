package Atividades;

public class ListaPar {

    static class Nodo {
        Par valor;
        Nodo prox;

        public Nodo(Par valor) {
            this.valor = valor;
            this.prox = null;
        }
    }

    Nodo primeiro;
    int tamanho;

    public ListaPar() {
        primeiro = null;
        tamanho = 0;
    }

    public void add(Par elemento) {
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

    public Par buscar(int matricula) {
        Nodo atual = primeiro;

        while (atual != null) {
            if (atual.valor.matricula == matricula) {
                return atual.valor;
            }

            atual = atual.prox;
        }

        return null;
    }

    public void remover(int matricula) {
        if (primeiro == null) {
            return;
        }

        if (primeiro.valor.matricula == matricula) {
            primeiro = primeiro.prox;
            tamanho--;
            return;
        }

        Nodo atual = primeiro;

        while (atual.prox != null) {
            if (atual.prox.valor.matricula == matricula) {
                atual.prox = atual.prox.prox;
                tamanho--;
                return;
            }

            atual = atual.prox;
        }
    }
}