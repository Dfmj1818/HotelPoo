package Model;

import java.time.LocalDate;
import java.util.Random;

public class VirtualCard {

	private int cardCode;
	private int funds;
	private int CCV;
	private LocalDate expirationDate;
	private Random randomFunds;
	
	public VirtualCard(User user,int cardCode,int CCV,LocalDate expirationDate) {
		this.cardCode=cardCode;
		this.funds=generateRandomFunds();
		this.CCV=CCV;
	
	}

	public void setCardCode(int cardCode) {
		this.cardCode=cardCode;
	}

	public int getCardCode() {
		return cardCode;
	}

	public void setFunds(int funds) {
		this.funds=funds;
	}

	public int getFunds() {
		return funds;
	}
	
	public void setCCV(int CCV) {
		this.CCV=CCV;
	}
	
	public int getCCV() {
		return CCV;
	}
	
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate=expirationDate;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

   public int generateRandomFunds() {
	   int funds=randomFunds.nextInt(500000);
	   return funds;
   }
   

}
