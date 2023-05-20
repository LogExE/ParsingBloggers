
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    /*
    Необходимо создать класс Блоггер с указанием списка никнеймов и соответствующих социальных сетей с датами начала ведения,
    списка тем, которые он затрагивает или какие ассоциации вызывает, с указанием авторства этого ключевого слова,
    списка даты-времени и количестве подписчиков на этот момент.
    Создать дополнительные классы: Автор ключевого слова о блоггере.
     */
    public static final String FILE_NAME = "output.txt";

    public static void gen() throws IOException {
        var googlebot = new KeywordAuthor("google analytics", "bot");
        var me = new KeywordAuthor("Vladimir", "that's me");
        var uknwn = new KeywordAuthor("Unknown Author", "nothing");

        var bloggers = new ArrayList<Blogger>();
        Blogger x;

        // 1. Алексей Пивоваров
        x = new Blogger();

        x.addNet("youtube", "redactsiya", "2018-08-22");
        x.aboutSubs("youtube", "2023-05-01", 3600000L);

        x.addNet("tg", "redakciya_channel", "2019-06-20");
        x.aboutSubs("tg", "2023-05-01", 975000L);
        x.aboutSubs("tg", "2023-04-19", 980000L);
        x.aboutSubs("tg", "2023-05-16", 973200L);

        x.addKeyword("news", googlebot);

        bloggers.add(x);

        // 2. Соточка по русскому
        x = new Blogger();

        x.addNet("youtube", "sotochka", "2018-08-07");
        x.aboutSubs("youtube", "2023-05-19", 180000L);

        x.addNet("vk", "sotochka_ege", "2017-04-11");
        x.aboutSubs("vk", "2023-05-19", 76161L);

        x.addKeyword("education", googlebot);
        x.addKeyword("ЕГЭ по русскому", me);

        bloggers.add(x);

        // 3. sereGGa
        x = new Blogger();

        x.addNet("youtube", "sereGGa", "2019-10-29");
        x.aboutSubs("youtube", "2023-05-19", 228000L);

        x.addNet("tg", "sereggadota", "2020-12-24");
        x.aboutSubs("tg", "2023-05-19", 35662L);
        x.aboutSubs("tg", "2023-04-30", 36351L);

        x.addKeyword("games", googlebot);
        x.addKeyword("dota", googlebot);
        x.addKeyword("beer", uknwn);

        bloggers.add(x);

        // 4. The Люди
        x = new Blogger();

        x.addNet("youtube", "anton_lyadov", "2017-07-05");
        x.aboutSubs("youtube", "2023-05-19", 4730000L);

        x.addKeyword("travel", googlebot);

        bloggers.add(x);

        // 5. Alex Gyver
        x = new Blogger();

        x.addNet("youtube", "AlexGyverShow", "2015-08-07");

        x.addKeyword("DIY", googlebot);
        x.addKeyword("programming", googlebot);
        x.addKeyword("Arduino", me);

        bloggers.add(x);

        // 6. Codeforces Legend
        x = new Blogger();

        x.addNet("vk", "Ярослав Буйкевич", "2022-10-15");
        x.aboutSubs("vk", "2023-05-19", 41L);

        bloggers.add(x);

        // 7. An empty blogger drew near!
        x = new Blogger();

        bloggers.add(x);

        // 8. Tsoding
        x = new Blogger();

        x.addNet("twitch", "tsoding", "2015-12-22");
        x.aboutSubs("twitch", "2023-05-19", 36714L);
        x.aboutSubs("twitch", "2017-03-29", 138L);
        x.aboutSubs("twitch", "2019-08-23", 4412L);

        x.addNet("youtube","TsodingDaily", "2019-01-12");
        x.aboutSubs("youtube", "2023-05-19", 51800L);

        x.addKeyword("programming", me);
        x.addKeyword("esoteric programming languages", me);
        x.addKeyword("weirdo", uknwn);

        bloggers.add(x);

        // 9. 3Blue1Brown
        x = new Blogger();

        x.addNet("reddit", "3Blue1Brown", "2016-11-05");
        x.aboutSubs("reddit", "2023-05-19", 40500L);

        x.addNet("youtube", "3blue1brown", "2015-03-04");
        x.aboutSubs("youtube", "2023-05-19", 5190000L);

        x.addKeyword("educational", googlebot);
        x.addKeyword("algebra", googlebot);
        x.addKeyword("theory of probability", googlebot);
        x.addKeyword("Python Manim", googlebot);

        bloggers.add(x);

        // 10. Fighter PL
        x = new Blogger();

        x.addNet("youtube", "FighterPL", "2009-04-23");
        x.aboutSubs("youtube", "2023-05-19", 461000L);

        x.addNet("twitch", "fighterpl", "2010-11-08");
        x.aboutSubs("twitch", "2023-05-19", 71015L);

        x.addKeyword("games", googlebot);
        x.addKeyword("dark souls", googlebot);
        x.addKeyword("tryhard gamer", uknwn);

        bloggers.add(x);

        // 11. Саша Квашеная
        x = new Blogger();

        x.addNet("youtube", "kvashenaya", "2013-09-23");
        x.aboutSubs("youtube", "2023-05-19", 1940000L);

        x.addNet("tg", "kvashenayakto", "2019-06-24");
        x.aboutSubs("tg", "2023-05-19", 38414L);

        x.addKeyword("music", googlebot);
        x.addKeyword("безбашенная", uknwn);

        bloggers.add(x);

        // 12. kitty0706
        x = new Blogger();

        x.addNet("youtube", "kitty0706", "2007-04-14");
        x.aboutSubs("youtube", "2023-05-19", 592000L);

        x.addKeyword("entertainment", googlebot);
        x.addKeyword("Garry's Mod", me);
        x.addKeyword("farewell :c", me);

        bloggers.add(x);

        var mapper = new ObjectMapper().findAndRegisterModules();

        try (var writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Blogger blgr : bloggers) {
                writer.append(mapper.writeValueAsString(blgr));
                writer.append('\n');
            }
        }
    }

    public static ArrayList<Blogger> read() throws IOException {
        var bloggers = new ArrayList<Blogger>();
        var mapper = new ObjectMapper().findAndRegisterModules();
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String inp;
            while ((inp = reader.readLine()) != null) {
                var blgr = mapper.readValue(inp, Blogger.class);
                bloggers.add(blgr);
            }
        }
        return bloggers;
    }

    public static void main(String[] args) throws IOException {
        gen();
        var bloggers = read();
        //for (Blogger blgr : bloggers)
        //    System.out.println(blgr);

        Consumer<Blogger> printOutNicks = x -> System.out.println(x.getNicks());

        System.out.println("Tasks with lambdas:");
        System.out.println("1. Entertainment bloggers list");
        bloggers
                .stream()
                .filter(x -> x.hasKeyword("entertainment")
                        || x.hasKeyword("music")
                        || x.hasKeyword("games"))
                .forEach(printOutNicks);

        System.out.println("2. Popular bloggers (subs >= 500K)");
        long k = 500000;
        var date = LocalDate.parse("2023-05-19");
        bloggers
                .stream()
                .filter(b -> b
                        .getSubs()
                        .values().stream().map(m -> m.get(date))
                        .map(m -> m == null ? 0 : m)
                        .min(Long::compare).orElse(0L) >= k)
                .forEach(printOutNicks);

        System.out.println("3. Bloggers sorted by max subs");
        // Используем ранее объявленную date
        Function<Blogger, Long[]> subsSorted = x -> x
                .getSubs()
                .values().stream().map(m -> m.get(date)) // получили список подписчиков на момент date
                .sorted(Comparator.reverseOrder()).toArray(Long[]::new);
        bloggers
                .stream()
                .filter(b -> b
                        .getSubs()
                        .values().stream().map(m -> m.get(date))
                        .filter(sub -> sub != null).count() != 0)
                .sorted((b1, b2) -> Arrays.compare(subsSorted.apply(b1), subsSorted.apply(b2)))
                .forEach(b -> System.out.printf("%s %s%n", b.getNicks(), Arrays.toString(subsSorted.apply(b))));

        System.out.println("4. Bloggers sorted by sum of subs");
        // Используем ранее объявленную date
        Function<Blogger, Long> subsSum = b -> b
                .getSubs()
                .values().stream().map(m -> m.get(date)) // получили список подписчиков на момент date
                .map(m -> m == null ? 0 : m)
                .reduce(0L, Long::sum);
        bloggers
                .stream()
                .filter(b -> b
                        .getSubs()
                        .values().stream()
                        .map(m -> m.get(date))
                        .filter(sub -> sub != null).count() != 0) //
                .sorted(Comparator.comparing(subsSum::apply))
                .forEach(b -> System.out.printf("%s %d%n", b.getNicks(), subsSum.apply(b)));
    }
}