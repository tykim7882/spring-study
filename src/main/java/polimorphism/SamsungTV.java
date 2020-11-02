package polimorphism;

import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("삼성 티비 객체 생성(1)");
	}
	
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("삼성 티비 객체 생성(2)");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public SamsungTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
		System.out.println("삼성 티비 객체 생성(3)");
	}

	public void powerOn() {
		System.out.println("삼성 티비를 켠다 ==> 가격 : " + price);
	}

	public void powerOff() {
		System.out.println("삼성 티비를 끈다");
	}

	public void volumeUp() {
//		speaker = new SonySpeaker();
		speaker.volumeUp();
//		System.out.println("삼성 티비 볼륨을 올린다");
	}

	public void volumeDown() {
//		speaker = new SonySpeaker();
		speaker.volumeDown();
//		System.out.println("삼성 티비 볼륨을 내린다.");
	}
	
	public void initMethod() {
		System.out.println("삼성 티비 객체 생성 후 초기처리 작업");
	}

	public void destroyMethod() {
		System.out.println("삼성 티비 객체 삭제 전 처리작업");
	}
}
