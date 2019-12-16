##免费天气接口说明

1. 当前天气接口是用Springboot2.1.11 集成 Ehcache。
2. 接口由https://www.sojson.com 免费提供。
3. 用于个人学习，小型网站，商业用途请联系站长付费。
4. 具体接口规则请查看：https://www.sojson.com/blog/305.html 

##技术讲解
1. 请求 sojson 采用了RestTemplate请求，具体看 WeatherManager.java
2. 缓存采用 Ehcache ，配置文件请看 ehcache.xml 这里采用了ttl配置。解决了缓存过期和更新的问题。

##项目使用

 项目启动后，比如访问北京的天气，链接为：http://127.0.0.1:8972/api/city/101010100 
