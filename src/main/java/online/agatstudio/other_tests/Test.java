package online.agatstudio.other_tests;

class Test {
    public static void main(String[] args) {
        String[][] astr = new String[2][];
        astr[0] = new String[2];
        astr[1] = new String[3];
        int a = 42;
        for (int i = 0; i < astr.length; i++) {
            for (int j = 0; j < astr.length; j++) { // <--- This should use astr[i].length
                astr[i][j] = "" + a;
                a++;
            }
        }
        for (
                String[] e : astr) {
            for (String c : e) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}


