
public class ExpressionVariable extends ExpressionTerm{
	protected Integer var;
	public ExpressionVariable(int x){var=x;}
	public void setVariable(int x){var=x;}
	public Integer getValue(){return var;}
	public String toString(){return var.toString();}
	
}