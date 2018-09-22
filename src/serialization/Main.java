package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unchecked")
public class Main {

    private static final Logger LOGGER =
            Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        String fileName =
                System.getProperty("user.dir") +
                        File.separator +
                        "serializedFile.txt";

        Main main = new Main();

        main.serialize(fileName);
        main.deserialize(fileName);
    }

    public void serialize(String fileName) {
        User user = new User(1, "John");

        try (FileOutputStream fileOutputStream =
                new FileOutputStream(fileName)) {

            ObjectOutputStream objectOutputStream =
            new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(user);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    public void deserialize(String fileName) {

        User user = null;

        try (FileInputStream is =
            new FileInputStream(fileName)) {
            ObjectInputStream ois =
                    new ObjectInputStream(is);

            user = (User) ois.readObject();

        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception", e);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "class not found", e);
        }

        System.out.println(user);
    }

    public <T extends Serializable> T deserializeWithGenerics(String fileName) {

        T user = null;

        try (FileInputStream is =
                     new FileInputStream(fileName)) {
            ObjectInputStream ois =
                    new ObjectInputStream(is);

            user = (T) ois.readObject();

        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception", e);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "class not found", e);
        }

        System.out.println(user);
        return user;
    }

}
