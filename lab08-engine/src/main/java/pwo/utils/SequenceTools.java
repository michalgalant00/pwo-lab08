package pwo.utils;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class SequenceTools {

    private static String getTerms(SequenceGenerator sg,
            int from, int to, String sep) {

        int i = from, stop = to, step = from > to ? -1 : 1;
        String terms = "";

        while (true) {
            terms += sg.getTerm(i) + sep;
            if (i == stop) {
                return terms.trim();
            }
            i += step;
        }
    }

    public static String getTermsAsColumn(SequenceGenerator sg,
            int from, int to) {
        return getTerms(sg, from, to, "\n");
    }

    public static String getTermsAsLine(SequenceGenerator sg,
            int from, int to) {
        return getTerms(sg, from, to, " ");
    }

    public static boolean writeToFile(SequenceGenerator sg,
            int from, int to, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {
            writer.write(getTermsAsColumn(sg, from, to));
        } catch (IOException ex) {
            return false;
        }

        return true;
    }
}
