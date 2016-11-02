package ch02.stringLogs;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class LinkedStringLogTest {

	@Test
	public void testIsEmpty() {
		LinkedStringLog myLog=new LinkedStringLog("test");
		//Case 0
		Assert.assertEquals(myLog.isEmpty(), true);
		//Case 1
		myLog.insert("1");
		Assert.assertEquals(myLog.isEmpty(), false);
		//Case 2
		myLog.insert("2");
		myLog.insert("3");
		myLog.insert("4");
		myLog.insert("5");
		Assert.assertEquals(myLog.isEmpty(), false);
	}

	@Test
	public void testHowMany() {
		LinkedStringLog myLog=new LinkedStringLog("test");
		//Case 0
		myLog.insert("non-matching");
		Assert.assertEquals(myLog.howMany("match"), 0);
		//Case 1
		myLog.insert("match");
		Assert.assertEquals(myLog.howMany("match"), 1);
		//Case 2
		myLog.insert("match");
		myLog.insert("match");
		myLog.insert("match");
		myLog.insert("match");
		Assert.assertEquals(myLog.howMany("match"), 5);
	}
	
	@Test
	public void testUniqInsert(){
		LinkedStringLog myLog=new LinkedStringLog("test");
		//Case 0
		Assert.assertEquals(myLog.uniqInsert("unique"), true);
		Assert.assertEquals(myLog.contains("unique"), true);
		//Case 1 unique already inserted
		Assert.assertEquals(myLog.uniqInsert("unique"), false);
		//Case 2
		Assert.assertEquals(myLog.uniqInsert("UnIqUe"), false);
	}
	
	@Test
	public void testSmallest(){
		LinkedStringLog myLog=new LinkedStringLog("test");
		//Case 0
		myLog.insert("AB");
		myLog.insert("ABA");
		myLog.insert("ABC");
		myLog.insert("DDD");
		//Assert.assertEquals(myLog.smallest(), "AB");
		//Case 1
		myLog.clear();
		myLog.insert("hello");
		myLog.insert("apple");
		//Assert.assertEquals(myLog.smallest(), "apple");
		//Case 2
		myLog.clear();
		myLog.insert("AB");
		myLog.insert("ab");
		//Assert.assertEquals(myLog.smallest(), "ab");
	}
	
	@Test
	public void testEndToEnd(){
		LinkedStringLog myLog=new LinkedStringLog("test");
		Assert.assertEquals(myLog.isEmpty(), true);
		myLog.insert("hello");
		Assert.assertEquals(myLog.isEmpty(), false);
		Assert.assertEquals(myLog.howMany("hello"), 1);
		Assert.assertEquals(myLog.uniqInsert("hello"), false);
		myLog.insert("help");
		//Assert.assertEquals(myLog.smallest(), "hello");
	}
}
