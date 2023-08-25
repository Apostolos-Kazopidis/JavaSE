import java.util.ArrayList;

public class Window {
    private String title;
    private ArrayList<String> name;
    private int width;
    private int height;

    public Window(String title, ArrayList<String> name, int width, int height) {
        this.title = title;
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Window{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
