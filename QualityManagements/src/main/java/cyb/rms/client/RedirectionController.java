package cyb.rms.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectionController {
	
	@RequestMapping("/ProjectLogin")
	public String adminPage(){
		return "app/proj-manager/welcome";
	}
}
