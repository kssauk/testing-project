package utils;

import java.util.*;

/**
 * Created by PC on 20.12.2015.
 */
public class Utils {
    private static final String HOW_DO_YOU_DO = "How do you do?";
    private static final String HOW_OLD_ARE_YOU = "How old are you?";
    private static final String YOU_COOL = "You are very cool man. Give me 5";

    private static Random rnd = new Random();

    public static String getRandomString(int len)
    {
        List<String> questions=new ArrayList<String>();
        questions.add(HOW_DO_YOU_DO);
        questions.add(HOW_OLD_ARE_YOU);
        questions.add(YOU_COOL);
        return YOU_COOL;
    }
}
