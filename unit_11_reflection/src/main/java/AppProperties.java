
public class AppProperties {

    public Integer version;

    @PropertyKey("ram")
    public int ram;

    @PropertyKey("space")
    public int space;

    @Override
    public String toString() {
        return "ram = " + ram + "\n" + "spase = " + space;
    }
}
