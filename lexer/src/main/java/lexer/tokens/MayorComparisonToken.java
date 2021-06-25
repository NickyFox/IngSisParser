package lexer.tokens;

import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class MayorComparisonToken extends Token{

    public MayorComparisonToken() {
        super(Pattern.compile(">", Pattern.MULTILINE));
    }

    public MayorComparisonToken(String value) {
        super(Pattern.compile(">", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new MayorComparisonToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
