package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class MinorIgualComparisonToken extends Token {

  public MinorIgualComparisonToken() {
    super(Pattern.compile("<=", Pattern.MULTILINE));
  }

  public MinorIgualComparisonToken(String value) {
    super(Pattern.compile("<=", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new MinorIgualComparisonToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
