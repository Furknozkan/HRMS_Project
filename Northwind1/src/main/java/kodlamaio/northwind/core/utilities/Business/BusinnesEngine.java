package kodlamaio.northwind.core.utilities.Business;

import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;

public class BusinnesEngine {
	public static Result run(Result... logics) {
		for(Result logic: logics) {
			if(!logic.isSuccess()) {
				return logic;
			}
			
		}
		return new SuccessResult();
	}

}
