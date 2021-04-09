package parser.nodes;

import parser.ASTVisitor;

public class AndNode extends ExpressionNode {
    public AndNode(ExpressionNode expLeft, ExpressionNode expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
