package lexer.tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token implements VisitableToken {

    private Pattern pattern;
    private String value;
    private Integer line;
    private Integer column;

    Token(Pattern pattern) {
        this.pattern = pattern;
        this.value = null;
    }

    Token(Pattern pattern, String lexeme) {
        this.pattern = pattern;
        this.value = lexeme;
    }

    public Matcher getMatcher(String string){
        return pattern.matcher(string);
    }

    public abstract Token withValue(String value);

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
