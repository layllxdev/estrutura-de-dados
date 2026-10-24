package Atividades;

public class TabelaHash {

    ListaPar[] tabela;
    int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ListaPar[tamanho];

        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaPar();
        }
    }

    private int hash(int matricula) {
        return matricula % tamanho;
    }

    public String pegarValor(int matricula) {
        int posicao = hash(matricula);

        Par par = tabela[posicao].buscar(matricula);

        if (par != null) {
            return par.nome;
        }

        return null;
    }

    public void inserirValor(int matricula, String nome) {
        int posicao = hash(matricula);

        Par par = new Par(matricula, nome);

        tabela[posicao].add(par);
    }

    public void removerValor(int matricula) {
        int posicao = hash(matricula);

        tabela[posicao].remover(matricula);
    }
}