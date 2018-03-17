
public class EvaluateExceptionTour extends EulerTour<ExpressionTerm,Integer>{
	public Integer execute(BinaryTree<ExpressionTerm>T){
		init(T);
		return eulerTour(tree.root());
	}
	public void visitRight(Position<ExpressionTerm> v,TourResult<Integer> r){
		ExpressionTerm term=v.element();
		if(tree.isInternal(v)){
			ExpressionOperator op=(ExpressionOperator)term;
			op.setOperands(r.left, r.right);
		}
		r.out=term.getValue();	
	}
}
