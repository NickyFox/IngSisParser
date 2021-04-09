package lexer.tokens;

import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class StringValueToken extends Token {

    public StringValueToken() {
        super(Pattern.compile("\".*\"", Pattern.MULTILINE));
    }

    public StringValueToken(String value) {
        super(Pattern.compile("\".*\"", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new StringValueToken(value);
    }
    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
