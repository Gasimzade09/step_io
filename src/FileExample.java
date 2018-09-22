import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) {
        FileExample fileExample = new FileExample();
        fileExample.fileCreationExample();
//        fileExample.folderCreationExample();
    }

    public void fileCreationExample() {
        String fileName = "example.txt";
        String dirName = System.getProperty("user.dir");
//        Одно и тоже
//        String dirName = "C:\\Users\\taghiyevr\\IdeaProjects\\io";
        String fullName = dirName + File.separator + fileName;
        System.out.println(fullName);

        File file = new File(fullName);

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists");
        }

//        file.deleteOnExit();
        file.setReadOnly();
        long freeSpace = file.getFreeSpace();
        long totalSpace = file.getTotalSpace();
        long freeSpaceInGb = freeSpace/1024/1024/1024;
        System.out.println(freeSpaceInGb);
        System.out.println(totalSpace);

    }

    public void folderCreationExample() {

        String dirName = System.getProperty("user.dir");

        String folderDirName =
                dirName + "\\src\\example\\1";

        File file = new File(folderDirName);

        file.mkdirs();

    }

}
