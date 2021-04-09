package parser.states;

import common.exeptions.IllegalGrammarException;
import lexer.tokens.*;
import parser.nodes.*;

public class ExpressionParserState extends AbstractParserState {

    private ExpressionNode expressionNode;
    private boolean literal;

    public ExpressionParserState() {
        this.literal = false;
    }

    @Override
    public ExpressionNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(StringValueToken token) {
        checkStateLiteral();
        getTokenProvider().next();
        this.expressionNode = new StringNode(token.getValue());
        getTokenProvider().get().accept(this);
        this.expressionNode.setLeft(new StringNode(token.getValue()));
    }

    @Override
    public void visit(NumberValueToken token) {
        checkStateLiteral();
        getTokenProvider().next();
        this.expressionNode = new IntegerNode(Integer.valueOf(token.getValue()));
        getTokenProvider().get().accept(this);
        this.expressionNode.setLeft(new IntegerNode(Integer.valueOf(token.getValue())));
    }

    @Override
    public void visit(BooleanValueToken token) {
        checkStateLiteral();
        getTokenProvider().next();
        this.expressionNode = new BooleanNode(Boolean.parseBoolean(token.getValue()));
        getTokenProvider().get().accept(this);
        this.expressionNode.setLeft(new BooleanNode(Boolean.parseBoolean(token.getValue())));
    }

    @Override
    public void visit(IdentifierToken token) {
        checkStateLiteral();
        getTokenProvider().next();
        this.expressionNode = new IdentifierNode(token.getValue());
        getTokenProvider().get().accept(this);
        this.expressionNode.setLeft(new IdentifierNode(token.getValue()));
    }

    @Override
    public void visit(PlusToken token) {
        checkStateNotLiteral();
        getTokenProvider().next();
        this.expressionNode = new AdditionNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getTokenProvider()));
    }

    @Override
    public void visit(MinusToken token) {
        checkStateNotLiteral();
        getTokenProvider().next();
        this.expressionNode = new SubtractionNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getTokenProvider()));
    }

    @Override
    public void visit(MultiplicationToken token) {
        checkStateNotLiteral();
        getTokenProvider().next();
        this.expressionNode = new MultiplicationNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getTokenProvider()));
    }

    @Override
    public void visit(DivisionToken token) {
        checkStateNotLiteral();
        getTokenProvider().next();
        this.expressionNode = new DivisionNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getTokenProvider()));
    }

    @Override
    public void visit(AndToken token) {
        checkStateNotLiteral();
        getTokenProvider().next();
        this.expressionNode = new AndNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getTokenProvider()));
    }

    @Override
    public void visit(OrToken token) {
        checkStateNotLiteral();
        getTokenProvider().next();
        this.expressionNode = new OrNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getTokenProvider()));
    }

    @Override
    public void visit(ClosingParenthesisToken token) {
        checkStateNotLiteral();
        getTokenProvider().next();
    }



    @Override
    public void visit(SemicolonToken token) {
        checkStateNotLiteral();
    }

    private void checkStateLiteral() {
        if (literal) {
            throw new IllegalGrammarException();
        }
        this.literal = true;
    }

    private void checkStateNotLiteral() {
        if (!literal) {
            throw new IllegalGrammarException();
        }

        this.literal = false;
    }
}
