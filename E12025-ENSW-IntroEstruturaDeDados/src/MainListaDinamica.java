public class MainListaDinamica {

    public static void main(String[] args) {

        ListaDinamica listaDinamica = new ListaDinamica();

// Adicionando elementos
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Batata");
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Arroz");

        System.out.println("\nLista antes da remoção:");
        listaDinamica.exibir();

// Chamando o novo método da interface
        int totalRemovidos = listaDinamica.removerTodas("Arroz");

        System.out.println("\nTotal removido: " + totalRemovidos);

        System.out.println("\nLista depois da remoção:");
        listaDinamica.exibir();

        System.out.println("Total de elementos na lista dinâmica: " + listaDinamica.contar());

        String[] novosElementos = {"Macarrão", "Leite", "Café"};

        int total = listaDinamica.adicionarVarios(novosElementos);

        System.out.println("Total de elementos adicionados: " + total);

        System.out.println("Total de elementos na lista dinâmica: " + listaDinamica.contar());

        listaDinamica.exibir();

//QUESTÃO 4
        System.out.println("Elemento na posição 0: " + listaDinamica.obter(0));

//QUESTÃO 5

        listaDinamica.inserir(1, "Bife");

        listaDinamica.exibir();

        //QUESTÃO 6
        listaDinamica.removerPorIndice(1);

        listaDinamica.exibir();

        listaDinamica.limpar();
        listaDinamica.exibir();
    }


}