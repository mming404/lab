package soa.lab1.part1;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2025/5/26
 * @Version V1.0
 **/
public class JWSClient {
    public static void main(String[] args) {
        // 创建服务实例
        JWSofYangsmService service = new JWSofYangsmService();

        // 获取服务端口
        JWSofYangsm port = service.getJWSofZhangSPort();

        // 调用Web Service方法
        String result = port.jwsHelloZhangS("3122004756");

        System.out.println("响应结果：\n" + result);
    }
}
