package com.mvc.databiner;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.jsonAnnotation.JackBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author zl
 */
@RestController
public class JackBeanController {

//    @JsonView(JackBean.NameView.class)
    @JsonView(JackBean.AllView.class)
    @GetMapping("getuser")
    public JackBean getUser() {
        JackBean jackBean = new JackBean();
        jackBean.setName("123");
        jackBean.setPass("2");
        return jackBean;
    }

    @Autowired
    ObjectMapper mapper;

    @RequestMapping("customize")
    @ResponseBody
    public String customize() throws JsonParseException, JsonMappingException, IOException {
        String jsonStr = "[{\"user-name\":\"123\",\"user-pass\":\"456\"},{\"user-name\":\"123\",\"user-pass\":\"456\"}]";
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, JackBean.class);
        List<JackBean> list = mapper.readValue(jsonStr, type);
        String msg = "";
        for (JackBean bean : list) {
            msg += bean.getName();
        }
        return msg;
    }

}
