package online.agatstudio.other_tests;

public class TypesTaskPastHours {
    private static final int SECONDS_IN_DAY = 86400;
    private static final int SECONDS_IN_HOUR = 3600;

    public static int pastHours(int second) {
        if (second > SECONDS_IN_DAY || second < 0) {
            return 0;
        }

        return second / SECONDS_IN_HOUR;
    }

    private TypesTaskPastHours(){}

    public static void main(String[] args) {
        System.out.println("С начала дня прошло 2 часа: " + pastHours(125 * 60));
        System.out.println("С начала дня прошло 0 часа: " + pastHours(-10));
    }
}
