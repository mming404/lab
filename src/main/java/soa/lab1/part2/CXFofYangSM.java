package soa.lab1.part2;// CXFofZhangS.java
import javax.jws.WebService;

@WebService(endpointInterface = "soa.lab1.part2.CXFService")
public class CXFofYangSM implements CXFService {
    
    @Override
    public String CXFHelloZhangS(String studentId) {
        // 根据学号生成响应（示例逻辑）
        return String.format("学院：计算机学院 | 班级：软件2班 | 姓名：杨思铭 | 籍贯：广东",
                          studentId.substring(2,4));
    }
}