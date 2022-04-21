package inner;

public class OuterClass {
    public class InnerClass {
        private String name;
        public InnerClass (String name) {
            this.name = name;
        }
        public String getName() {
            return name + age;
        }
    }

    private int age;
    private InnerClass inner;
    public OuterClass () {
        inner = new InnerClass ("Inside" + inner.name);
        this.age = 10;
    }
}

