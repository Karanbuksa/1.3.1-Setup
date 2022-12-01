import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File src = new File("D:\\Games\\src");
        File res = new File("D:\\Games\\res");
        File savegames = new File("D:\\Games\\savegames");
        File temp = new File("D:\\Games\\temp");
        File tempFile = new File(temp, "temp.txt");
        File main = new File("D:\\Games\\src\\main");
        File mainFile = new File(main, "Main.java");
        File utilsFile = new File(main, "Utils.java");
        File test = new File("D:\\Games\\src\\test");
        File drawables = new File("D:\\Games\\res\\drawables");
        File vectors = new File("D:\\Games\\res\\vectors");
        File icons = new File("D:\\Games\\res\\icons");
        StringBuilder stringBuilder = new StringBuilder();

        writeDir(src, stringBuilder);
        writeDir(res, stringBuilder);
        writeDir(savegames, stringBuilder);
        writeDir(temp, stringBuilder);
        writeDir(main, stringBuilder);
        writeDir(test, stringBuilder);
        writeDoc(mainFile, stringBuilder);
        writeDoc(utilsFile, stringBuilder);
        writeDir(drawables, stringBuilder);
        writeDir(vectors, stringBuilder);
        writeDir(icons, stringBuilder);
        writeDoc(tempFile,stringBuilder);
        try(FileWriter fileWriter = new FileWriter(tempFile)) {
            fileWriter.write(String.valueOf(stringBuilder));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeDir(File file, StringBuilder str) {
        if (file.mkdir()) {
            str.append("Директория ").append(file.getName()).append(" создана\n");
        } else {
            str.append("Не удалось создать директорию ").append(file.getName()).append("\n");
        }
    }

    public static void writeDoc(File doc, StringBuilder str) {
        try {
            if (doc.createNewFile()) {
                str.append("Файл ").append(doc.getName()).append(" создан\n");
            } else {
                str.append("Не удалось создать файл").append(doc.getName());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

