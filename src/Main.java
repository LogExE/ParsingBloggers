import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main {
    static ArrayList<Blogger> bloggers = new ArrayList<>();
    static HashMap<String, String> nicks = new HashMap<>();
    static HashMap<String, KeywordAuthor> topics = new HashMap<>();
    static HashMap<Date, Integer> subs = new HashMap<>();

    static void clear() {
        nicks.clear();
        topics.clear();
        subs.clear();
    }
    public static void main(String[] args) {
        //Алексей Пивоваров
        nicks.put("youtube", "Редакция");
        nicks.put("tg", "Пивоваров (Редакция)");
        topics.put("news", new KeywordAuthor("google analytics", "bot"));
        subs.put(new Date(2023, 5, 1), 975000);
        bloggers.add(new Blogger(nicks, topics, subs));
        clear();
    }
}