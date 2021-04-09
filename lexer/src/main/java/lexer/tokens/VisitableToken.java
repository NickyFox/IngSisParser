package lexer.tokens;


import lexer.TokenVisitor;

public interface VisitableToken {
    void accept(TokenVisitor visitor);
}
