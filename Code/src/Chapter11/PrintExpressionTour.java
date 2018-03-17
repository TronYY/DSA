
public class PrintExpressionTour extends EulerTour<ExpressionTerm,String>{
	public String execute(BinaryTree<ExpressionTerm>T){
		init(T);
		System.out.println("Expression:");
		eulerTour(T.root());
		System.out.println();
		return null;
	}
	
	protected void visitLeft(Position<ExpressionTerm> v,TourResult<String> r){
		if (tree.isInternal(v)) System.out.print("("));
	}
	
	protected void visitBelow(Position<ExpressionTerm> v,TourResult<String> r){
		System.out.print(v.element());
	}
	
	protected void visitRight(Position<ExpressionTerm> v,TourResult<String> r){
		if (tree.isInternal(v)) System.out.print("("));
	}
	
	
}
