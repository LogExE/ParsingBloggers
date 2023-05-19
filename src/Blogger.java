import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Blogger {
    public Blogger() {
        nicks = new HashMap<>();
        topics = new HashMap<>();
        subs = new HashMap<>();
    }

    public Blogger(Map<String, String> nicks,
                   Map<String, KeywordAuthor> topics,
                   Map<Date, Integer> subs) {
        this.nicks = nicks;
        this.topics = topics;
        this.subs = subs;
    }

    public Map<String, String> nicks;
    public Map<String, KeywordAuthor> topics;
    public Map<Date, Integer> subs;
}
