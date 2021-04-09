package lexer.tokens;


import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class MultiplicationToken extends Token {

    public MultiplicationToken() {
        super(Pattern.compile("\\*", Pattern.MULTILINE));
    }

    public MultiplicationToken(String value) {
        super(Pattern.compile("\\*", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new MultiplicationToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
