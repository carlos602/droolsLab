import com.order.Order;
import com.order.OrderItem;
import org.drools.compiler.kproject.models.KieModuleModelImpl;
import org.junit.Test;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieSession;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by masy on 2016/3/23.
 */

public class testSpringIntegration {


    @Test
    public void testIntegration() throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        KieSession session = (KieSession) context.getBean("order-session");
        for (int i = 0; i < 10; i++) {
            List<OrderItem> orderItems = new ArrayList<OrderItem>();
            for (int j = 0; j < 10; j++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setPrice((int) (1 + Math.random() * (20 - 1 + 1)));
                orderItems.add(orderItem);
                // session.insert(orderItem);
            }
            Order order = new Order();
            order.setOrderItems(orderItems);
            session.insert(order);
        }

        session.fireAllRules();
        while (true) ;
    }
}
