import java.util.List;

public class Block extends  ASTNode{
    List<ASTNode> statements;
    public Block(List<ASTNode> statements){

    }
    @Override
    public void print(String indent){
        for(ASTNode node: statements){
            node.print("   ");

        }
    }

}
