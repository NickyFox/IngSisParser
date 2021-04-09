package lexer.tokens;

import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class OpenParenthesisToken extends Token {

    public OpenParenthesisToken() {
        super(Pattern.compile("\\(", Pattern.MULTILINE));
    }

    public OpenParenthesisToken(String value) {
        super(Pattern.compile("\\(", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new OpenParenthesisToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
