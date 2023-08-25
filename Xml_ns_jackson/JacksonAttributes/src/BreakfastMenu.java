import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BreakfastMenu {
    @JacksonXmlElementWrapper(useWrapping = false)
    Food[] food;
    @JacksonXmlProperty(isAttribute = true)
    String attr;

    public BreakfastMenu() {
    }

    public BreakfastMenu(Food[] food, String attr) {
        this.food = food;
        this.attr = attr;
    }

    public Food[] getFood() {
        return food;
    }

    public void setFood(Food[] food) {
        this.food = food;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        String str="BreakfastMenu (attr=" + attr + ")" + "\n";
        for (int i=0; i< food.length; i++)
            str += food[i].toString() + "\n";

        return str;
    }
}
