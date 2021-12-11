package com.zking.controller;

import com.sun.deploy.net.HttpResponse;
import com.zking.model.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

@Controller
public class IndexController {

    @ModelAttribute
    public void tranData(Model model){
        User user=new User();
        model.addAttribute("user",user);
    }


    @RequestMapping("/login")
    public String goLogin(){
        return "login";
    }

    public String index(){
        return "index";
    }

    @RequestMapping("/changeLanguage")
    public String changeLanguage(HttpSession session){
        Locale local=(Locale)session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        if(null==local){
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
        }
        else if("CN".equals(local.getCountry())){
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
        }else{
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        }
        return "redirect:login";
    }

    @RequestMapping("/dologin")
    public String login(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("王婷大傻逼");
            return "login";
        }
        if(null!=user){
            if(user.getUsername().equals("admin")&&user.getPassword().equals("123")){
              return "main";
            }
        }
        return "redirect:login";
    }

    @RequestMapping("/goUpload")
    public String goUpload(){
        return "upload";
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile mf) throws IOException {
        String filename = mf.getOriginalFilename();
        File file=new File("E:\\img\\"+filename);
        //开始文件上传
        mf.transferTo(file);
        return null;
    }

    @RequestMapping("/goDown")
    public String goDown(){
        return "download";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletResponse response) throws Exception {

        //先根据文件id查询对应图片信息

        //下载关键代码
        File file=new File("D:\\图片\\桌面壁纸\\图片\\妹妹.jpg");
        HttpHeaders headers = new HttpHeaders();//http头信息
        headers.setContentDispositionFormData("attachment", "123.jpg");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);

    }




}
