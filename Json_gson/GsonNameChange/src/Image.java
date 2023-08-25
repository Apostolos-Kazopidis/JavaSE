public class Image {
    private String src;
    private String name;
    private int hOffset;
    private int vOffset;
    private String alignment;

    public Image(String src, String name, int hOffset, int vOffset, String alignment) {
        this.src = src;
        this.name = name;
        this.hOffset = hOffset;
        this.vOffset = vOffset;
        this.alignment = alignment;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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

    @Override
    public String toString() {
        return "Image{" +
                "src='" + src + '\'' +
                ", name='" + name + '\'' +
                ", hOffset=" + hOffset +
                ", vOffset=" + vOffset +
                ", alignment='" + alignment + '\'' +
                '}';
    }
}
