package lexer.tokenizer.state;

import lexer.tokens.Token;

import java.util.regex.Matcher;

public class ValidState implements TokenizerState {

    Token token;

    public ValidState(Token token) {
        this.token = token;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public TokenizerState change(String str) {
        Matcher matcher = token.getMatcher(str);
        if (matcher.find() && matcher.group(0).equals(str)) {
            token = token.withValue(str);
            return this;
        }
        return new InvalidState(token);
    }

    @Override
    public Token getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "ValidState{" +
                "token=" + token +
                '}';
    }
}
