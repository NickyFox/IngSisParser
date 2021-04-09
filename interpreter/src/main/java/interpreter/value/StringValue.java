package interpreter.value;

public class StringValue implements Value {

    private final String TYPE = "string";
    private String v;

    public StringValue(String value) {
        this.v = value;
    }

    @Override
    public Value plus(StringValue value) {
        return new StringValue(v + value.getValue());
    }

    @Override
    public Value plus(NumberValue value) {
        return new StringValue(v + value.getValue());
    }

    @Override
    public Value divide(Value value) {
        return value.divide(this);
    }

    @Override
    public Value times(Value value) {
        return value.times(this);
    }

    @Override
    public Value plus(Value value) {
        return value.plus(this);
    }

    @Override
    public Value minus(Value value) {
        return value.minus(this);
    }

    @Override
    public Value and(Value value) {
        return value.and(this);
    }

    @Override
    public Value or(Value value) {
        return value.or(this);
    }

    @Override
    public String getValue() {
        return this.v;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public boolean is(String type) {
        return type.equals(getType());
    }
}
