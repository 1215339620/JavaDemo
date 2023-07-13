package mai.json;

import com.alibaba.fastjson.JSON;

public class FastJsonDemo {
    public static void main(String[] args) {
        User user=new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");

        String s = JSON.toJSONString(user);

    }
}
