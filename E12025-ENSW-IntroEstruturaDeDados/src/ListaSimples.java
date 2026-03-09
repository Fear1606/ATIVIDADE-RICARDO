public class ListaSimples implements ListaOperacoes {
    String [] lista;
    int tamanho;
    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        this.tamanho = 0;
        System.out.println("Lista criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }

    public void adicionarElemento(String elemento) {
        if(!this.estaCheia()) {
            this.lista[encontrarPosicao()] = elemento;
            tamanho++;
            System.out.println("Elemento " + elemento + "  adicionado com sucesso!");
        }
    }

    public boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if(this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("Não há espaço disponível na lista.");
        return true;
    }

    public boolean estaVazia() {
        for (int i = 0; i < this.lista.length; i++) {
            if(this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }

    private int encontrarPosicao() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if(this.lista[i] == null) {
                break;
            }
        }
        return i;
    }

    public void exibirElementos() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void removerElemento(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                // Move para esquerda os elementos.
                for (int j = i; j < tamanho - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[tamanho - 1] = null;
                tamanho--;
                System.out.println("Elemento removido");
                return;
            }
        }
        System.out.println("Elemento não encontrado");
    }

    public void buscarElemento(String elemento) {
        boolean encontrado = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }
        if(encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }
    /**
     * Percorre todo o vetor e remove TODAS as ocorrências
     * do elemento informado.
     * Cada vez que encontra, coloca null na posição.
     * Retorna quantos foram removidos.
     */
    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        int i = 0;
        while (i < tamanho) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                // Desloca
                for (int j = i; j < tamanho - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[tamanho - 1] = null;
                tamanho--;
                removidos++;
            } else {
                i++;
            }
        }
        return removidos;
    }

    @Override
    public int contar() {
        //A variavel tamanho armazena a quantidades de itens na lista.
        return tamanho;
    }
    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for (int i = 0; i < elementos.length && tamanho < lista.length; i++) {
            lista[tamanho] = elementos[i];
            tamanho++;
            adicionados++;
        }
        return adicionados;
    }
    /**
     * Retorna o elemento que está na posição informada do vetor.
     */
    @Override
    public String obter(int indice) {

        // verificamos se o índice é inválido
        if(indice < 0 || indice >= tamanho) {
            System.out.println("Índice inválido.");
            return null;
        }

        // retornamos o elemento que está naquela posição
        return this.lista[indice];
    }
    @Override
    public boolean inserir(int indice, String elemento) {

        // verifica se índice é inválido
        if(indice < 0 || indice > tamanho) {
            System.out.println("Índice inválido.");
            return false;
        }

        // verifica se a lista está cheia
        if(estaCheia()) {
            return false;
        }

        // desloca os elementos para a direita
        for(int i = tamanho - 1; i > indice; i--) {
            lista[i] = lista[i - 1];
        }

        // insere o novo elemento na posição desejada
        lista[indice] = elemento;

        System.out.println("Elemento " + elemento + " inserido na posição " + indice);
        tamanho++;
        return true;
    }

    /**
     * Remove o elemento localizado em uma posição específica da lista.
     *
     * No vetor, os elementos à direita devem ser deslocados para
     * preencher o espaço. Na lista encadeada, deve-se ajustar os
     * ponteiros entre os nós.
     *
     * @param indice Posição do elemento a ser removido.
     * @return Elemento removido ou null caso o índice seja inválido.
     */
    @Override
    public String removerPorIndice(int indice) {
        if(indice < 0 || indice>= tamanho){
            return null;
        }
        String elementoRemovido = lista[indice];

        //Move os elementos para esquerda
        for (int i = indice; i < tamanho -1; i++) {
            lista[i] = lista[i+1];
        }
        lista[tamanho -1] = null;
        tamanho--;
        return elementoRemovido;
    }

    /**
     * Remove todos os elementos da lista, deixando-a vazia.
     *
     * No caso da lista baseada em vetor, apenas o tamanho lógico
     * deve ser resetado. Na lista dinâmica, os nós devem ser
     * desconectados para permitir a coleta de lixo.
     */
    public void limpar(){
        for (int i = 0; i < tamanho; i++) {
            lista[i] = null;
        }
        tamanho = 0;
    }

    /**
     * Retorna o índice da última ocorrência de um elemento na lista.
     *
     * @param elemento Elemento a ser buscado.
     * @return Índice da última ocorrência ou -1 caso não exista.
     */
    public int ultimoIndiceDe(String elemento){
        for (int i = tamanho - 1; i >= 0; i--) {  // Percorre do final para o começo
            if (lista[i] != null && lista[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Conta quantas vezes um determinado elemento aparece na lista.
     *
     * @param elemento Elemento a ser contado.
     * @return Número de ocorrências do elemento.
     */
    public int contarOcorrencias(String elemento){
        int numOcorrencias = 0;
        for (int i = 0; i < tamanho; i++) {
            if (lista[i] != null && lista[i].equals(elemento)){
                numOcorrencias++;
            }
        }
        return numOcorrencias;
    }

    /**
     * Substitui todas as ocorrências de um elemento antigo por um novo elemento.
     *
     * Exemplo:
     * Lista: ["Ana", "Carlos", "Ana"]
     * substituir("Ana", "Maria")
     * Resultado: ["Maria", "Carlos", "Maria"]
     *
     * @param antigo Elemento que será substituído.
     * @param novo Novo valor que substituirá o antigo.
     * @return Quantidade total de substituições realizadas.
     */
    public int substituir(String antigo, String novo){
        int numSubstituicoes = 0;
        for (int i = 0; i < tamanho; i++) {
            if (lista[i] != null && lista[i].equals(antigo)){
                lista[i] = novo;
                numSubstituicoes++;
            }
        }
        return numSubstituicoes;
    }
}