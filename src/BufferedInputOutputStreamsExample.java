import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BufferedInputOutputStreamsExample {

    private static final Logger LOGGER =
            Logger.getLogger(
                    BufferedInputOutputStreamsExample
                            .class.getName());

    public static void main(String[] args) {
        BufferedInputOutputStreamsExample io = new BufferedInputOutputStreamsExample();

//        io.fileInput();
        io.fileOutput();
    }

    public void fileInput() {
        String inputFileName =
                System.getProperty("user.dir") +
                        File.separator +
                        "inputExample.txt";

        try(FileInputStream fileInputStream =
                    new FileInputStream(
                            new File(inputFileName));
            BufferedInputStream bufferedInputStream =
                    new BufferedInputStream(fileInputStream)) {

            int c;

            while ((c = bufferedInputStream.read()) != -1) {
                System.out.println((char) c);
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    public void fileOutput() {

        String text = "Lorem ipsum 2";

        String outputFileName =
                System.getProperty("user.dir") +
                        File.separator +
                        "outputExample.txt";
        try(FileOutputStream fos =
                new FileOutputStream(outputFileName);
            BufferedOutputStream bos =
                    new BufferedOutputStream(fos)) {

            byte[] buffer = text.getBytes();
            bos.write(buffer);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

}
