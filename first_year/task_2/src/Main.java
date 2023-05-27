import model.DbException;
import model.ShellSort;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            sorting();
        } catch (DbException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sorting() throws DbException {
        try {
            InputStream stream = new FileInputStream("data/numbers.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            int counter = 1;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(" ");
                Integer[] arr = new Integer[fields.length];
                for (int i = 0; i < fields.length; i++) {
                    arr[i] = Integer.parseInt(fields[i]);
                }
                System.out.println("Массив №" + counter + " до сортировки:");
                System.out.println(Arrays.toString(arr));
                long start = System.nanoTime();
                new ShellSort<>(arr).sort();
                long finish = System.nanoTime();
                double elapsed = (double) (finish - start) / 1000000;
                System.out.print("Время сортировки: " + elapsed + " мс. " +
                        "Элементов в массиве: " + arr.length + ". ");
                System.out.println("Массив №" + counter + " после сортировки:");
                System.out.println(Arrays.toString(arr));
                System.out.println();
                counter++;
            }
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DbException("Data corrupted.");
        }
    }
}
