package lexer.tokenizer;

import java.util.Map;
import java.util.Stack;
import lexer.tokenizer.state.InvalidState;
import lexer.tokenizer.state.TokenizerState;
import lexer.tokens.*;

public class Tokenizer implements ITokenizer {

  private TokenizerState state;

  private Map<String, Stack<Tokenizer>> tokens;

  public Tokenizer(Token token) {
    this.state = new InvalidState(token);
  }

  public Tokenizer(TokenizerState state) {
    this.state = state;
  }

  public boolean isValid() {
    return this.state.isValid();
  }

  public ITokenizer change(String str) {
    return new Tokenizer(this.state.change(str));
  }

  @Override
  public Token getToken() {
    return this.state.getToken();
  }

  @Override
  public String toString() {
    return "Tokenizer{" + "state=" + state + '}';
  }

  public static Stack<Tokenizer> getTokens(String v) {
    switch (v) {
      case "1.0":
        return getTokensV1();
      case "1.1":
        return getTokensV2();
      default:
        return new Stack<>();
    }
  }

  private static Stack<Tokenizer> getTokensV1() {
    Stack<Tokenizer> tokenizerStack = new Stack<>();
    // symbols
    tokenizerStack.push(new Tokenizer(new EOFToken()));
    tokenizerStack.push(new Tokenizer(new SemicolonToken()));
    tokenizerStack.push(new Tokenizer(new TypeAssignationToken()));
    tokenizerStack.push(new Tokenizer(new LetToken()));
    tokenizerStack.push(new Tokenizer(new StringTypeToken()));
    tokenizerStack.push(new Tokenizer(new NumberTypeToken()));
    tokenizerStack.push(new Tokenizer(new BooleanTypeToken()));
    tokenizerStack.push(new Tokenizer(new AssignationToken()));
    tokenizerStack.push(new Tokenizer(new ClosingParenthesisToken()));
    tokenizerStack.push(new Tokenizer(new OpenParenthesisToken()));
    tokenizerStack.push(new Tokenizer(new DivisionToken()));
    tokenizerStack.push(new Tokenizer(new MinusToken()));
    tokenizerStack.push(new Tokenizer(new PlusToken()));
    tokenizerStack.push(new Tokenizer(new MultiplicationToken()));
    tokenizerStack.push(new Tokenizer(new PrintToken()));
    tokenizerStack.push(new Tokenizer(new AndToken()));
    tokenizerStack.push(new Tokenizer(new OrToken()));
    tokenizerStack.push(new Tokenizer(new IfToken()));
    tokenizerStack.push(new Tokenizer(new OpenBracketToken()));
    tokenizerStack.push(new Tokenizer(new ClosingBracketToken()));
    tokenizerStack.push(new Tokenizer(new MayorComparisonToken()));
    tokenizerStack.push(new Tokenizer(new MinorComparisonToken()));

    // values
    tokenizerStack.push(new Tokenizer(new NumberValueToken()));
    tokenizerStack.push(new Tokenizer(new StringValueToken()));
    tokenizerStack.push(new Tokenizer(new BooleanValueToken()));
    tokenizerStack.push(new Tokenizer(new IdentifierToken()));
    return tokenizerStack;
  }

  private static Stack<Tokenizer> getTokensV2() {
    Stack<Tokenizer> tokenizerStack = new Stack<>();
    // symbols
    tokenizerStack.push(new Tokenizer(new EOFToken()));
    tokenizerStack.push(new Tokenizer(new SemicolonToken()));
    tokenizerStack.push(new Tokenizer(new TypeAssignationToken()));
    tokenizerStack.push(new Tokenizer(new LetToken()));
    tokenizerStack.push(new Tokenizer(new StringTypeToken()));
    tokenizerStack.push(new Tokenizer(new NumberTypeToken()));
    tokenizerStack.push(new Tokenizer(new BooleanTypeToken()));
    tokenizerStack.push(new Tokenizer(new AssignationToken()));
    tokenizerStack.push(new Tokenizer(new ClosingParenthesisToken()));
    tokenizerStack.push(new Tokenizer(new OpenParenthesisToken()));
    tokenizerStack.push(new Tokenizer(new DivisionToken()));
    tokenizerStack.push(new Tokenizer(new MinusToken()));
    tokenizerStack.push(new Tokenizer(new PlusToken()));
    tokenizerStack.push(new Tokenizer(new MultiplicationToken()));
    tokenizerStack.push(new Tokenizer(new PrintToken()));
    tokenizerStack.push(new Tokenizer(new AndToken()));
    tokenizerStack.push(new Tokenizer(new OrToken()));
    tokenizerStack.push(new Tokenizer(new IfToken()));
    tokenizerStack.push(new Tokenizer(new OpenBracketToken()));
    tokenizerStack.push(new Tokenizer(new ClosingBracketToken()));
    tokenizerStack.push(new Tokenizer(new ConstToken()));
    tokenizerStack.push(new Tokenizer(new MayorComparisonToken()));
    tokenizerStack.push(new Tokenizer(new MinorComparisonToken()));

    // values
    tokenizerStack.push(new Tokenizer(new NumberValueToken()));
    tokenizerStack.push(new Tokenizer(new StringValueToken()));
    tokenizerStack.push(new Tokenizer(new BooleanValueToken()));
    tokenizerStack.push(new Tokenizer(new IdentifierToken()));
    return tokenizerStack;
  }
}
