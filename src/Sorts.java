public class Sorts {
    public static void bubbleSort(int[] lista) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista[j] < lista[j + 1]) {
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] lista) {
        if (lista == null || lista.length == 0) {
            return;
        }
        quickSort(lista, 0, lista.length - 1);
    }

    private static void quickSort(int[] lista, int cima, int baixo) {
        int i = cima;
        int j = baixo;
        int pivo = lista[baixo + (cima - baixo) / 2];
        while (i <= j) {
            while (lista[i] < pivo) {
                i++;
            }
            while (lista[j] > pivo) {
                j--;
            }
            if (i <= j) {
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
                i++;
                j--;
            }
        }
        if (baixo < j) {
            quickSort(lista, baixo, j);
        }
        if (i < cima) {
            quickSort(lista, i, cima);
        }
    }
}

class Ordem {
    public static void main(String[] args) {
        int[] lista = {31, 433, 634, 23, 53, 6, 2, 1, 5, 7, 53, 562, 26, 262, 6, 2, 62, 141424};

        // Ordena pelo Bubble Sort
        Sorts.bubbleSort(lista);
        System.out.println("NÚMEROS EM ORDEM PELO BUBBLE SORT:");
        for (int num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Ordena pelo Quick Sort
        int[] lista2 = {31, 433, 634, 23, 53, 6, 2, 1, 5, 7, 53, 562, 26, 262, 6, 2, 62, 141424};
        Sorts.quickSort(lista2);
        System.out.println("NÚMEROS EM ORDEM PELO QUICK SORT:");
        for (int num : lista2) {
            System.out.print(num + " ");
        }
    }
}
