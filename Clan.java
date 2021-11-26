import java.util.ArrayList;


public class Clan {
    private String name;
    private Matriarch matriarch;
    private ArrayList<Dragon> sisters;

    public Clan(Matriarch m) {
        name = m.getName() + "-han";
        matriarch = m;
        sisters = new ArrayList<>();
        
    }

    public String getName() {
        return name;
    }

    public Matriarch getMatriarch() {
        return matriarch;
    }

    public void addSister(Dragon s) {
        sisters.add(s);
    }

    public ArrayList<Dragon> getSisters() {
        return sisters;
    }

    @Override
    public String toString() {
        char q = '"';
        String result = "{ \"clan\": {";
        result += "\"name\": " + q + name + "\", ";
        result += "\"matriarch\": " + getMatriarch().toString();
        if (sisters.size() > 0) {
            result += ", \"sisters\": [ ";
            for (int i = 0; i < sisters.size(); i ++) {
                if (i == sisters.size() - 1) {
                    result += sisters.get(i).toString() + "] ";
                } else {
                    result += sisters.get(i).toString() + ", ";
                }
            }
            result += "} ";
        } else {
            result += "} ";
        }
        result += "}";
        return result;

    }
}
