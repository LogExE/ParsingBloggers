import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
        var df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("ru"));

        var googlebot = new KeywordAuthor("google analytics", "bot");
        var me = new KeywordAuthor("Vladimir", "yours truly");

        var bloggers = new ArrayList<Blogger>();
        Blogger x;

        //Алексей Пивоваров
        x = new Blogger();
        x.nicks.put("youtube", "Редакция");
        x.regDates.put("youtube", df.parse("22.08.2018"));
        x.nicks.put("tg", "Пивоваров (Редакция)");
        x.regDates.put("tg", df.parse(""));
        x.topics.put("news", googlebot);
        x.subs.get("youtube").put(df.parse("01.05.2023"), 975000);
        bloggers.add(x);

        //3b1b
        x = new Blogger();
        x.nicks.put("youtube", "Соточка по русскому");
        x.nicks.put("vk", "Ляйсан Хутова");
        bloggers.add(x);
    }
}