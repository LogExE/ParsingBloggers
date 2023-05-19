public class KeywordAuthor {
    public KeywordAuthor() {

    }

    public KeywordAuthor(String name,
                         String info) {
        this.name = name;
        this.info = info;
    }

    @Override
    public String toString() {
        return "KeywordAuthor " + name + ", info: " + info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String name;
    private String info;
}
