package model;

public class ShellSort<T extends Comparable<T>> {

    private final T[] arr;

    public ShellSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int iterations_counter = 0;
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int j = i;
                while (j >= step && arr[j].compareTo(arr[j - step]) < 0){
                    iterations_counter++;
                    T temp = arr[j];
                    arr[j] = arr[j - step];
                    arr[j - step] = temp;
                    j -= step;
                }
            }
        }
        System.out.print(" Количество итераций: " + iterations_counter + ".");
    }
}
