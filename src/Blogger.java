
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class Blogger {
    public Blogger() {
        nicks = new HashMap<>();
        regDates = new HashMap<>();
        subs = new HashMap<>();
        topics = new HashMap<>();
    }

    public Blogger(Map<String, String> nicks,
                   Map<String, LocalDate> regDates,
                   Map<String, SortedMap<LocalDate, Long>> subs,
                   Map<String, KeywordAuthor> topics) {
        this.regDates = regDates;
        this.nicks = nicks;
        this.topics = topics;
        this.subs = subs;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("Blogger\n");
        for (String net : nicks.keySet()) {
            sb.append(net).append(" account: ")
                    .append("known as \"").append(nicks.get(net))
                    .append("\", registered in ").append(regDates.get(net).toString()).append('\n');
            sb.append("Sub history for ").append(net).append(":\n");
            for (LocalDate dt : subs.get(net).keySet())
                sb.append("at ").append(dt).append(" -> ").append(subs.get(net).get(dt)).append('\n');
            sb.append('\n');
        }
        sb.append("Keywords:\n");
        for (String keyword : topics.keySet())
            sb.append(keyword).append(", by ").append(topics.get(keyword)).append('\n');
        return sb.toString();
    }

    public Map<String, String> nicks;
    public Map<String, LocalDate> regDates;
    public Map<String, SortedMap<LocalDate, Long>> subs;
    public Map<String, KeywordAuthor> topics;
}
