import java.io.*;
import java.util.Scanner;

public class SystemExample {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(
                     System.in
                ));
        String line = reader.readLine();
        System.out.println(line);

    }

    public void example() throws FileNotFoundException {
        System.setOut(new PrintStream(
                new FileOutputStream("example.txt")
        ));
        System.out.println("asdadasda");
    }

}
