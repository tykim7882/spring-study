package collections;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBeanList cBean = (CollectionBeanList)factory.getBean("collectionBeanList");
		
		System.out.println("***************  List  *****************");
		
		List<String> list = cBean.getAddressList();
		for(String addr : list) {
			System.out.println(addr);
		}
		
		System.out.println("*****************  Set ***************");
		
		CollectionBeanSet setBean = (CollectionBeanSet)factory.getBean("collectionBeanSet");
		Set<String> setList = setBean.getAddressList();
		for(String addr : setList) {
			System.out.println(addr);
		}
		
		System.out.println("*************   Map *******************");
		CollectionBeanMap mapBean = (CollectionBeanMap)factory.getBean("collectionBeanMap");
		Map<String, String> mapList = mapBean.getAddressList();
		for(String key : mapList.keySet()) {
			System.out.println(key + " ~ " + mapList.get(key) );
		}
		
		System.out.println("*************   Properties *******************");
		
		CollectionBeanProperties propBean = (CollectionBeanProperties)factory.getBean("collectionBeanProperties");
		Properties props = propBean.getAddressList();
		Enumeration<String> e = (Enumeration<String>) props.propertyNames();
			
		while(e.hasMoreElements()) {
			String element = e.nextElement();
			System.out.println(element + " = " + props.getProperty(element));
		}
		
		
		
	}

}
