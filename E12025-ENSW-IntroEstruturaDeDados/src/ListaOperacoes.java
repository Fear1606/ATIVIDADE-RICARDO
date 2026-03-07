public interface ListaOperacoes {

    int removerTodas(String elemento);

    int contar();

    int adicionarVarios(String[] elementos);

    String obter(int indice);

    void inserir(int indice, String elemento);

    void limpar();

    void removerPorIndice(int indice);

}
