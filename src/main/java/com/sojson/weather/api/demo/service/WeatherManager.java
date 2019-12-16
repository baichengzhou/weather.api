package com.sojson.weather.api.demo.service;



import com.sojson.weather.api.demo.dto.WeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class WeatherManager {
    //请求连接地址
    final static String SOJSON_WEATHER_URL = "http://t.weather.sojson.com/api/weather/city/{1}";

    /**
     * 获取数据
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "weather_cache", key = "#id")// 从缓存获取，key为ID，缓存具体看 ehcache.xml 配置文件
    public WeatherDto getById(String id) {
        log.info("WeatherManager#getById: id={}", id);

        try {
            RestTemplate restTemplate = new RestTemplate();
            WeatherDto dto = restTemplate.getForObject(SOJSON_WEATHER_URL , WeatherDto.class,id);

            if(dto != null && dto.isSuccess()){
                return dto;
            }else{
                log.error("获取天气数据返回错误：{}", dto);
            }
        } catch (RestClientException e) {
            log.error("获取天气数据返回错误，出现异常.", e);
        }
        return null;
    }

}
