package kodlamaio.northwind.core.utilities.results;

import kodlamaio.northwind.services.FakeMernis;

public class IdentityValidation {
	public static boolean isRealPerson(String tcno) {
		FakeMernis mernis = new FakeMernis();
		return FakeMernis.validate(tcno);
	}
	
	
}
