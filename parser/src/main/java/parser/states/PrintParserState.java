package parser.states;

import lexer.tokens.OpenParenthesisToken;
import parser.nodes.ASTNode;
import parser.nodes.ExpressionNode;
import parser.nodes.PrintNode;

public class PrintParserState extends AbstractParserState {

    private PrintNode printNode;

    public PrintParserState() {
        this.printNode = new PrintNode();
    }

    @Override
    public ASTNode getNode() {
        return this.printNode;
    }

    @Override
    public void visit(OpenParenthesisToken token) {
        getTokenProvider().next();
        this.printNode.setExpressionNode((ExpressionNode) new OpenParenthesisParserState().parse(getTokenProvider()));
    }
}
