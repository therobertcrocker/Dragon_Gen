import java.util.ArrayList;

public class Dragon {
    private String name;
    private String[] color;
    private Dragon mate;
    private ArrayList<Dragon> daughters;

    public Dragon(String name, String color) {
        this.name = name;
        daughters = new ArrayList<>();
        this.color = new String[1];
        this.color[0] = color;
        
    }

    public Dragon(String name, String c1, String c2) {
        this.name = name;
        daughters = new ArrayList<>();
        this.color = new String[2];
        this.color[0] = c1;
        this.color[1] = c2;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        String result = "";
        if (color.length == 2) {
            result += color[0] + " / " + color[1];
        } else {
            result += color[0];
        }

        return result;
    }

    public void setMate(Dragon d) {
        mate = d;
    }

    public Dragon getMate() {
        return mate;
    }

    public void addDaughter(Dragon d) {
        daughters.add(d);
    }

    public ArrayList<Dragon> getDaughters() {
        return daughters;
    }

    @Override
    public String toString() {
        char q = '"';
        String result ="{ ";
        result += "\"name\": " + q + name + q;
        result += ", \"color\": " + q + getColor() + q;
        if (mate != null) {
            result += ", 'mate': " + "'" + mate.getName() + "'";
        }
        if (daughters.size() > 0) {
            result += ", 'daughters': [ ";
            for (int i = 0; i < daughters.size(); i ++) {
                if (i == daughters.size() - 1) {
                    result += daughters.get(i).toString() + "] ";
                } else {
                    result += daughters.get(i).toString() + ", ";
                }
            }
            result += "} ";
        } else {
            result += "} ";
        }
        return result;
    }
}
