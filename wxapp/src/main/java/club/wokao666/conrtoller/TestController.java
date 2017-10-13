package club.wokao666.conrtoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.wokao666.common.ReturnMsg;
import club.wokao666.service.TestService;
import io.swagger.annotations.Api;

/**
 * 做题测试
 */
@Api
@RequestMapping(value="/test")
@RestController
public class TestController {
	@Autowired
	private TestService testService;

	
	/****
	 * 保存数据
	 */
	@RequestMapping(value="saveRecord.do")
	public ReturnMsg saveRecord(@RequestParam int kind,@RequestParam(defaultValue="0") int score,@RequestParam int type,@RequestParam String token) {
		int result = testService.saveRecord(kind, score, type, token);
		if(result > 0) {
			return ReturnMsg.succ();
		}
		return ReturnMsg.error();
	}
	
	/**
	 * 查询成绩
	 */
	public ReturnMsg searchScore(@RequestParam int type,@RequestParam String token,@RequestParam int start,@RequestParam int end,@RequestParam long number) {
		
		
		
		
		
		return null;
		
		
	}
}
