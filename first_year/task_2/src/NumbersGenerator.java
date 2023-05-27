import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import model.DbException;

public class NumbersGenerator {
    public static void main(String[] args) throws DbException {
        try {
            try {
                OutputStream stream = new FileOutputStream("data/numbers.txt", false);
                PrintStream printStream = new PrintStream(stream);
                for (int i = 0; i < 50; i++) {
                    int count = getCount();
                    for (int j = 0; j < count; j++) {
                        printStream.print(getNum());
                        printStream.print(" ");
                    }
                    printStream.println();
                }
            } catch (FileNotFoundException e) {
                throw new DbException("File not found");
            }
        } catch (DbException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getCount() {
        return (int) (Math.random() * 9901) + 100;
    }

    public static int getNum() {
        return (int) (Math.random() * 20001) - 10000;
    }
}
