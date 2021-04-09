package parser.nodes;

import parser.ASTVisitor;

public class OrNode extends ExpressionNode {
    public OrNode(ExpressionNode expLeft, ExpressionNode expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
