public class Drake {
    private String name;
    private String[] color;
    private Dragon mate;
    private Matriarch matriarch;

    public Drake(String name, Matriarch m) {
        this.name = name;
        matriarch = m;
        m.addSon(this);
        if (m.colors().length == 2) {
            color = new String[] {m.colors()[0], m.colors()[1]};
        } else {
            color = new String[] {m.colors()[0]};
        }
    }

    public Drake(String name, String color) {
        this.name = name;
        this.color = new String[1];
        this.color[0] = color;
        
    }

    public Drake(String name, String c1, String c2) {
        this.name = name;
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

    public String[] colors() {
        return color;
    }

    public void setMate(Dragon d) {
        mate = d;
    }

    public void setMatriarch(Matriarch m) {
        matriarch = m;
    }

    public Dragon getMate() {
        return mate;
    }

    public Matriarch getMatriarch() {
        return matriarch;
    }

    @Override
    public String toString() {
        char q = '"';
        String result = "{ ";
        result += "\"name\": " + q + name + q;
        result += ", \"color\": " + q + getColor() + q;
        if (matriarch != null) {
            result += ", \"matriarch\": " + q + matriarch.getName() + q;
        }
        result += "} ";
        return result;
    }
}
