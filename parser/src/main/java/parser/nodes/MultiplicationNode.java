package parser.nodes;

import parser.ASTVisitor;

public class MultiplicationNode extends parser.nodes.ExpressionNode {

    public MultiplicationNode(ExpressionNode expLeft, ExpressionNode expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
