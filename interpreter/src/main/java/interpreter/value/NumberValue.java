package interpreter.value;

public class NumberValue implements Value {

    private final String TYPE = "number";
    private Integer v;

    public NumberValue(Integer value) {
        this.v = value;
    }

    @Override
    public Value plus(StringValue value) {
        return new StringValue(v + value.getValue());
    }

    @Override
    public Value plus(NumberValue value) {
        return new NumberValue(value.getValue() + v);
    }

    @Override
    public Value minus(NumberValue value) {
        return new NumberValue(value.getValue() - v);
    }

    @Override
    public Value times(NumberValue value) {
        return new NumberValue(value.getValue() * v);
    }

    @Override
    public Value divide(NumberValue value) {
        if (this.v == 0) {
            throw new ArithmeticException("Can not divide by zero");
        }

        return new NumberValue(v / value.getValue());
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

    public Integer getValue() {
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
