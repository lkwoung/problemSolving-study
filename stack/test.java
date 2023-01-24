public class test {
    public static void main(String[] args) {

        stack<Integer> lv_stack_a = new stack<Integer>();

        lv_stack_a.push(1);
        lv_stack_a.push(2);
        lv_stack_a.push(3);
        lv_stack_a.push(4);

        System.out.println(lv_stack_a.pop());
        System.out.println(lv_stack_a.peek());
        System.out.println(lv_stack_a.search(8));

        stack<String> lv_stack_b = new stack<String>(3);

        lv_stack_b.checkState();
        lv_stack_b.push("lkwoung");
        lv_stack_b.push("lkwoung2");
        lv_stack_b.push("lkwoung3");

        System.out.println(lv_stack_b.pop());
        System.out.println(lv_stack_b.peek());
        System.out.println(lv_stack_b.pop());
        System.out.println(lv_stack_b.pop());
        System.out.println(lv_stack_b.pop());
    }
}
