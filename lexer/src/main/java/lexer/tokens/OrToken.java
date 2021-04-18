package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class OrToken extends Token {
  public OrToken() {
    super(Pattern.compile("\\|\\|", Pattern.MULTILINE));
  }

  public OrToken(String value) {
    super(Pattern.compile("\\|\\|", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new OrToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
