import java.util.ArrayList;

public class Matriarch extends Dragon {
    private ArrayList<Dragon> consorts;

    public Matriarch(String name, String color) {
        super(name, color);
        consorts = new ArrayList<>();
    }

    public Matriarch(String name, String c1, String c2) {
        super(name, c1, c2);
        consorts = new ArrayList<>();
    }

    public void addConsort(Dragon d) {
        consorts.add(d);
    }

    public ArrayList<Dragon> getConsorts() {
        return consorts;
    }

    @Override
    public String toString() {
        char q = '"';
        String result ="{ ";
        result += "'name': " + q + getName() + q;
        result += ", \" color \":"  + getColor();
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