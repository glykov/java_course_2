public class Main {
    public static void main(String[] args) {
        StringArrayList strings = new StringArrayList(5);
        strings.add("two");
        strings.add(0, "one");
        strings.add("three");
        System.out.println(strings);
    }
}
