public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);

        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Sabão em Pó");
        listaSimples.adicionarElemento("Papel Higiênico");
        listaSimples.adicionarElemento("Óleo");
        listaSimples.buscarElemento("Óleo");
        listaSimples.removerElemento("Óleo");
        listaSimples.buscarElemento("Óleo");
        listaSimples.exibirElementos();

// Testando removerTodas
        int removidos = listaSimples.removerTodas("Arroz");
        System.out.println("Total removido: " + removidos);

        listaSimples.exibirElementos();

        System.out.println("Total de elementos na lista: " + listaSimples.contar());

        //QUESTÃO 4
        String[] novos = {"Açúcar", "Sal", "Farinha"};

        int totalAdicionados = listaSimples.adicionarVarios(novos);

        System.out.println("Total adicionados: " + totalAdicionados);

        //QUESTÃO 4
        //QUESTÃO 5
        System.out.println("Elemento na posição 2: " + listaSimples.obter(2));

        //QUESTÃO 6
        listaSimples.removerPorIndice(2);

        listaSimples.exibirElementos();

        listaSimples.limpar();

        listaSimples.exibirElementos();
    }
}
