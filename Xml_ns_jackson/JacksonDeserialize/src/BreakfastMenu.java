import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class BreakfastMenu {
    @JacksonXmlElementWrapper(useWrapping = false)
    Food[] food;

    public BreakfastMenu() {
    }

    public BreakfastMenu(Food[] food) {
        this.food = food;
    }

    public Food[] getFood() {
        return food;
    }

    public void setFood(Food[] food) {
        this.food = food;
    }

    @Override
    public String toString() {
        String str="";
        for (int i=0; i< food.length; i++)
            str += food[i].toString() + "\n";

        return str;
    }
}
