package pkuhit.xap.task.ruleHandler.baseValidator;

import java.util.Date;

public class BaseTimeBound extends BaseValidator{
	public static Date dateIncreaseByHours(Date currentDate, int hours) {
		int intval = 0;
		if(hours > 700){
			intval = hours * 3600 * 500;
			return new Date(currentDate.getTime() + intval+intval);
		}
		return new Date(currentDate.getTime()+ hours * 3600 * 1000);
	}
	
	
}
