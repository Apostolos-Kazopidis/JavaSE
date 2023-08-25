public class Widget {
    private String debug;
    private Window window;
    private Image image;
    private Text text;

    public Widget() {
    }

    public Widget(String debug, Window window, Image image, Text text) {
        this.debug = debug;
        this.window = window;
        this.image = image;
        this.text = text;
    }

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "debug='" + debug + '\'' +
                ", window=" + window +
                ", image=" + image +
                ", text=" + text +
                '}';
    }
}
