package xiaohutu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * Hello world!
 *
 * @author 小糊涂
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("C:\\workspace\\activiti\\src\\main\\resources\\leave.bpmn20.xml").deploy();

        ProcessDefinition singleResult = repositoryService.createProcessDefinitionQuery().singleResult();
        String key = singleResult.getKey();
        System.out.println(key);
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leavesayhello");
        System.out.println(processInstance);
        System.out.println("pid:"+processInstance.getId()+",pdid:"+
                processInstance.getProcessDefinitionId());


    }
}
