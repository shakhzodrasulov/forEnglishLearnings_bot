import java.util.*;

public class EssentialEnglishWords {
    static String[] unitSixKey = new String[] {
            "ustunlik, afzallik, preimushestva (n)",
            "sabab, asos, prichina (v)",
            "tanlov, vibor (n)",
            "jamiyat, soobshestva (n)",
            "jonsiz(o'lgan), mertviy (adj)",
            "masofa, distansiya, rasstoyanie (n)",
            "qochish, qutilish, pobeg, begstvo (v)",
            "yuzma-yuz kelmoq ya'ni qandaydir muammo yoki masalaga yoki narsaga yuzi blan tik qarash, face-to-face turmoq, смотреть в лицо (проблеме, человеку, в что-то) (v)",
            "ergashmoq, ketidan(orqasidan) yurmoq(bormoq), следовать, следить (v)",
            "qo'rquv, страх (n)",
            "arvoh, ruh, привиденик, призрак (n)",
            "shaxs, kishi, индивидум, личность, человек (n)",
            "uy hayvoni, домашное животное (n)",
            "yetmoq, erishmoq, o'zi belgilagan joy yoki maqsadiga YETMOQ, достичь место/цели (v)",
            "qaytarish, возвращать. (qaysidir joydan orqaga qaytish, nimanidir/kimnidir egasiga, joyiga, orqasiga qaytarish harakatiga ishlatiladi) (v)",
            "qandaydir qiyin, havfli holatda tirikligini saqlab qolmoq, (yashab qolish, hayotini saqlab qolish), выжить (v)",
            "hafa bo'lmoq/baxtsiz bo'lmoq, расстроенный, огорчённый (adj)",
            "ovoz, голос (insonning ovozi, tovush emas, tovush = sound) (n)",
            "ob-havo, погода (n)",
            "dono, мудрый (ya'ni qandaydir qaror qabul qilishda tajribasi ko'p, bilimli, aqilli, a'lo fikrlaydigan insonning sifati) (adj)"
    };

    static String[] unitSixValues = new String[]{
            "advantage", "cause", "choice", "community", "dead", "distance", "escape", "face", "follow", "fright",
            "ghost", "individual", "pet", "reach", "return", "survive", "upset", "voice", "weather", "wise"
    };

    static Integer[] randomNumbers = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

    static void doRandom(){
        HashSet <Integer> randomedNumbers = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            randomedNumbers.add(i);
        }
        System.out.println(randomedNumbers);
    }

    static String onProcess = "";
    static int counter = 0;
    static int rightAnswers = 0;
    static int wrongAnswers = 0;
    static List<String> wrongAnswersKey = new ArrayList<String>();
    static List<String> wrongAnswersValue = new ArrayList<String>();

    static void clearAll(){
        onProcess = "";
        counter = 0;
        rightAnswers = 0;
        wrongAnswers = 0;
        wrongAnswersKey.clear();
        wrongAnswersValue.clear();
    }
}
