import com.google.gson.annotations.Expose;

public class Window {
    @Expose
    private String title;
    @Expose
    private String name;
    @Expose
    private int width;
    @Expose
    private int height;

    public Window(String title, String name, int width, int height) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
