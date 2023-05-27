package model;

public class ShellSort<T extends Comparable<T>> {

    private final T[] arr;

    public ShellSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int iterations_counter = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        for (int step = arr.length / 2; step > 0; step /= 2) {
            x++;
            iterations_counter += y;
            y = 0;
            for (int i = step; i < arr.length; i++) {
                y++;
                iterations_counter += z;
                z = 0;
                int j = i;
                while (j >= step && arr[j].compareTo(arr[j - step]) < 0){
                    z++;
                    T temp = arr[j];
                    arr[j] = arr[j - step];
                    arr[j - step] = temp;
                    j -= step;
                }
            }
        }
        iterations_counter += x;
        System.out.print(" Количество итераций: " + iterations_counter + ".");
    }
}
