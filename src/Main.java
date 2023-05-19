
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

        x.addNet("youtube", "redactsiya", "2018-08-22");
        x.aboutSubs("youtube", "2023-05-01", 3600000000L);

        x.addNet("tg", "redakciya_channel", "2019-06-20");
        x.aboutSubs("tg", "2023-05-01", 975000L);
        x.aboutSubs("tg", "2023-04-19", 980000L);
        x.aboutSubs("tg", "2023-05-16", 973200L);

        x.addKeyword("news", googlebot);

        bloggers.add(x);

        // Соточка по русскому
        x = new Blogger();

        x.addNet("youtube", "sotochka", "2018-08-07");
        x.aboutSubs("youtube", "2023-05-19", 180000L);

        x.addNet("vk", "sotochka_ege", "2017-04-11");
        x.aboutSubs("vk", "2023-05-19", 76161L);

        x.addKeyword("education", googlebot);
        x.addKeyword("ЕГЭ по русскому", me);

        bloggers.add(x);

        //
        x = new Blogger();

        for (Blogger blgr : bloggers)
            System.out.println(blgr);
    }
}