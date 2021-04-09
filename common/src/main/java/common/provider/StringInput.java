package common.provider;

public class StringInput implements Provider<Character> {

    private String input;
    private int position;

    public StringInput(String input) {
        this.input = input;
        this.position = 0;
    }

    @Override
    public void next() {
        this.position++;
    }

    @Override
    public Character get() {
        return this.input.charAt(this.position);
    }

    @Override
    public boolean hasNext() {
        try {
            this.input.charAt(this.position);
        }
        catch (StringIndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }
}
