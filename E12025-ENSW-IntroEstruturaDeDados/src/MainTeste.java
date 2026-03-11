public class MainTeste {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.adicionarElemento("A");
        lista.adicionarElemento("B");
        lista.adicionarElemento("A");
        lista.adicionarElemento("C");

        lista.exibir();
        System.out.println(lista.ultimoIndiceDe("A"));

        System.out.println(lista.contarOcorrencias("A"));
        lista.substituir("A","B");
        lista.exibir();
    }
}
