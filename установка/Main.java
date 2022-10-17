import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();


        sb.append(createSrc());
        sb.append(createRes());
        sb.append(createSaveGames());
        sb.append(createTemp());

        try(FileWriter writer = new FileWriter("C:\\GAMES\\temp\\temp.txt", false))
        {
            // запись всей строки
            String text = String.valueOf(sb);
            writer.write(text);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }


    public static StringBuilder createSrc(){

        StringBuilder sb = new StringBuilder();

        int loading = 0;

        File dirSrc = new File("C:\\GAMES\\src");
        if (dirSrc.mkdir()){
            System.out.println("Accept src");
            sb.append(" Accept src");
            loading += 20;
        }else{
            System.out.println("Error src");
            sb.append(" Error src");
        }

        File dirMain = new File("C:\\GAMES\\src\\main");
        if (dirMain.mkdir()){
            System.out.println("Accept main");
            sb.append(" Accept main");
            loading += 20;
        }else{
            System.out.println("Error main");
            sb.append("Error main");
        }

        File dirTest = new File("C:\\GAMES\\src\\test");
        if (dirTest.mkdir()){
            System.out.println("Accept test");
            sb.append(" Accept test");
            loading += 20;
        }else{
            System.out.println("Error test");
            sb.append("Error test");
        }


        File fileMain = new File("C:\\GAMES\\src\\main\\Main.java");
        try {
            if(fileMain.createNewFile()){
                System.out.println("Accept Main.java");
                sb.append(" Accept Main.java");
                loading += 20;
            }
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
            sb.append(ex.getMessage());
        }

        File fileUtils = new File("C:\\GAMES\\src\\main\\Utils.java");
        try {
            if(fileUtils.createNewFile()){
                System.out.println("Accept Utils.java");
                sb.append(" Accept Utils.java");
                loading += 20;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            sb.append(ex.getMessage());
        }

        sb.append(" Загрузка файлов SRC завершена на " + loading + "%");
        sb.append("\n");
        return sb;
    }


    public static StringBuilder createRes(){

        StringBuilder sb = new StringBuilder();
        int loading = 0;

        File dirRes = new File("C:\\GAMES\\res");
        if (dirRes.mkdir()){
            System.out.println("Accept res");
            sb.append(" Accept res");
            loading += 25;
        }else{
            System.out.println("Error res");
            sb.append(" Error res");
        }

        File dirDrawables = new File("C:\\GAMES\\res\\drawables");
        if (dirDrawables.mkdir()){
            System.out.println("Accept drawables");
            sb.append(" Accept drawables");
            loading += 25;
        }else{
            System.out.println("Error drawables");
            sb.append(" Error drawables");
        }

        File dirVectors = new File("C:\\GAMES\\res\\vectors");
        if (dirVectors.mkdir()){
            System.out.println("Accept vectors");
            sb.append(" Accept vectors");
            loading += 25;
        }else{
            System.out.println("Error vectors");
            sb.append(" Error vectors");
        }

        File dirIcons = new File("C:\\GAMES\\res\\icons");
        if (dirIcons.mkdir()){
            System.out.println("Accept icons");
            sb.append(" Accept icons");
            loading += 25;
        }else{
            System.out.println("Error icons");
            sb.append(" Error icons");
        }

        sb.append(" Загрузка RES завершена на " + loading + "%");
        sb.append("\n");
        return sb;
    }

    public static StringBuilder createSaveGames(){

        StringBuilder sb = new StringBuilder();
        int loading = 0;

        File saveGames= new File("C:\\GAMES\\savegames");
        if(saveGames.mkdir()){
            System.out.println("Accept savegames");
            sb.append(" Accept savegames");
            loading += 100;
        }else{
            System.out.println("Error asvegames");
            sb.append(" Error asvegames");
        }

        sb.append("Загрузка SAVEGAMES завершена на " + loading + "%");
        sb.append("\n");
        return sb;

    }

    public static StringBuilder createTemp(){

        StringBuilder sb = new StringBuilder();
        int loading = 0;

        File dirTemp = new File("C:\\GAMES\\temp");
        if (dirTemp.mkdir()){
            System.out.println("Accept temp");
            sb.append(" Accept temp");
            loading += 50;
        }else{
            System.out.println("Error temp");
            sb.append(" Error temp");
        }


        File fileTemp = new File("C:\\GAMES\\temp\\temp.txt");
        try{
            if(fileTemp.createNewFile()){
                System.out.println("Accept temp.txt");
                sb.append(" Accept temp.txt");
                loading += 50;
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
            sb.append(ex.getMessage());
        }

        sb.append("Загрузка TEMP завершена на " + loading + "%");
        sb.append("\n");
        return sb;

    }

}