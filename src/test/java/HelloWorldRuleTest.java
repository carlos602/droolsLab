import com.Person;


import com.Purchase;
import org.drools.core.common.DefaultFactHandle;
import org.kie.api.KieServices;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.math.BigDecimal;


/**
 * Created by masy on 2016/3/18.
 */
public class HelloWorldRuleTest {
    public static void main(String[] args) {
        KieServices kservices = KieServices.Factory.get();
        KieContainer kcontainer = kservices.newKieClasspathContainer();
//        KieSession session =  kcontainer.newKieSession("age-session");
//        for (int i = 0; i < 200; i++) {
//            int age = (int) (1 + Math.random() * (20 - 1 + 1));
//            Person p = new Person();
//            p.setAge(age);
//            session.insert(p);
//        }
//     DefaultFactHandle factHandle= (DefaultFactHandle) session.insert(new Purchase(new BigDecimal(16),2,false));
//
//      session.fireAllRules();

        StatelessKieSession ksession =  kcontainer.newStatelessKieSession();
        ksession.execute(new Object());
        Purchase purchase=new Purchase(new BigDecimal(16),2,false);
        ksession.execute(purchase);
    }
}
