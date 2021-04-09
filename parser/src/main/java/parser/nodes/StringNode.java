package parser.nodes;

import parser.ASTVisitor;

public class StringNode extends ExpressionNode {

    private String value;

    public StringNode(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
