import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReaderWriterExample {

    private static final Logger LOGGER =
            Logger.getLogger(
                    FileReaderWriterExample
                            .class.getName());

    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        String inputFileName =
                System.getProperty("user.dir") +
                        File.separator +
                        "inputExample.txt";
        String outputFileName =
                System.getProperty("user.dir") +
                        File.separator +
                        "outputExample.txt";
        try {
            fileReader =
                    new FileReader(inputFileName);
            fileWriter =
                    new FileWriter(outputFileName);
            // Если 2 параметр true то файл будет дозаписываться
//            fileWriter =
//                    new FileWriter("", true);
            BufferedReader br = new BufferedReader(fileReader);
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                fileWriter.write(line +
                System.getProperty("line.separator"));
            }


        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File not found", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, null, e);
            }
        }
    }

}
