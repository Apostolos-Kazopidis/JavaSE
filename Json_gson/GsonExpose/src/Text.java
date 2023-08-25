import com.google.gson.annotations.Expose;

public class Text {
    @Expose
    private String data;
    @Expose
    private int size;
    @Expose
    private String style;
    @Expose
    private String name;
    @Expose
    private int hOffset;
    @Expose
    private int vOffset;
    @Expose
    private String alignment;
    @Expose
    private String onMouseUp;

    public Text(String data, int size, String style, String name, int hOffset, int vOffset, String alignment, String onMouseUp) {
        this.data = data;
        this.size = size;
        this.style = style;
        this.name = name;
        this.hOffset = hOffset;
        this.vOffset = vOffset;
        this.alignment = alignment;
        this.onMouseUp = onMouseUp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int gethOffset() {
        return hOffset;
    }

    public void sethOffset(int hOffset) {
        this.hOffset = hOffset;
    }

    public int getvOffset() {
        return vOffset;
    }

    public void setvOffset(int vOffset) {
        this.vOffset = vOffset;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getOnMouseUp() {
        return onMouseUp;
    }

    public void setOnMouseUp(String onMouseUp) {
        this.onMouseUp = onMouseUp;
    }

    @Override
    public String toString() {
        return "Text{" +
                "data='" + data + '\'' +
                ", size=" + size +
                ", style='" + style + '\'' +
                ", name='" + name + '\'' +
                ", hOffset=" + hOffset +
                ", vOffset=" + vOffset +
                ", alignment='" + alignment + '\'' +
                ", onMouseUp='" + onMouseUp + '\'' +
                '}';
    }
}
