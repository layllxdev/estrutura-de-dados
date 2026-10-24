package Atividades;

public class TabelaHash2 {
    private Par[] tabela;
    private int tamanho;
    private final Par APAGADO = new Par(-1, "APAGADO");

    public TabelaHash2() {
        tabela = new Par[5];
        tamanho = 0;
    }

    private int hash(int matricula) {
        return Math.abs(matricula % tabela.length);
    }

    public String pegarValor(int matricula) {
        int posicao = hash(matricula);
        int inicio = posicao;

        while (tabela[posicao] != null) {
            if (tabela[posicao] != APAGADO
                    && tabela[posicao].getMatricula() == matricula) {
                return tabela[posicao].getNome();
            }

            posicao = (posicao + 1) % tabela.length;

            if (posicao == inicio) {
                break;
            }
        }

        return null;
    }

    public void inserirValor(int matricula, String valor) {
        if ((tamanho + 1.0) / tabela.length > 0.7) {
            redimensionar();
        }

        int posicao = hash(matricula);
        int apagado = -1;

        while (tabela[posicao] != null) {
            if (tabela[posicao] != APAGADO
                    && tabela[posicao].getMatricula() == matricula) {
                tabela[posicao] = new Par(matricula, valor);
                return;
            }

            if (tabela[posicao] == APAGADO && apagado == -1) {
                apagado = posicao;
            }

            posicao = (posicao + 1) % tabela.length;
        }

        if (apagado != -1) {
            posicao = apagado;
        }

        tabela[posicao] = new Par(matricula, valor);
        tamanho++;
    }

    public void removerValor(int matricula) {
        int posicao = hash(matricula);
        int inicio = posicao;

        while (tabela[posicao] != null) {
            if (tabela[posicao] != APAGADO
                    && tabela[posicao].getMatricula() == matricula) {
                tabela[posicao] = APAGADO;
                tamanho--;
                return;
            }

            posicao = (posicao + 1) % tabela.length;

            if (posicao == inicio) {
                break;
            }
        }
    }

    private void redimensionar() {
        Par[] antiga = tabela;
        tabela = new Par[antiga.length * 2];
        tamanho = 0;

        for (Par par : antiga) {
            if (par != null && par != APAGADO) {
                inserirSemRedimensionar(par);
            }
        }
    }

    private void inserirSemRedimensionar(Par par) {
        int posicao = hash(par.getMatricula());

        while (tabela[posicao] != null) {
            posicao = (posicao + 1) % tabela.length;
        }

        tabela[posicao] = par;
        tamanho++;
    }
}
