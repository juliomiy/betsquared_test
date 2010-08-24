package com.jittr.android.test;

import com.jittr.android.BetSquaredApplication;
import com.jittr.android.fs.dto.User;
import com.jittr.android.fs.impl.FSClientAPIImpl;

import android.app.Activity;
import android.content.Context;
import android.test.ApplicationTestCase;
import junit.framework.Assert;

public class Betsquared_test extends ApplicationTestCase {
	private Context context;
	private Activity activity;
	private FSClientAPIImpl fs;
	private User fsUser;
	
	public Betsquared_test() {
		 super(BetSquaredApplication.class);	
	} //constructor
	
	protected void setUp() throws Exception {
	 	try {
				super.setUp();
		} catch (Exception e) {
				e.printStackTrace();
		}
	    createApplication();
	    context = this.getContext();
		fs = new FSClientAPIImpl("xml", "9173702880", "cuba1a");	
		fsUser = fs.getUserDetails("", "juliomiy", true, true);
	} //setUp
	
	protected void tearDown() throws Exception {
		super.tearDown();
	} //tearDown
	
	public void testPreConditions() {
		Assert.assertNotNull("Foursquare object Not Null", fs);
		Assert.assertNotNull("Foursquare User object Not Null", fsUser);
	}  //testPreConditions

	public void testTrivialFail() {
		Assert.assertTrue("Fail on purpose", false);
	}
	
	public void testFoursquareName() {
		Assert.assertEquals("jitter@jittr.com", fsUser.getEmail());
	}
}  //class
