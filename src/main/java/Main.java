
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class Main {
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

        var mapper = new ObjectMapper().findAndRegisterModules();

        try (var writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (Blogger blgr : bloggers) {
                writer.append(mapper.writeValueAsString(blgr));
                writer.append('\n');
            }
        }
    }

    public static ArrayList<Blogger> read() throws IOException {
        var bloggers = new ArrayList<Blogger>();
        var mapper = new ObjectMapper().findAndRegisterModules();
        try (var reader = new BufferedReader(new FileReader("output.txt"))) {
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
        for (Blogger blgr : bloggers)
            System.out.println(blgr);
    }
}