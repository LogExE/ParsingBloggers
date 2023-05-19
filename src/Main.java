
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws ParseException {
        var googlebot = new KeywordAuthor("google analytics", "bot");
        var me = new KeywordAuthor("Vladimir", "yours truly");

        var bloggers = new ArrayList<Blogger>();
        Blogger x;

        // Алексей Пивоваров
        x = new Blogger();

        x.nicks.put("youtube", "redactsiya");
        x.regDates.put("youtube", LocalDate.parse("2018-08-22"));
        x.subs.put("youtube", new TreeMap<>());
        x.subs.get("youtube").put(LocalDate.parse("2023-05-01"), 3600000000L);

        x.nicks.put("tg", "redakciya_channel");
        x.regDates.put("tg", LocalDate.parse("2019-06-20"));
        x.subs.put("tg", new TreeMap<>());
        x.subs.get("tg").put(LocalDate.parse("2023-05-01"), 975000L);
        x.subs.get("tg").put(LocalDate.parse("2023-04-19"), 980000L);
        x.subs.get("tg").put(LocalDate.parse("2023-05-16"), 973200L);

        x.topics.put("news", googlebot);

        bloggers.add(x);

        // Соточка по русскому
        x = new Blogger();

        x.nicks.put("youtube", "sotochka");
        x.regDates.put("youtube", LocalDate.parse("2018-08-07"));
        x.subs.put("youtube", new TreeMap<>());
        x.subs.get("youtube").put(LocalDate.parse("2023-05-19"), 180000L);

        x.nicks.put("vk", "sotochka_ege");
        x.regDates.put("vk", LocalDate.parse("2017-04-11"));
        x.subs.put("vk", new TreeMap<>());
        x.subs.get("vk").put(LocalDate.parse("2023-05-19"), 76161L);

        x.topics.put("education", googlebot);
        x.topics.put("ЕГЭ по русскому", me);

        bloggers.add(x);

        //
        x = new Blogger();

        for (Blogger blgr : bloggers)
            System.out.println(blgr);
    }
}