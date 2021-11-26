import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter; // Import the FileWriter class

public class DragonGen {
    public static void make(String f, String body) {
        try {
            File file = new File(f);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                if (file.canWrite()) {
                    write(f, body);
                }
            } else {
                System.out.println("File already exists.");
                if (file.canWrite()) {
                    write(f, body);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void write(String f, String body) {
        try {
            FileWriter writer = new FileWriter(f);
            writer.write(body);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Matriarch m = new Matriarch("Oso", "Red", "Bronze");
        Clan oso = new Clan(m);

        Dragon a = new Dragon("A", m);
        Dragon b = new Dragon("B", m);
        Dragon c = new Dragon("C", m);

        Dragon h = new Dragon("H", "Red", "Bronze");
        Dragon i = new Dragon("I", "Bronze");
        oso.addSister(h);
        oso.addSister(i);
        
        Drake d = new Drake("D", m);

        Dragon e = new Dragon("E", "Red", "Bronze");
        Dragon g = new Dragon("G", "Red", "Bronze");
        Drake f = new Drake("F", "Black");
        a.addDaughter(e);
        a.addDaughter(g);
        a.setMate(f);
        

        

        String file = "output/" + oso.getName() + ".json";
        String body = oso.toString();

        make(file, body);

    }
}
