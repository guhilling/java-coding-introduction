package de.hilling.chess;

import java.util.List;

import org.jspecify.annotations.NonNull;

/**
 * Provide the static {@link Sort#sort(List)} function.
 */
public class Sort {
    private static boolean debug;

    // Never instantiated.
    private Sort() {}

    public static void setDebug(boolean debug) {
        Sort.debug = debug;
    }

    /**
     * Sort the given List inplace.
     *
     * @param elements comparable non-null Objects.
     * @param <T>      Type implementing {@link Comparable}.
     * @return
     *
     */
    public static @NonNull <T extends Comparable<T>> List<@NonNull T> sort(@NonNull List<@NonNull T> elements) {
        print(elements);
        quickSort(elements, 0, elements.size() -1);
        return elements;
    }

    private static <T extends Comparable<T>> void quickSort(@NonNull List<@NonNull T> elements, int left, int right) {
        if(unsorted(elements, left, right)) {
            print("quicksort: " + (left+1) + ", " + (right+1));
            int partitionIndex = partition(elements, left, right);
            quickSort(elements, left, partitionIndex - 1);
            quickSort(elements, partitionIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>> boolean unsorted(@NonNull List<T> elements, int left, int right) {
        if(left >= right) {
            return false;
        }
        for(int index = left; index <= right; index++) {
            if(elements.get(index).compareTo(elements.get(right)) > 0) {
                return true;
            }
        }
        return false;
    }

    private static <T extends Comparable<T>> int partition(@NonNull List<@NonNull T> elements, int left, int right) {
        T pivot = elements.get(right);
        print("piv " + pivot + " " + elements);
        int i = (left - 1);

        for (int j = left; j < right; j++) {
            if(elements.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(elements, i, j);
            }
        }
        print("move pivot element to " + (i + 1));
        swap(elements, i + 1, right);
        return i + 1;
    }

    private static <T extends Comparable<T>> void swap(@NonNull List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
        print((i+1) + "<->" + (j+1) + " " + elements);
    }

    private static void print(Object output) {
        if(debug) {
            System.out.println(output);
        }
    }
}
