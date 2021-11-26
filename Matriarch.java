import java.util.ArrayList;

public class Matriarch extends Dragon {
    private ArrayList<Drake> consorts;
    private ArrayList<Drake> sons;

    public Matriarch(String name, String color) {
        super(name, color);
        consorts = new ArrayList<>();
        sons = new ArrayList<>();
    }

    public Matriarch(String name, String c1, String c2) {
        super(name, c1, c2);
        consorts = new ArrayList<>();
        sons = new ArrayList<>();
    }

    public void addDaughter(Dragon d) {
        d.setMatriarch(this);
        super.addDaughter(d);
    }

    public void addConsort(Drake d) {
        consorts.add(d);
    }

    public ArrayList<Drake> getConsorts() {
        return consorts;
    }

    public void addSon(Drake d) {
        d.setMatriarch(this);
        sons.add(d);
    }

    public ArrayList<Drake> getSons() {
        return sons;
    }

    @Override
    public String toString() {
        char q = '"';
        String result ="{ ";
        result += "\"name\": " + q + getName() + q;
        result += ", \"color\":"  + q + getColor() + q;
        if (getMate() != null) {
            result += ", \"mate\": " + q + getMate().getName() + q;
        }
        if (consorts.size() > 0) {
            result += ", \"consorts\": [ ";
            for (int i = 0; i < consorts.size(); i ++) {
                if (i == consorts.size() - 1) {
                    result += consorts.get(i).toString() + "] ";
                } else {
                    result += consorts.get(i).toString() + ", ";
                }
            }
        }
        if (getDaughters().size() > 0) {
            result += ", \"daughters\": [ ";
            for (int i = 0; i < getDaughters().size(); i ++) {
                if (i == getDaughters().size() - 1) {
                    result += getDaughters().get(i).toString() + "] ";
                } else {
                    result += getDaughters().get(i).toString() + ", ";
                }
            }
            result += "} ";
        } else {
            result += "} ";
        }
        return result;
    }
}