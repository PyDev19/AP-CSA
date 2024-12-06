public class Test {
    public static void main(String[] args) {
        String[] wow = new String[5];
        wow[1] = "one";
        wow[2] = "two";
        wow[0] = wow[2];
        wow[2] = null;

        System.out.println(wow[0].length());
    }
}
