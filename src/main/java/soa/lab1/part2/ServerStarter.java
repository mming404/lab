package soa.lab1.part2;// ServerStarter.java

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class ServerStarter {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(CXFofYangSM.class);
        factory.setAddress("http://localhost:9000/cxfService");
        factory.create();
        System.out.println("CXF服务已启动，WSDL地址：http://localhost:9000/cxfService?wsdl");
    }
}