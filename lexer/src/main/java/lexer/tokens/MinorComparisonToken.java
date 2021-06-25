package lexer.tokens;

import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class MinorComparisonToken extends Token {

  public MinorComparisonToken() {
    super(Pattern.compile("<", Pattern.MULTILINE));
  }

  public MinorComparisonToken(String value) {
    super(Pattern.compile("<", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new MinorComparisonToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
