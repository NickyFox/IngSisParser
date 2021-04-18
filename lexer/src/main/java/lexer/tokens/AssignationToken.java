package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class AssignationToken extends Token {

  public AssignationToken() {
    super(Pattern.compile("=", Pattern.MULTILINE));
  }

  public AssignationToken(String value) {
    super(Pattern.compile("=", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new AssignationToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
