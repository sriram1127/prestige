package com.service;

import com.beans.Nominee;

public class Service {
	public Nominee getNominee(String str) {
		// Profile API to get Nominee details
		Nominee nominee = new Nominee();
		nominee.setNominationFirstName("first name");
		nominee.setNominationLastName("second name");
		nominee.setNominationUserId(str);
		return nominee;
	}
}
