import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

import java.text.Collator;
import java.util.Locale;

class Zadanie2Test
{
    String[] names = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
            "Zyta", "Órszula", "Świętopełk"};

    Collator collator = Collator.getInstance(new Locale("pl","PL"));

    String[] output1 = names.clone();
    String[] output2 = names.clone();
    String[] output3 = names.clone();

    @org.junit.jupiter.api.Test
    void sortStrings()
    {
        Zadanie2.sortStrings(collator, output1);
        Zadanie2.fastSortStrings(collator, output2);
        Zadanie2.fastSortStrings2(collator, output3);

        Assertions.assertArrayEquals(output1,output2);
        Assertions.assertArrayEquals(output1,output3);
        Assertions.assertArrayEquals(output2,output3);
    }

    @org.junit.jupiter.api.Test
    void effciencyTest()
    {
        long nano_startTimeForTest1 = System.nanoTime();

        for(int i = 0; i < 100000; i++)
        {
            Zadanie2.sortStrings(collator, output1);
            output1 = names.clone();
        }

        long nano_endTimeForTest1 = System.nanoTime();

        System.out.println("Time taken in nano seconds for sortStrings: "
                + (nano_endTimeForTest1 - nano_startTimeForTest1));

        long nano_startTimeForTest2 = System.nanoTime();

        for(int i = 0; i < 100000; i++)
        {
            Zadanie2.fastSortStrings(collator, output2);
            output2 = names.clone();
        }

        long nano_endTimeForTest2 = System.nanoTime();

        System.out.println("Time taken in nano seconds for fastSortStrings: "
                + (nano_endTimeForTest2 - nano_startTimeForTest2));

        long nano_startTimeForTest3 = System.nanoTime();

        for(int i = 0; i < 100000; i++)
        {
            Zadanie2.fastSortStrings2(collator, output3);
            output3 = names.clone();
        }

        long nano_endTimeForTest3 = System.nanoTime();

        System.out.println("Time taken in nano seconds for fastSortStrings2: "
                + (nano_endTimeForTest3 - nano_startTimeForTest3));
    }
}