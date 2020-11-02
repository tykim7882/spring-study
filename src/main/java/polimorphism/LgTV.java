package polimorphism;

import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV{
	
	private Speaker speaker;
	private int price;
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void powerOn() {
		System.out.println("LG 티비를 켠다 가격 : " + price);
	}

	public void powerOff() {
		System.out.println("LG 티비를 끈다");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

}
