package lexer.tokenizer;

import lexer.tokenizer.state.InvalidState;
import lexer.tokenizer.state.TokenizerState;
import lexer.tokens.*;

import java.util.Stack;

public class Tokenizer implements ITokenizer {

    private TokenizerState state;

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
        return "Tokenizer{" +
                "state=" + state +
                '}';
    }

    public static Stack<Tokenizer> getTokens(){
        Stack<Tokenizer> tokenizerStack = new Stack<>();
        //symbols
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

        //values
        tokenizerStack.push(new Tokenizer(new NumberValueToken()));
        tokenizerStack.push(new Tokenizer(new StringValueToken()));
        tokenizerStack.push(new Tokenizer(new BooleanValueToken()));
        tokenizerStack.push(new Tokenizer(new IdentifierToken()));
        return tokenizerStack;
    }
}
