package Try;

public class Test{
public void main(String[] args){
	CreditCard wallet[]=new CreditCard[10];
	wallet[0]=new CreditCard("23665656","Jonhn","California Savings",0.0,2500);
	wallet[1]=new CreditCard("36595656","Jonhn","California Federal",0.0,3500);
	wallet[2]=new CreditCard("63665606","Jonhn","California Finance",0.0,5000);
	for(int i=1;i<=16;i++){
		wallet[0].chargelt((double)i);
		wallet[1].chargelt(2.0*i);
		wallet[2].chargelt((double)3*i);
	}
	for(int i=0;i<3;i++){
		CreditCard.printCard(wallet[i]);
		while(wallet[i].getBalance()>100.0){
			wallet[i].makePayment(100.0);
			System.out.println("New balance ="+wallet[i].getBalance());
		}
	}
	}
}
