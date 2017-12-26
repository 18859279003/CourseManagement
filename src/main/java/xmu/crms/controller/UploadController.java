package xmu.crms.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.crms.vo.Url;

@Controller("/upload")
/**
 * 上传文件控制器
 * @author Administrator
 *
 */
public class UploadController {
    
    @RequestMapping(value="/avatar", method=RequestMethod.POST)
    public Url uploadAvatar(HttpServletResponse response){
        Url url = new Url("/avatar/3486.png");
        response.setStatus(201);
        return url;
    }
}
