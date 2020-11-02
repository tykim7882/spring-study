package polimorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

//		TV samsungTV = new SamsungTV();
//		samsungTV.powerOn();
//		samsungTV.volumeUp();
//		samsungTV.volumeDown();
//		samsungTV.powerOff();
		
//		BeanFactory factory = new BeanFactory();
//		TV tv = (TV)factory.getBean(args[0]);
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		// 1. Spring 컨테이너를 구동 
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(LookUp) 
//		TV tv = (TV)factory.getBean("tv");	//getBean(bean id)
//		TV tv1 = (TV)factory.getBean("tv");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv");
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		System.out.println("*******************************");
		
//		TV lgTv = (TV)factory.getBean("lg");
//		lgTv.powerOn();
//		lgTv.volumeUp();
//		lgTv.volumeDown();
//		lgTv.powerOff();
		
		// 어노테이션 변경 후 
//		TV intelTv = (TV)factory.getBean("intel");
//		intelTv.powerOn();
//		intelTv.volumeUp();
//		intelTv.volumeDown();
//		intelTv.powerOff();
//		

		// 3. spring 컨테이너를 종료
		factory.close();
		
		// 스프링 컨테이너 종류
		// BeanFactory : 클라이언트 요청에 의해서만 lookup 
		// ApplicationContext : 트랜잭션, 다국어 처리등 다양한 기능 제공, 
		//                      컨테이너가 구동되는 시점에 객체를 생성(즉시 로딩)
		// GenericXmlApplicationContext(파일시스템이나 클래스경로의 xml 설정파일 로딩) / XmlWebApplicationContext (웹기반)
		
		// dependency injection (setter injection , constructor injection)
		// 객체 사이의 의존관계를 스프링 설정 파일에 등록된 정보를 바탕으로 컨테이너가 자동 처리 
		// 의존성 : 객체와의 결합 관계 
		// 
		
	}
	
}
