package activities;

import jdk.internal.icu.text.NormalizerBase.Mode;

public class Model {
    private int count;

    public Model(int count){this.count = 0;}

    public int getCount() {
        return count;
    }
    public void increase(){this.count++;}

}
