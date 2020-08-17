package com.wipe.healthy.web.controller;

import com.github.bingoohuang.patchca.color.ColorFactory;
import com.github.bingoohuang.patchca.custom.ConfigurableCaptchaService;
import com.github.bingoohuang.patchca.filter.predefined.*;
import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;
import com.github.bingoohuang.patchca.word.RandomWordFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * 生成登陆验证码
 * User:Created by wei.li
 * Date: on 2015/9/2.
 * Time:9:47
 */

@Controller
@RequestMapping(value = "/verification")
public class VerificationCodeController {

    private static ConfigurableCaptchaService cs = new ConfigurableCaptchaService();

    private static Random random = new Random();

    //随机生成字母，数字，颜色
    static {
        cs.setColorFactory(new ColorFactory() {
            @Override
            public Color getColor(int i) {
                int[] c= new  int[3];

                //生成随机数
                int x=random.nextInt(c.length);

                for (int j=0;j<c.length;j++){
                    if (j == x){
                        c[j] = random.nextInt(71);
                    }else {
                        c[j]=random.nextInt(256);
                    }
                }
                return new Color(c[0],c[1],c[2]);
            }
        });
        RandomWordFactory wf = new RandomWordFactory();
        wf.setCharacters("23456789abcdefghigkmnpqrstuvwxyzABCDEFGHIGKLMNPQRSTUVWXYZ");
        wf.setMaxLength(4);
        wf.setMinLength(4);
        cs.setWordFactory(wf);
    }


    @RequestMapping("/crimg")
    public void crimg(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        //随机样式
        switch (random.nextInt(5)) {
            case 0:
                cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
                break;
            case 1:
                cs.setFilterFactory(new MarbleRippleFilterFactory());
                break;
            case 2:
                cs.setFilterFactory(new DoubleRippleFilterFactory());
                break;
            case 3:
                cs.setFilterFactory(new WobbleRippleFilterFactory());
                break;
            case 4:
                cs.setFilterFactory(new DiffuseRippleFilterFactory());
                break;
        }
        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession();
        }
        setResponseHeaders(response);
        String token = EncoderHelper.getChallangeAndWriteImage(cs, "png", response.getOutputStream());
        session.setAttribute("captchaToken", token);
        System.out.println("当前的SessionID=" + session.getId() + "，验证码=" + token);
    }


    protected  void  setResponseHeaders(HttpServletResponse response){
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
    }
}
