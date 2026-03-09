public interface ListaOperacoes {

    int removerTodas(String elemento);

    int contar();

    int adicionarVarios(String[] elementos);

    String obter(int indice);

    boolean inserir(int indice, String elemento);

    void limpar();

    String removerPorIndice(int indice);

    int ultimoIndiceDe(String elemento);

    int contarOcorrencias(String elemento);

    int substituir(String antigo, String novo);
}
