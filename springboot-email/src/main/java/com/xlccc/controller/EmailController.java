package com.xlccc.controller;

import com.xlccc.common.JsonResult;
import com.xlccc.service.impl.IMailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private IMailServiceImpl mailService;//注入发送邮件的各种实现方法
    @Autowired
    private TemplateEngine templateEngine;//注入模板引擎

    @RequestMapping
    public JsonResult index(){
        try {
            mailService.sendSimpleMail("macrofei@163.com","SpringBoot Email","这是一封普通的SpringBoot测试邮件");
        }catch (Exception ex){
            ex.printStackTrace();
            return new JsonResult(-1,"邮件发送失败!!");
        }
        return new JsonResult();
    }

    @RequestMapping("/htmlEmail")
    public JsonResult htmlEmail(){
        try {
            mailService.sendHtmlMail("xuanlccc@163.com","Pay让支付触手可及","<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                    + " <div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                    +"      <h3>欢迎使用IJPay -By Javen</h3>\n"
                    +"      <span>https://github.com/MacroFei/linkpro</span>"
                    + "     <div\n"
                    + "         style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://github.com/MacroFei/linkpro\" target=\"_bank\" ><strong>Pay 让支付触手可及,欢迎Start支持项目发展:)</strong></a></div>\n"
                    + "     <div\n" + "         style=\"text-align: center; padding: 4px\">欢迎关注</div>\n"
                    + "     <img width=\"180px\" height=\"180px\"\n"
                    + "         src=\"http://ccclx.xlccc.com/pic/xlccc.jpg\">\n"
                    + " </div>\n" + "</body>");
        }catch (Exception ex){
            ex.printStackTrace();
            return new JsonResult(-1,"邮件发送失败!!");
        }
        return new JsonResult();
    }

    @RequestMapping("/attachmentsMail")
    public JsonResult attachmentsMail(){
        try {
            String filePath = "C:\\Users\\macro\\Desktop\\xlccc.jpg";
            mailService.sendAttachmentsMail("macrofei@163.com", "这是一封带附件的邮件", "邮件中有附件，请注意查收！", filePath);
        }catch (Exception ex){
            ex.printStackTrace();
            return new JsonResult(-1,"邮件发送失败!!");
        }
        return new JsonResult();
    }

    @RequestMapping("/resourceMail")
    public JsonResult resourceMail(){
        try {
            String rscId = "Pay";
            String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
            String imgPath = "C:\\Users\\macro\\Desktop\\xlccc.jpg";
            mailService.sendResourceMail("macrofei@163.com", "这邮件中含有图片", content, imgPath, rscId);

        }catch (Exception ex){
            ex.printStackTrace();
            return new JsonResult(-1,"邮件发送失败!!");
        }
        return new JsonResult();
    }

    @RequestMapping("/templateMail")
    public JsonResult templateMail(){
        try {
            Context context = new Context();
            context.setVariable("project", "Pay");
            context.setVariable("author", "Javen");
            context.setVariable("url", "https://github.com/MacroFei/linkpro");
            String emailContent = templateEngine.process("emailTemp", context);

            mailService.sendHtmlMail("macrofei@163.com", "这是模板邮件", emailContent);
        }catch (Exception ex){
            ex.printStackTrace();
            return new JsonResult(-1,"邮件发送失败!!");
        }
        return new JsonResult();
    }
}
