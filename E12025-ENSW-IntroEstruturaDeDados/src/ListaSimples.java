public class ListaSimples implements ListaOperacoes {
    String [] lista;
    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        System.out.println("Lista criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }

    public void adicionarElemento(String elemento) {
        if(!this.estaCheia()) {
            this.lista[encontrarPosicao()] = elemento;
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
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void removerElemento(String elemento) {
        boolean removido = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    removido = true;
                }
            }
        }
        if(removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
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

        int totalRemovidos = 0; // contador de remoções

        // Se a lista estiver vazia, não há o que remover
        if (estaVazia()) {
            System.out.println("Lista está vazia.");
            return 0;
        }

        // Percorre todas as posições do vetor
        for (int i = 0; i < this.lista.length; i++) {

            // Verifica se a posição contém o elemento
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {

                // Remove colocando null
                this.lista[i] = null;

                totalRemovidos++; // incrementa contador
            }
        }

        return totalRemovidos; // retorna quantos foram removidos
    }
    @Override
    public int contar() {

        // variável que irá guardar a quantidade encontrada
        int total = 0;

        // percorre todo o vetor da lista
        for (int i = 0; i < this.lista.length; i++) {

            // se a posição NÃO estiver vazia
            if(this.lista[i] != null) {

                // aumentamos o contador
                total++;
            }
        }

        // retorna a quantidade total de elementos encontrados
        return total;
    }
    @Override
    public int adicionarVarios(String[] elementos) {

        // contador que irá registrar quantos elementos foram adicionados
        int adicionados = 0;

        // percorremos o vetor recebido como parâmetro
        for(int i = 0; i < elementos.length; i++) {

            // verificamos se ainda existe espaço na lista
            if(!estaCheia()) {

                // usamos o método que já existe para adicionar um elemento
                this.lista[encontrarPosicao()] = elementos[i];

                System.out.println("Elemento " + elementos[i] + " adicionado.");

                // aumentamos o contador
                adicionados++;
            }
            else {
                // se a lista estiver cheia, interrompemos o processo
                System.out.println("Lista cheia. Não foi possível adicionar: " + elementos[i]);
                break;
            }
        }

        // retornamos quantos foram realmente adicionados
        return adicionados;
    }
    /**
     * Retorna o elemento que está na posição informada do vetor.
     */
    @Override
    public String obter(int indice) {

        // verificamos se o índice é inválido
        if(indice < 0 || indice >= this.lista.length) {
            System.out.println("Índice inválido.");
            return null;
        }

        // retornamos o elemento que está naquela posição
        return this.lista[indice];
    }
    @Override
    public boolean inserir(int indice, String elemento) {

        // verifica se índice é inválido
        if(indice < 0 || indice >= lista.length) {
            System.out.println("Índice inválido.");
            return false;
        }

        // verifica se a lista está cheia
        if(estaCheia()) {
            return false;
        }

        // desloca os elementos para a direita
        for(int i = lista.length - 1; i > indice; i--) {
            lista[i] = lista[i - 1];
        }

        // insere o novo elemento na posição desejada
        lista[indice] = elemento;

        System.out.println("Elemento " + elemento + " inserido na posição " + indice);

        return true;
    }
}
