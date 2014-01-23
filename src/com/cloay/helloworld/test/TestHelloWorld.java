package com.cloay.helloworld.test;

import com.cloay.helloworld.MainActivity;
import com.cloay.helloworld.R;

import android.content.Intent;
import android.os.SystemClock;
import android.test.InstrumentationTestCase;
import android.util.Log;
import android.widget.Button;

public class TestHelloWorld extends InstrumentationTestCase {
	private MainActivity mActivity = null;
	private Button button = null;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		Intent intent = new Intent();
        intent.setClassName("com.cloay.helloworld", MainActivity.class.getName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mActivity = (MainActivity) getInstrumentation().startActivitySync(intent);
        button = (Button) mActivity.findViewById(R.id.button1);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		mActivity.finish();
		
	}
	
	public void testButtonClick() throws Exception{
		Log.v("Test", "test button is clicked");
		SystemClock.sleep(1500);
        getInstrumentation().runOnMainSync(new PerformClick(button));
        SystemClock.sleep(3000);
	}

	/*
     * 模拟按钮点击的接口
     */
    private class PerformClick implements Runnable {
        Button btn;
        public PerformClick(Button button) {
            btn = button;
        }
 
        public void run() {
            btn.performClick();
        }
    }
    
	/**
	 * 
	 * @throws Throwable
	 */
	/*
	public void testAdd() throws Throwable{
		int i = 4 + 2;
		Assert.assertEquals(6, i);
	}*/
	
}
