import java.util.ArrayList;

public class Dragon {
    private String name;
    private String[] color;
    private Drake mate;
    private Matriarch matriarch;
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

    public Dragon(String name, Matriarch m) {
        this.name = name;
        matriarch = m;
        m.addDaughter(this);
        daughters = new ArrayList<>();
        if (m.colors().length == 2) {
            color = new String[] {m.colors()[0], m.colors()[1]};
        } else {
            color = new String[] {m.colors()[0]};
        }
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

    public String[] colors() {
        return color;
    }

    public void setMate(Drake d) {
        d.setMate(this);
        mate = d;
    }

    public Drake getMate() {
        return mate;
    }

    public void setMatriarch(Matriarch m) {
        matriarch = m;
    }

    public Matriarch getMatriarch() {
        return matriarch;
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
            result += ", \"mate\": " + mate.toString();
        }
        if (daughters.size() > 0) {
            result += ", \"daughters\": [ ";
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
