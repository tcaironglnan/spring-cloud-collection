# spring-cloud
Spring-Cloud的简单Demo

# 子项目说明:
    #1. service-server-client是客户端,可以认为是子服务,用于提供服务.
    #2. service-server是服务端,可以认为是注册中心.
    #3. service-ribbon是服务消费者,可以认为是消费者,该实现方式是rest+ribbon.
    #4. service-feign是服务消费者,可以认为是消费者,该实现方式是Feign
    #5. service-zuul是路由模块
    #6. service-config-server是配置服务模块
    #7. service-config-client是获取配置服务数据的客户端
    #8. service-zipkin是链路追踪的服务端
    #9. service-zipkin-client是被追踪的客户端
    #10. service-zipkinclient是被追踪的客户端
    #11. service-bus-amqp消息总线模块客户端
    #12. service-server-one集群服务器1
    #13. service-client-one集群客户端1
    #14. service-lucy是断路器聚合监控客户端
    #15. service-turbine是断路器聚合监控服务端
    #16. service-consul是服务注册模块
    
 
# 关于配置服务运行的和访问的问题:
    #1. 最新版本存在问题,目前还未找到原因,暂时使用低版本操作
 
# 关于仪表盘的使用说明:
    #1. 最新版本的springcloud使用方式注解,和依赖等和低版本一样
    #2. 除了#1之外,最新版本还需要多添加一个依赖:
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zuul</artifactId>
            <version>2.0.0.BUILD-SNAPSHOT</version>
        </dependency>
    #3. 除了#1和#2之外,在程序入口类中,还需要添加如下代码才能访问到/hystrix.stream界面:
        @Bean  
        public ServletRegistrationBean getServlet(){  
            HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();  
            ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);  
            registrationBean.setLoadOnStartup(1);  
            registrationBean.addUrlMappings("/hystrix.stream");  
            registrationBean.setName("HystrixMetricsStreamServlet");  
            registrationBean.setName("HystrixMetricsStreamServlet");  
            return registrationBean;  
          
        }
    #4. 访问 http://localhost:8764/hystrix 输入 http://localhost:8764/hystrix.stream 
        新打开一个页面 刷新http://localhost:8764/hi?name=forezp 仪表盘就会动
    #5. 如果不满足以上做法,则使用新版本会出现找不到页面问题.