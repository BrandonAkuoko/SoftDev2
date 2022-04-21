package ds;

public class Container<T>{ // Type parameter
    private T value;
    private Object[] elements;

    public Container(T value){
        this.value = value;
        elements = new Object[5]; //will not work -- > must use Object

    }
    public T getValue(){return this.value;}
    public void setValue(T value){this.value = value;}

    public static void main(String[] args) {
        Container<String> object = new Container<>("Bobby");
        String value = object.getValue();
        System.out.println(value);

        Container<Integer> container = new Container<>(15);
        int value2 = container.getValue();
        /* Auto boxing vs unboxing
        primitive type vs Wrapper classes
        int ---- Integer 
        double --- Double
        char --- Character
        */
        Integer intOnj = 15; // 15 --> new Integer(15), auto boxing
    }
}
