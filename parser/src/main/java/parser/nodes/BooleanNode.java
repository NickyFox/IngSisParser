package parser.nodes;

import parser.ASTVisitor;

public class BooleanNode extends ExpressionNode {
    private Boolean value;

    public BooleanNode(Boolean value) {
        super();
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
