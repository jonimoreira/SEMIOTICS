package ews;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.drools.core.ClassObjectFilter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufes.inf.lprm.scene.SceneApplication;
import br.ufes.inf.lprm.scene.base.listeners.SCENESessionListener;
import br.ufes.inf.lprm.situation.model.Situation;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import ews.vehiclecollision.entities.Truck;

/**
 * This is a sample class to launch a rule.
 */

class RuleEngineThread extends Thread {	
	private KieSession ksession;
	public RuleEngineThread(KieSession ksession) {
		this.ksession = ksession;
	}
    public void run() {  	
    	this.ksession.fireUntilHalt(); 	
    }
}


public class Test01 {

	private static final String __LSRECE_GET_TIMESTAMP_FROM_TUPLE =
			"{" +
			"	org.drools.core.common.InternalFactHandle fh = $1.get( this.declaration );\n" +
			"	if (fh instanceof org.drools.core.common.EventFactHandle) {\n" +
			"		return ((org.drools.core.common.EventFactHandle) fh).getStartTimestamp();\n" +
			"	} else {\n" +
			"		Object obj = fh.getObject();\n" +
			"   	if (obj instanceof br.ufes.inf.lprm.situation.model.Situation) {\n" +
			"			br.ufes.inf.lprm.situation.model.Situation sit = (br.ufes.inf.lprm.situation.model.Situation) obj;  \n" +
			"			return sit.getActivation().getTimestamp();\n" +
			"		} else {\n" +
			"			return 0L;\n" +
			"		}\n" +
			"	}\n" +
			"}";
	private static final String __LSRECE_GET_TIMESTAMP_FROM_FACT_HANDLE =
			"{" +
			"	org.drools.core.common.InternalFactHandle fh = $1;\n" +
			"	if (fh instanceof org.drools.core.common.EventFactHandle) {\n" +
			"		return ((org.drools.core.common.EventFactHandle) fh).getEndTimestamp();\n" +
			"	} else {\n" +
			"		Object obj = fh.getObject();\n" +
			"   	if (obj instanceof br.ufes.inf.lprm.situation.model.Situation) {\n" +
			"			br.ufes.inf.lprm.situation.model.Situation sit = (br.ufes.inf.lprm.situation.model.Situation) obj;  \n" +
			"			return (!sit.isActive()) ? sit.getDeactivation().getTimestamp() : 0L;\n" +
			"		} else {\n" +
			"			return 0L;\n" +
			"		}\n" +
			"	}\n" +
			"}";

	private static final String __LERSCE_GET_TIMESTAMP_FROM_TUPLE =
					"{" +
					"	org.drools.core.common.InternalFactHandle fh = $1.get( this.declaration );\n" +
					"	if (fh instanceof org.drools.core.common.EventFactHandle) {\n" +
					"		return ((org.drools.core.common.EventFactHandle) fh).getEndTimestamp();\n" +
					"	} else {\n" +
					"		Object obj = fh.getObject();\n" +
					"   	if (obj instanceof br.ufes.inf.lprm.situation.model.Situation) {\n" +
					"			br.ufes.inf.lprm.situation.model.Situation sit = (br.ufes.inf.lprm.situation.model.Situation) obj;  \n" +
					"			System.out.println((!sit.isActive()) ? sit.getDeactivation().getTimestamp() : 0L ); " +
					"			return (!sit.isActive()) ? sit.getDeactivation().getTimestamp() : 0L;" +
					"		} else {\n" +
					"			return 0L;\n" +
					"		}\n" +
					"	}\n" +
					"}";
	private static final String __LERSCE_GET_TIMESTAMP_FROM_FACT_HANDLE =
					"{\n" +
					"	org.drools.core.common.InternalFactHandle fh = $1;\n" +
					"	if (fh instanceof org.drools.core.common.EventFactHandle) {\n" +
					"		return ((org.drools.core.common.EventFactHandle) fh).getStartTimestamp();\n" +
					"	} else {\n" +
					"		Object obj = fh.getObject();\n" +
					"   	if (obj instanceof br.ufes.inf.lprm.situation.model.Situation) {\n" +
					"			br.ufes.inf.lprm.situation.model.Situation sit = (br.ufes.inf.lprm.situation.model.Situation) obj;  \n" +
					"			System.out.println(); System.out.println(sit.getActivation().getTimestamp());" +
					"			return sit.getActivation().getTimestamp();\n" +
					"		} else {\n" +
					"			return 0L;\n" +
					"		}\n" +
					"	}\n" +
					"}";

	
	static final Logger LOG = LoggerFactory.getLogger(Test01.class);
	
	@Test
	public void test01() {
		//fail("Not yet implemented");
		assertTrue(true);
	}

	@Test
	public void test02() {
		//fail("Not yet implemented");
		//br.ufes.inf.lprm.scene_core.App.main(null);
		assertTrue(true);
	}
	
	@SuppressWarnings("unchecked") 
	@Test
	public void test03()
	{
		/*
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ews.vehiclecollision.session");
        kSession.addEventListener(new SCENESessionListener());

		SceneApplication app = new SceneApplication(ClassPool.getDefault(), kSession, "VehicleCollision");
		
		final RuleEngineThread eng = new RuleEngineThread(kSession);
		eng.start();
*/
		
		assertTrue(true);
	}
	
	@SuppressWarnings("unchecked") 
	@Test
	public void test04()
	{
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ews.vehiclecollision.session");
        kSession.addEventListener(new SCENESessionListener());

		SceneApplication app = new SceneApplication(ClassPool.getDefault(), kSession, "LightCollision");
		
		final RuleEngineThread eng = new RuleEngineThread(kSession);
		eng.start();
		
		Truck t1 = new Truck();
		t1.setId(1);
		t1.setName("Test truck");
		t1.setAcceleration(0);
		
		FactHandle fh1 = kSession.insert(t1);

		//Thread.sleep(8000);

		t1.setAcceleration(10);
		kSession.update(fh1, t1);

		//Thread.sleep(3000);
		
		/*
		LOG.info("Creating kieBase");

        KieBaseConfiguration config = KieServices.Factory.get().newKieBaseConfiguration();
        //config.setOption(EventProcessingOption.STREAM);
        KieBase kieBase = kContainer.newKieBase(config);
        FactType sessionType = kieBase.getFactType("ews.vehiclecollision", "Collision");
        
        kSession.fireAllRules();
        ArrayList<Situation> situations =  new ArrayList<Situation>((Collection<Situation>) kSession.getObjects(new ClassObjectFilter(sessionType.getFactClass())));

        LOG.info("situations.size()=" + situations.size());
		*/
		
		assertTrue(true);
	}
}
