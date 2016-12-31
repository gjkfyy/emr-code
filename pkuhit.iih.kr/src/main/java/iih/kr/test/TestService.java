package iih.kr.test;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TestService {
	@RequestMapping("/something")
	Map<String, Object> doSomething();

	@RequestMapping(value = "/something", method = RequestMethod.POST)
	void doSomething2();

	@RequestMapping(value = "/something/{id}", method = RequestMethod.GET)
	int getSomething(@PathVariable("id") String id);
}
