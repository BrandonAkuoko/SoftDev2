package inner;

import java.util.*;

public class StringIterator implements Iterator<Character> {
    private String string;
    private int index;

    public StringIterator(String string) {
        this.string = string;
        this.index = 0;
    }
    @Override
    public boolean hasNext() {
        return index < string.length();
    }
    @Override
    public Character next() {
        Character ch = string.charAt(index);
        index++;
        return ch;
    }
    public static Iterable<Character> iterableString(String string) {
        class IterableString implements Iterable<Character> {
            @Override
            public Iterator<Character> iterator() {
                return new StringIterator(string);
            }
        }
        Iterable<Character> iterableString = new IterableString();
        return iterableString;
    }

    public static void main(String[] args) {
        Iterable<Character> iterableStr = iterableString("Hello World!");
        for(Character ch : iterableStr) {
            System.out.println(ch);
        }
    }
}