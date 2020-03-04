# 1、本项目为Eureka测试demo
# 2、注意
为了模拟出集群的效果， 在C:\Windows\System32\drivers\etc中，在host文件中加入
```
127.0.0.1       eureka7001.com
127.0.0.1       eureka7002.com
127.0.0.1       eureka7003.com
```
来模拟出集群的效果。
# 3、数据库及其简单，就只有一张表
# 4、教程
项目搭建完毕之后，先启动7001、7002、7003，这三个是注册中心Eureka的集群，启动之后访问
```
http://eureka7001.com:7001/
http://eureka7002.com:7002/
http://eureka7003.com:7003/
```
就可以看到Eureka的服务注册页面了，同时每个会分别显示另外两个端口。
然后启动provider，这是服务提供者。刷新上面几个网站，就可以看到服务在上边注册了。
