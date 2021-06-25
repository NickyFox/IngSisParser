package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class StringValueToken extends Token {

  public StringValueToken() {
    super(Pattern.compile("\".*\"", Pattern.MULTILINE));
  }

  public StringValueToken(String value) {
    super(Pattern.compile("\".*\"", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new StringValueToken(value.replaceAll("\"", ""));
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
