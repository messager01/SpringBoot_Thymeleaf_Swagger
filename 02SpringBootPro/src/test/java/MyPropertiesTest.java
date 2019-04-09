import com.itlike.Application;
import com.itlike.config.MyProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyPropertiesTest {

    @Autowired
    private MyProperties myProperties;


    @Test
    public void test(){
        System.out.println(myProperties.getListPros());
        //[listvalue1, listvalue2]
        System.out.println(myProperties.getListMapPros());

        //[{list_map1_key1=list_map1_value1, list_map1_key2=list_map1_value2}, {list_map2_key1=list_map2_value1, list_map2_key2=list_map2_value2}]
    }
}
