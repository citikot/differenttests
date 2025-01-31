package online.agatstudio.locale;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleOutput {
    public static void main(String[] args) {
        double number = 2999.25;

        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        System.out.println(formatter.format(number)); // 2,999.25
    }
}
