package com.mvc.databiner;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author zl
 * 数据绑定 可以自动绑定的有以下类型
 * HttpServletRequest HttpServletResponse HttpSession  Model/ModelMap
 * 基本类型 8种
 * 8种基本类型的包装类型   String
 * pojo(不过只能绑定pojo中的基本类型和String)
 * 数组
 * List  因为是接口  所以只能使用 {@link RequestBody} 来进行接收 或者放在vo中进行接收
 * Map   Content-Type为applicationon/json  也要加{@link RequestBody} 才能进行绑定
 *
 * Content-type：
 *
 * 1、application/x-www-form-urlencoded:@RequestBody不是必须加的
 *
 * 2、mutipart/form-data:@RequestBody不能处理这种格式
 *
 * 3、其他格式，比如application/json,application/xml等，必须使用@RequestBody来处理
 */
@RestController
public class DataBindController {

    @GetMapping("/databinder")
    public String dataBind(@RequestParam String test){

        System.out.println(test);
        return "绑定成功";
    }

    @PostMapping("/databinder")
    public String dataBindPost(String test,Date date){

        System.out.println(test+"--"+date.toString());
        return "绑定成功";
    }

    @PostMapping("/databinderData")
    public String dataBindPostData(@RequestBody Data data){

        System.out.println(data.getTest()+"--"+data.getDate());
        return "绑定成功";
    }

    @PostMapping("/databinderMap")
    public String dataBindPost(@RequestBody Map<String, String> map){

        System.out.println(map.toString());
        return "绑定成功";
    }
}
