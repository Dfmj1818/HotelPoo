package Model;

import java.time.LocalDate;
import java.util.Random;

public class VirtualCard {

	private long cardCode;
	private int funds;
	private int CCV;
	private LocalDate expirationDate;


	public VirtualCard(User user,long cardCode,int CCV,LocalDate expirationDate) {	
		this.expirationDate=expirationDate;
		this.cardCode=cardCode;
		this.funds=generateRandomFunds();
		this.CCV=CCV;

	}

	public void setCardCode(long cardCode) {
		this.cardCode=cardCode;
	}

	public long getCardCode() {
		return cardCode;
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
		return  expirationDate;
	}
	//Se hizo Correccion 
	public int generateRandomFunds() {
		Random randomFunds=new Random();   
		return randomFunds.nextInt(500000)+350000;
	}



}
