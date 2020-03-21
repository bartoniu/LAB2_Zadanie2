import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Arrays;

public class Zadanie2
{
    public static void main(String[] args)
    {
        String[] names = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                "Zyta", "Órszula", "Świętopełk"};

        Collator collator = Collator.getInstance(new Locale("pl","PL"));

    }

    public static void sortStrings(Collator collator, String[] words)
    {
        int n = words.length;
        String key = "";

        for (int i = 1; i < n; ++i) {
            key = words[i];
            int j = i - 1;

            while (j >= 0) {
                if(collator.compare(key, words[j]) > 0)
                {
                    break;
                }
                words[j + 1] = words[j];
                j = j - 1;
            }
            words[j + 1] = key;
        }
    }

    public static void fastSortStrings(Collator collator, String[] words)
    {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return collator.compare(s, t1);
            }
        });
    }

    public static void fastSortStrings2(Collator collator, String[] words)
    {
        Arrays.sort(words, (s, t1) -> collator.compare(s, t1));
    }
}

