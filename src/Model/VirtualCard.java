package Model;

import java.time.LocalDate;

public class VirtualCard {
	
	private int cardCode;
	private int funds;
	private int CCV;
	private LocalDate expeditionDate;
	private LocalDate expirationDate;
	
	public VirtualCard(int cardCode,int funds,int CCV,LocalDate expeditionDate,LocalDate expirationDate) {
		this.cardCode=cardCode;
		this.funds=funds;
		this.CCV=CCV;
		this.expeditionDate=expeditionDate;
		this.expirationDate=expeditionDate;
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
	
	public void setExpeditionDate(LocalDate expeditionDate) {
		this.expeditionDate=expirationDate;
	}
	
	public LocalDate getExpeditionDate() {
		return expeditionDate;
	}
	
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate=expirationDate;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
}
