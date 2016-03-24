
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by masy on 2016/3/22.
 */
public class SimpleBlockTest {
    public static void main(String[] args) {
        KieServices kservices = KieServices.Factory.get();
        KieContainer kcontainer = kservices.newKieClasspathContainer();

        KieSession ksession =  kcontainer.newKieSession("simpleBlock-session");
        List list = new ArrayList();
        ksession.setGlobal( "list",
                list );
        ksession.insert( "go1" );
        ksession.insert( "go2" );

        ksession.fireAllRules();
      // RuleTerminalNodeLeftTuple ruleTerminalNodeLeftTuple= (RuleTerminalNodeLeftTuple)list.get(1);
        System.out.println();

    }
}
