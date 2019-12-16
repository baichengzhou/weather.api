package com.sojson.weather.api.demo.web;



import com.sojson.weather.api.demo.dto.WeatherDto;
import com.sojson.weather.api.demo.service.WeatherManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class WeatherAPIContoller {

    @Autowired
    WeatherManager weatherManager;
    //用来校验传参是否正确
    @Value("${city.code}")
    private String cityCode;
    /**
     * 天气数据
     * @param id
     * @return
     */
    @RequestMapping(value = "city/{id:1[0-9]{8}}", method = RequestMethod.GET)
    public WeatherDto loadApi(@PathVariable("id") String id){
        String vliCode = String.format(",%s,", id);
        if(!cityCode.contains(vliCode)){
            throw new RuntimeException("no_city_id");
        }
        return weatherManager.getById(id);

    }
}
