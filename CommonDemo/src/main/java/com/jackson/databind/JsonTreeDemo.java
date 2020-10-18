package com.jackson.databind;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

/**
 * 有的时候整个json串我们只需要其中的一个属性或者这个json串没有对应的pojo
 * 使用树模式比较方便
 */
public class JsonTreeDemo {



    public static void main(String[] args) throws IOException {

        JsonTreeDemo jsonTreeDemo = new JsonTreeDemo();
        jsonTreeDemo.dynamicTree();

    }

    //get是会抛出NPE
    private void getEleFromTree() throws IOException {
        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18,\"dog\":{\"name\":\"旺财\",\"color\":\"WHITE\"},\"hobbies\":[\"篮球\",\"football\"]}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonStr);

        String color = jsonNode.get("dog").get("color").asText();
        System.out.println(color);
    }

    private void dynamicTree() throws IOException {
        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18,\"dog\":{\"name\":\"旺财\",\"color\":\"WHITE\"},\"hobbies\":[\"篮球\",\"football\"]}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonStr);
        String color = jsonNode.get("dog").get("color").asText();
        System.out.println(color);


        // 把json扩充属性
        // 强转为ObjectNode
        ObjectNode objectNode = (ObjectNode)jsonNode;
        objectNode.with("myDiy").put("contry", "China");
        jsonStr = objectMapper.writeValueAsString(objectNode);

        //{"name":"YourBatman","age":18,"dog":{"name":"旺财","color":"WHITE"},"hobbies":["篮球","football"],"myDiy":{"contry":"China"}}
        System.out.println(jsonStr);

    }
}
