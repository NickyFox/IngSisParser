package parser.states;

import lexer.tokens.*;
import parser.nodes.*;

public class OpenBracketParserState extends AbstractParserState {

    private ProgramNode programNode;

    public OpenBracketParserState() {
        this.programNode = new ProgramNode();
    }

    @Override
    public ASTNode getNode() {
        return this.programNode;
    }

    @Override
    public void visit(ClosingBracketToken token) {
        getTokenProvider().next();
    }

    @Override
    public void visit(IdentifierToken token) {
        getTokenProvider().next();

        programNode.add(
                new AssigmentNode(
                        new IdentifierNode(token.getValue()),
                        (ExpressionNode) new AssignationParserState().parse(getTokenProvider())));

        getTokenProvider().get().accept(this);
    }

    @Override
    public void visit(LetToken token) {
        getTokenProvider().next();
        programNode.add(new DeclarationParserState().parse(getTokenProvider()));
        getTokenProvider().get().accept(this);
    }

    @Override
    public void visit(PrintToken token) {
        getTokenProvider().next();
        programNode.add(new PrintParserState().parse(getTokenProvider()));
        getTokenProvider().get().accept(this);
    }

    @Override
    public void visit(IfToken token) {
        getTokenProvider().next();
        programNode.add(new IfParserState().parse(getTokenProvider()));
        getTokenProvider().get().accept(this);
    }

    @Override
    public void visit(SemicolonToken token) {
        getTokenProvider().next();
        getTokenProvider().get().accept(this);
    }
}
