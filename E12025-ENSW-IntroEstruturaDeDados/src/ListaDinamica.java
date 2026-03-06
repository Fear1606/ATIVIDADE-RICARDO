public class ListaDinamica implements ListaOperacoes {
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String elemento) {

        if(inicioEstaVazio()) {
            this.inicio.setConteudo(elemento);
        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    public void exibir() {
        if(inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;
//            while(aux != null && aux.getConteudo() != null) {
//                System.out.println(aux.getConteudo());
//                aux = aux.getProx();
//            }

            while(aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            //System.out.println(aux.getConteudo());
        }
    }

    private boolean inicioEstaVazio() {
        if(this.inicio.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    public int removerElemento(String elemento) {
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem removidos.");
        } else {
            if(procurarElemento(elemento)) {
                //remover primeiro elemento isolado
                if(this.inicio.getProx() == null) {
                    System.out.println("Elemento " + elemento + " removido!");
                    this.inicio.setConteudo(null);
                }
                //remover qualquer nó conectado
                else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    while(aux != null) {
                        if (this.inicio.getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido!");
                            this.inicio = this.inicio.getProx();
                            return 0;
                        } else if(aux.getProx().getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido!");
                            aux.setProx(aux.getProx().getProx());
                            return 0;
                        }
                        aux = aux.getProx();
                    }
                }
            }
            int contar; {

                // contador de elementos
                int total = 0;

                // variável auxiliar começa no início da lista
                No aux = this.inicio;

                // percorremos a lista enquanto existir nó
                while(aux != null) {

                    // verificamos se o conteúdo do nó não é null
                    if(aux.getConteudo() != null) {

                        // se existir conteúdo, contamos
                        total++;
                    }

                    // passamos para o próximo nó da lista
                    aux = aux.getProx();
                }

                // retornamos o total de elementos encontrados
                return total;
            }
        }
        return 0;
    }

    public boolean procurarElemento(String elemento) {
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem procurados.");
        } else {
            No aux = this.inicio;
            while(aux != null) {
                if(aux.getConteudo().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado!");
                    return true;
                }
                aux = aux.getProx();
            }
            System.out.println("Elemento " + elemento + " não existe na lista.");
        }
        return false;
    }
    /**
     * Remove todas as ocorrências do elemento na lista dinâmica.
     * Percorre todos os nós ajustando os ponteiros.
     * Retorna a quantidade total removida.
     */
    @Override
    public int removerTodas(String elemento) {

        int totalRemovidos = 0; // contador de remoções

        // Se a lista estiver vazia
        if (inicioEstaVazio()) {
            System.out.println("Lista está vazia.");
            return 0;
        }

        // Remove ocorrências no início da lista
        while (inicio != null &&
                inicio.getConteudo() != null &&
                inicio.getConteudo().equals(elemento)) {

            // Move o início para o próximo nó
            inicio = inicio.getProx();
            totalRemovidos++;
        }

        // Nó auxiliar para percorrer a lista
        No aux = inicio;

        // Percorre enquanto existir próximo nó
        while (aux != null && aux.getProx() != null) {

            // Se o próximo nó contém o elemento
            if (aux.getProx().getConteudo().equals(elemento)) {

                // "Pula" o nó removendo ele da ligação
                aux.setProx(aux.getProx().getProx());
                totalRemovidos++;

            } else {
                // Avança para o próximo nó
                aux = aux.getProx();
            }
        }

        return totalRemovidos; // retorna total removido
    }
    /**
     * Conta quantos elementos existem na lista dinâmica.
     * Para isso percorremos todos os nós da lista.
     */
    @Override
    public int contar() {

        // contador de elementos
        int total = 0;

        // variável auxiliar começa no início da lista
        No aux = this.inicio;

        // percorremos a lista enquanto existir nó
        while(aux != null) {

            // verificamos se o conteúdo do nó não é null
            if(aux.getConteudo() != null) {

                // se existir conteúdo, contamos
                total++;
            }

            // passamos para o próximo nó da lista
            aux = aux.getProx();
        }

        // retornamos o total de elementos encontrados
        return total;
     }
    @Override
    public int adicionarVarios(String[] elementos) {

        // contador de elementos adicionados
        int adicionados = 0;

        // percorremos o vetor recebido
        for(int i = 0; i < elementos.length; i++) {

            // utilizamos o método já existente para adicionar
            adicionarElemento(elementos[i]);

            System.out.println("Elemento " + elementos[i] + " adicionado.");

            // aumentamos o contador
            adicionados++;
        }

        // retornamos quantos elementos foram adicionados
        return adicionados;
    }
    @Override
    public String obter(int indice) {

        // se o índice for negativo já é inválido
        if(indice < 0) {
            System.out.println("Índice inválido.");
            return null;
        }

        // começamos pelo início da lista
        No aux = this.inicio;

        // variável para controlar a posição atual
        int contador = 0;

        // percorremos a lista enquanto existir nó
        while(aux != null) {

            // se chegarmos no índice desejado
            if(contador == indice) {
                return aux.getConteudo();
            }

            // avançamos para o próximo nó
            aux = aux.getProx();

            // aumentamos o contador de posição
            contador++;
        }

        // se terminar o while e não encontrar o índice
        System.out.println("Índice fora do tamanho da lista.");
        return null;
    }
    @Override
    public boolean inserir(int indice, String elemento) {

        // índice inválido
        if(indice < 0) {
            System.out.println("Índice inválido.");
            return false;
        }

        No novoNo = new No(elemento);

        // inserir no início da lista
        if(indice == 0) {

            novoNo.setProx(inicio);
            inicio = novoNo;

            System.out.println("Elemento " + elemento + " inserido no início da lista.");

            return true;
        }

        No aux = inicio;
        int contador = 0;

        // percorremos a lista até a posição anterior ao índice
        while(aux != null && contador < indice - 1) {

            aux = aux.getProx();
            contador++;
        }

        // se não encontrou posição válida
        if(aux == null) {
            System.out.println("Índice fora do tamanho da lista.");
            return false;
        }

        // ajustamos os ponteiros dos nós
        novoNo.setProx(aux.getProx());
        aux.setProx(novoNo);

        System.out.println("Elemento " + elemento + " inserido na posição " + indice);

        return true;
    }
}

