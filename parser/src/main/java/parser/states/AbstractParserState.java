package parser.states;

import common.exeptions.IllegalGrammarException;
import common.provider.Provider;
import lexer.tokens.*;
import lexer.TokenVisitor;
import parser.nodes.ASTNode;

public abstract class AbstractParserState implements ParserState, TokenVisitor {

    private Provider<VisitableToken> tokenProvider;

    @Override
    public ASTNode parse(Provider<VisitableToken> input) {
        this.tokenProvider = input;
        input.get().accept(this);
        return getNode();
    }

    public abstract ASTNode getNode();

    public Provider<VisitableToken> getTokenProvider() {
        return this.tokenProvider;
    }

    @Override
    public void visit(AssignationToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(BooleanTypeToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(BooleanValueToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(ClosingParenthesisToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(DivisionToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(EOFToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(IdentifierToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(LetToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(MinusToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(MultiplicationToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(NumberValueToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(NumberTypeToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(OpenParenthesisToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(PlusToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(PrintToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(SemicolonToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(StringValueToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(StringTypeToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(TypeAssignationToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(AndToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(OrToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(IfToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(OpenBracketToken token) {
        throw new IllegalGrammarException(token.getValue());
    }

    @Override
    public void visit(ClosingBracketToken token) {
        throw new IllegalGrammarException(token.getValue());
    }
}
