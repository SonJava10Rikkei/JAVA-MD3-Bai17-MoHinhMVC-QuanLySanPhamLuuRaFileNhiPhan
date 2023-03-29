package rikkei.academmy.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    public static final String PATH_CATEGORY = "C:\\Users\\icom\\Desktop\\Workspace_JAVA\\JAVA-MD3-Bai17\\JAVA-MD3-Bai17-TrenLop\\src\\rikkei\\academmy\\database\\category.txt";

    public static Scanner scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }


// B1 Xay phuong thuc doc file voi tham so generic

    public List<T> readFromFile(String path) {
        List<T> tList = new ArrayList<>();
        try {
// doc vao
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException f) {
            System.err.println("File Not Found !");
        } catch (IOException i) {
            System.err.println("IOE Exception !");
        } catch (ClassNotFoundException c) {
            System.err.println("Class not Found");
        }
        return tList;
    }

    // B2 Xay phuong thuc ghi file voi tham so generic
    public void writeToFile(String pathFile, List<T> tList) {
        // Ghi ra
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException f) {
            System.err.println("File not found");
        } catch (IOException i) {
            System.err.println("IOE Exception");
        }

    }
}
