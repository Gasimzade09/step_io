import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileInputOutputStreamsExample {

    private static final Logger LOGGER =
            Logger.getLogger(
                    FileInputOutputStreamsExample
                            .class.getName());

    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        byte[] buffer = null;

        String inputFileName =
                System.getProperty("user.dir") +
                        File.separator +
                        "inputExample.txt";

        String outputFileName =
                System.getProperty("user.dir") +
                        File.separator +
                        "outputExample.txt";


//        inputStream = new FileInputStream(inputFileName);
        try {
            inputStream =
                    new FileInputStream(
                            new File(inputFileName));
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            System.out.println(buffer);
            outputStream = new FileOutputStream(
                    new File(outputFileName));
            outputStream.write(buffer);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE,
                    "File not found", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,
                    null, e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE,
                        null, e);
            }
        }

    }

    public void dataInputStreamExamle() throws IOException {
        FileInputStream fileInputStream =
                new FileInputStream("example.txt");
        DataInputStream dataInputStream =
                new DataInputStream(fileInputStream);
        double x = dataInputStream.readDouble();
    }

}
