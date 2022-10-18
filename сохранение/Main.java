import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

    public static int slot = 1;

    public static void main(String[] args) {

        GameProgress first = new GameProgress(32, 1, 12, 3.23);
        GameProgress second = new GameProgress(100, 2, 1, 0.1);
        GameProgress third = new GameProgress(89, 5, 8, 2.21);

        String[] saveWawes = new String[3];

        String mySave;

        mySave = (saving(first));
       saveWawes[0] = mySave;

        mySave =(saving(second));
        saveWawes[1] =mySave;
        mySave =(saving(third));
        saveWawes[2] =mySave ;

        zipFiles(saveWawes);

    }

    public static String saving(GameProgress player){



        String slotStr = Integer.toString(slot);

        String saveWay = new String("C:\\GAMES\\savegames\\" + slotStr + ".txt");

        File saveSlot = new File(saveWay);
        try {
            if(saveSlot.createNewFile()){
                System.out.println("Accept saveSlot");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

        try (FileOutputStream saving = new FileOutputStream(saveWay)){
            byte health = (byte)player.getHealth();
            byte weapon = (byte)player.getWeapons();
            byte lvl = (byte)player.getLvl();
            byte distance = (byte)player.getDistance();
            byte[] bytes = new byte[]{health, weapon, lvl, distance};

            saving.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        slot++;

        return saveWay;
    }

    public static void zipFiles(String[] saveWawes){


        for(int i = 0; i < saveWawes.length; i++) {
            try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\GAMES\\savegames\\Save_slot.zip"));
                 FileInputStream fis = new FileInputStream("C:\\GAMES\\savegames\\Save_slot.zip")) {
                ZipEntry entry = new ZipEntry("C:\\GAMES\\savegames\\Save_slot.zip");
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        }
}