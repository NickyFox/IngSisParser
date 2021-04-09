package interpreter.value;

public class BooleanValue implements Value {
    private final String TYPE = "boolean";
    private Boolean v;

    public BooleanValue(Boolean value) {
        this.v = value;
    }

    @Override
    public Value and(BooleanValue value) {
        return new BooleanValue(getValue() && value.getValue());
    }

    @Override
    public Value or(BooleanValue value) {
        return new BooleanValue(getValue() || value.getValue());
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

    public Boolean getValue() {
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
