package com.ideacome.services.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideacome.base.res.Result;
import com.ideacome.services.vo.GreetingVO;

public interface GreetingControllerInterface {
	
	@RequestMapping("/greeting")
    public Result<GreetingVO> greeting(@RequestParam(value="name", defaultValue="World") String name);
}
