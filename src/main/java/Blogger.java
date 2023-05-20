
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Blogger {
    public Blogger() {
        nicks = new HashMap<>();
        regDates = new HashMap<>();
        subs = new HashMap<>();
        keywords = new HashMap<>();
    }

    public Blogger(Map<String, String> nicks,
                   Map<String, LocalDate> regDates,
                   Map<String, SortedMap<LocalDate, Long>> subs,
                   Map<String, KeywordAuthor> keywords) {
        this.regDates = regDates;
        this.nicks = nicks;
        this.keywords = keywords;
        this.subs = subs;
    }

    public void addNet(String net, String nick, String regdate) {
        nicks.put(net, nick);
        regDates.put(net, LocalDate.parse(regdate));
        subs.put(net, new TreeMap<>());
    }

    public void aboutSubs(String net, String date, Long count) {
        subs.get(net).put(LocalDate.parse(date), count);
    }

    public void addKeyword(String keyword, KeywordAuthor author) {
        keywords.put(keyword, author);
    }

    public boolean hasKeyword(String keyword) {
        return keywords.containsKey(keyword);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("Blogger\n");
        if (nicks.size() != 0) {
            for (String net : nicks.keySet()) {
                sb.append(net).append(" \"").append(nicks.get(net))
                        .append("\", registered in ").append(regDates.get(net).toString()).append('\n');
                if (subs.get(net).size() != 0) {
                    sb.append("sub history:\n");
                    for (LocalDate dt : subs.get(net).keySet())
                        sb.append("at ").append(dt).append(" -> ").append(subs.get(net).get(dt)).append('\n');
                    sb.append('\n');
                } else sb.append("No info about subs\n\n");
            }
        } else sb.append("No data...\n\n");
        if (keywords.size() != 0) {
            sb.append("Keywords:\n");
            for (String keyword : keywords.keySet())
                sb.append(keyword).append(", by ").append(keywords.get(keyword)).append('\n');
        }
        else sb.append("No keywords\n");
        return sb.toString();
    }

    private Map<String, String> nicks;
    private Map<String, LocalDate> regDates;
    private Map<String, SortedMap<LocalDate, Long>> subs;
    private Map<String, KeywordAuthor> keywords;

    public Map<String, String> getNicks() {
        return nicks;
    }

    public void setNicks(Map<String, String> nicks) {
        this.nicks = nicks;
    }

    public Map<String, LocalDate> getRegDates() {
        return regDates;
    }

    public void setRegDates(Map<String, LocalDate> regDates) {
        this.regDates = regDates;
    }

    public Map<String, SortedMap<LocalDate, Long>> getSubs() {
        return subs;
    }

    public void setSubs(Map<String, SortedMap<LocalDate, Long>> subs) {
        this.subs = subs;
    }

    public Map<String, KeywordAuthor> getKeywords() {
        return keywords;
    }

    public void setKeywords(Map<String, KeywordAuthor> keywords) {
        this.keywords = keywords;
    }
}
