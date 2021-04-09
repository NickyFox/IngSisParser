package lexer.tokenizer.state;

import lexer.tokens.Token;

import java.util.regex.Matcher;

public class InvalidState implements TokenizerState {

    Token token;

    public InvalidState(Token token) {
        this.token = token;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public TokenizerState change(String str) {
        Matcher matcher = token.getMatcher(str);
        if (matcher.find() && matcher.group(0).equals(str)) {
            return new ValidState(token.withValue(str));
        }
        else return this;
    }

    @Override
    public Token getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "InvalidState{" +
                "token=" + token +
                '}';
    }
}
