package polimorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("애플스피커 객체 생성");
	}

	@Override
	public void volumeUp() {
		System.out.println("애플스피커 볼륨을 올린다 .");
	}

	@Override
	public void volumeDown() {
		System.out.println("애플스피커 볼륨을 낮춘다.");
	}

}
