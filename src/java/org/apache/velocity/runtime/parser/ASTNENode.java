/* Generated By:JJTree: Do not edit this line. ASTNENode.java */

package org.apache.velocity.runtime.parser;

import org.apache.velocity.Context;

public class ASTNENode extends SimpleNode
{
    public ASTNENode(int id)
    {
        super(id);
    }

    public ASTNENode(Parser p, int id)
    {
        super(p, id);
    }

    /** Accept the visitor. **/
    public Object jjtAccept(ParserVisitor visitor, Object data)
    {
        return visitor.visit(this, data);
    }

    public boolean evaluate(Context context)
    {
        if (jjtGetChild(0).value(context) instanceof Boolean &&
            ((Boolean)jjtGetChild(0).value(context)).booleanValue() !=
            ((Boolean)jjtGetChild(1).value(context)).booleanValue())
            return true;
        else if (jjtGetChild(0).value(context) instanceof Integer &&
            ((Integer)jjtGetChild(0).value(context)).intValue() !=
            ((Integer)jjtGetChild(1).value(context)).intValue())
            return true;
        else if (jjtGetChild(0).value(context) instanceof String &&
            ! jjtGetChild(0).value(context).toString()
            .equals(jjtGetChild(1).value(context).toString()))
            return true;
        else
            return false;
    }
}
