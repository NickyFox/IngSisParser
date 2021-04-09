package lexer.tokens;



import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class ClosingParenthesisToken extends Token {

    public ClosingParenthesisToken() {
        super(Pattern.compile("\\)", Pattern.MULTILINE));
    }

    public ClosingParenthesisToken(String value) {
        super(Pattern.compile("\\)", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new ClosingParenthesisToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
