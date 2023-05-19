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

    public String name;
    public String info;
}
