public class Test {
    public static void main(String[] args) {
        test(0, 1);
        test(1, 2);
        test(13, 3);
        test(20, 4);
    }

    public static void addElements(int amount, LinkedList<Integer> list) {
        for (int i = 1; i <= amount; i++) {
            list.add(i);
        }
    }
    public static void test(int amount, int whichTest) {
        System.out.printf("--------------------------Test %d-------------------------%n", whichTest);
        LinkedList<Integer> list = new LinkedList<>();
        addElements(amount, list);
        list.print();
        list.revert();
        list.print();
        System.out.println("--------------------------TestEnd-------------------------");
    }
}
