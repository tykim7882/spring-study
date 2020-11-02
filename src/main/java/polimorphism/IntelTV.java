package polimorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("intel")
public class IntelTV implements TV{
	
//	@Autowired
//	@Qualifier("apple")
	@Resource(name="sony")
	private Speaker speaker;

	@Override
	public void powerOn() {
		System.out.println("IntelTV 를 켠다 ");
	}

	@Override
	public void powerOff() {
		System.out.println("IntelTV 를 끈다");
	}

	@Override
	public void volumeUp() {
		//System.out.println("IntelTV 볼륩을 높인다");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
//		System.out.println("IntelTV 볼륨을 낮춘다.");
		speaker.volumeDown();
	}

}
