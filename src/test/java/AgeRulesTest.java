import com.Person;
import com.TimeHelper;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

/**
 * Created by masy on 2016/3/16.
 */
public class AgeRulesTest {

    public static void main(String[] args) {


        StatefulKnowledgeSession session = null;
        try {

            KnowledgeBuilder builder = KnowledgeBuilderFactory.
                    newKnowledgeBuilder();
            builder.add(ResourceFactory.newClassPathResource("com/age/ageRules.drl"), ResourceType.DRL);
            if (builder.hasErrors()) {
                throw new RuntimeException(builder.getErrors().toString());
            }
            KnowledgeBase knowledgeBase = KnowledgeBaseFactory.
                    newKnowledgeBase();
            knowledgeBase.addKnowledgePackages(builder.
                    getKnowledgePackages());

            session = knowledgeBase.newStatefulKnowledgeSession();

// purchase > $15 and <= $25
            for (int i = 0; i < 200; i++) {
                int age = (int) (1 + Math.random() * (20 - 1 + 1));
                Person p = new Person();
                p.setAge(age);
                session.insert(p);
            }
           TimeHelper.printTime();
            session.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (session != null) {

            }
        }
    }
}
