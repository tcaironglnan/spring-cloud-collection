# spring-cloud
Spring-Cloud的简单Demo

# 子项目说明:
    #1. client是客户端,可以认为是子服务,用于提供服务.
    #2. server是服务端,可以认为是注册中心.
    #3. ribbon是服务消费者,可以认为是消费者,该实现方式是rest+ribbon.
    #4. feign是服务消费者,可以认为是消费者,该实现方式是Feign
    #5. 
    
 
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