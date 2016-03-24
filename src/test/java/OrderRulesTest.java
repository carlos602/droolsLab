import com.order.Order;
import com.order.OrderItem;
import org.drools.core.RuleBaseConfiguration;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.KieBaseOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.marshalling.MarshallerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by masy on 2016/3/18.
 */
public class OrderRulesTest {
    public static void main(String[] args) {
        KieServices kservices = KieServices.Factory.get();

        KieContainer kcontainer = kservices.newKieClasspathContainer();

        KieSession session =  kcontainer.newKieSession("order-session");


        for (int i = 0; i < 10; i++) {
            List<OrderItem> orderItems=new ArrayList<OrderItem>();
            for (int j = 0; j < 10; j++) {
                OrderItem orderItem=new OrderItem();
                orderItem.setPrice((int) (1 + Math.random() * (20 - 1 + 1)));
                orderItems.add(orderItem);
               // session.insert(orderItem);
            }
            Order order=new Order();
            order.setOrderItems(orderItems);
            session.insert(order);
        }

        session.fireAllRules();

    }
}
