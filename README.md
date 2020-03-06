# 1、本项目为Eureka测试demo
# 2、注意
为了模拟出集群的效果， 在C:\Windows\System32\drivers\etc中，在host文件中加入
```
127.0.0.1       eureka7001.com
127.0.0.1       eureka7002.com
127.0.0.1       eureka7003.com
```
来模拟出集群的效果。
# 3、教程
- 1、项目搭建完毕之后，先启动7001、7002、7003，这三个是注册中心Eureka的集群，启动之后访问
```
http://eureka7001.com:7001/
http://eureka7002.com:7002/
http://eureka7003.com:7003/
```
就可以看到Eureka的服务注册页面了，同时每个会分别显示另外两个端口。
然后启动provider，这是服务提供者。刷新上面几个网站，就可以看到服务在上边注册了。

- 2、其中consumer-dept-80与consumer-dept-feign都使用了80 端口。只不过第一个使用了ribbon，第二个使用了feign
- 3、如果springcloud-api中pojo开启了lombok的注解但是不生效的话，则需要在idea中引入lombok插件

# 4、note
- 1、服务熔断与服务降级

服务熔断相当于是说，在服务端某一个方法出现异常或者超时了，这时候需要让他走备用方法，相当于是保险丝，所以在服务端；
服务降级是从整体网站请求负载考虑，当某个服务熔断或者关闭之后，服务端将不再被调用，此时再客户端，我们可以准备一个FallbackFactory，返回一个默认值，整体服务水平下降了，但是好歹能用。

- 2、hystrixDashoboard监控的是具有熔断机制的方法，不能监控一般的方法

- 3、在springcloud-config中，报错：org.eclipse.jgit.api.errors.TransportException: https://github.com/lifelinezhang/springcloud-config.git: cannot open git-upload-pack，
是因为我在浏览器上开了麦克儿代理，关掉就好了

# 5、后记
这个视频看了这么多天，终于看完了，现在只是大概理解这一套东西，想要熟练还要自己动手多写写才可以。