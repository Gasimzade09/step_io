import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

public class FilesClassExample {

    public void example() {
        String inputFileName =
                System.getProperty("user.dir") +
                        File.separator +
                        "image.jpg";

        String outputFileName =
                System.getProperty("user.dir") +
                        File.separator +
                        "outputImage.jpg";

        Path path = Paths.get(inputFileName);
        Path outPath = Paths.get(outputFileName);

        try {
            byte[] bytes = Files.readAllBytes(path);
//            List<String> strings = Files.readAllLines(path);
//            System.out.println(strings);

//            String content = new String(bytes, "UTF-8");
            Files.write(outPath, bytes);
//            System.out.println(content);
//            Files.createDirectory(path);
//            Files.createFile(path);
//            Files.copy(fromPath, toPath);
//            Files.move(fromPath, toPath);
            Files.delete(path);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        String listNames =
                System.getProperty("user.dir");

        FilesClassExample filesClassExample =
                new FilesClassExample();

        filesClassExample.listAllFiles(listNames);

    }

    public void listAllFiles(String path) throws IOException {

        String inputFolderPath =
                System.getProperty("user.dir") +
                        File.separator +
                        "src";

        String outputFolderPath =
                System.getProperty("user.dir") +
                        File.separator +
                        "outputExample";

        Path outputPath = Paths.get(outputFolderPath);

        Files.copy(Paths.get(inputFolderPath), outputPath, StandardCopyOption.REPLACE_EXISTING);

        try(Stream<Path> paths = Files.walk(Paths.get(inputFolderPath))) {
           paths.forEach(filePath -> {

               try {
                   List<String> list = Files.readAllLines(filePath);
                    list.forEach(s -> {
                        System.out.println(s);
                    });
               } catch (IOException e) {
                   e.printStackTrace();
               }

           });

        } catch (IOException e) {

        }
    }

}
