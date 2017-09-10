package org.banque;

import org.banque.rmi.BanqueRmiRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfig {

	
	@Autowired
	private SimpleJaxWsServiceExporter exporter;

//	@Autowired
//	private RmiServiceExporter rmiExporter;
//	
	@Bean
	public SimpleJaxWsServiceExporter getJaxWs() {
		exporter.setBaseAddress("http://localhost:8089/MaBanque");
		return exporter;
	}
	
	@Bean
	public RmiServiceExporter getRmiExporter(ApplicationContext ctx){
		RmiServiceExporter rmiExporter = new RmiServiceExporter();
		rmiExporter.setService(ctx.getBean("myRmiService"));
		rmiExporter.setRegistryPort(1099);
		rmiExporter.setServiceName("BK");
		rmiExporter.setServiceInterface(BanqueRmiRemote.class);
		return rmiExporter;
	}

	//	@Bean
	//	public SimpleJaxWsServiceExporter getJaxWs(){
	//		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
	//		exporter.setBaseAddress("http://localhost:8089/MaBanque");
	//		return exporter;
	//	}
	
}
