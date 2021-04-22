package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

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
