package lexer.tokens;

import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class StringTypeToken extends Token {

    public StringTypeToken() {
        super(Pattern.compile("string", Pattern.MULTILINE));
    }

    public StringTypeToken(String value) {
        super(Pattern.compile("string", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new StringTypeToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
