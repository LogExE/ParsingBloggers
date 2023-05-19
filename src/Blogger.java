import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Blogger {
    public Blogger() {
        nicks = new HashMap<>();
        regDates = new HashMap<>();
        topics = new HashMap<>();
        subs = new HashMap<>();
    }

    public Blogger(Map<String, String> nicks,
                   Map<String, Date> regDates,
                   Map<String, KeywordAuthor> topics,
                   Map<String, Map<Date, Integer>> subs) {
        this.regDates = regDates;
        this.nicks = nicks;
        this.topics = topics;
        this.subs = subs;
    }

    public Map<String, String> nicks;
    public Map<String, Date> regDates;
    public Map<String, KeywordAuthor> topics;
    public Map<String, Map<Date, Integer>> subs;
}
