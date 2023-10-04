package project.samplejpa.project.restendpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.samplejpa.project.service.MyService;

@RestController
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/executeMethod1")
    public void executeMethod1() {
        myService.method1();
    }

    @GetMapping("/executeMethod2")
    public void executeMethod2() {
        myService.method2();
    }
}
