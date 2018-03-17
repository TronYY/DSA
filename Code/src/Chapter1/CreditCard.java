package Chapter1;

public class CreditCard {
	//Instance variables:
	private String number,name,bank;
	private double balance;
	private int limit;
	//Constructor:
	CreditCard(String no,String nm,String bk,double bal,int lim){
		number=no;
		name=nm;
		balance=bal;
		limit=lim;
	}
	//Accessor methods:
	public String getNumber(){
		return number;
	}
	public String getName(){
		return name;
	}
	public String getBank() {
		return bank;
	}
	public double getBalance(){
		return balance;
	}
	public int getLimit(){
		return limit;
	}
	//Action methods:
	public boolean chargelt(double price){//Make a charge
		if (price+balance>(double)limit)
			return false;//There is not enough money left to charge it
		balance+=price;
		return true;//The charge goes through in this case
	}
	public void makePayment(double payment){//Make a payment
		
		balance-=payment;
	}
	public static void printCard(CreditCard c){//Print a card's information
		System.out.println("Number="+c.getNumber());
		System.out.println("Name="+c.getName());
		System.out.println("Bank="+c.getBank());
		System.out.println("Balance="+c.getBalance());//Implicit cast
		System.out.println("Limit="+c.getLimit());//Implicit cast	
	}
}