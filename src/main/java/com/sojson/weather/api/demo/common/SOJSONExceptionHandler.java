package com.sojson.weather.api.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * ---
 * <p>
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2017年11月19日 01:46 　<br/>
 *
 * @author zhou-baicheng
 * @version 1.0<br/>
 * @email so@sojson.com
 */
@ControllerAdvice
public class SOJSONExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

            ModelAndView mv = new ModelAndView();

            // set status code
            response.setStatus(HttpStatus.BAD_REQUEST.value());

            // set content type
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            // set character encoding
            response.setCharacterEncoding("UTF-8");

            response.setHeader("Cache-Control", "no-cache, must-revalidate");


            String message = e.getMessage();
            String remsg = "抱歉，您的请求出现异常，我们已经监控到异常信息。您可以尝试再次请求。多次出现异常或需要更快的解决，加QQ群：608222884，验证消息 sojson api，反馈问题。";
            int status = 400;
            if("no_city_id".equalsIgnoreCase(message)){
                remsg = "CityId不在返回之内,加QQ群：608222884，验证消息 sojson api，反馈问题。";
                status = 403;
            }
            if(null != message){
                remsg = message;
            }
            try {
                response.getWriter().write(String.format("{\"status\":%s,\"message\":\"%s\"}",status,remsg));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        return mv;
    }
}
