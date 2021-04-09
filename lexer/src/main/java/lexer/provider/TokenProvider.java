package lexer.provider;

import common.provider.Provider;
import lexer.tokens.Token;

import java.util.Iterator;
import java.util.List;

public class TokenProvider implements Provider<Token> {

    private Iterator<Token> tokenIterator;
    private Token current;


    public TokenProvider(List<Token> tokens) {
        this.tokenIterator = tokens.iterator();
        this.next();
    }

    @Override
    public void next() {
        this.current = this.tokenIterator.next();
    }

    @Override
    public Token get() {
        return this.current;
    }

    @Override
    public boolean hasNext() {
        return tokenIterator.hasNext();
    }
}
