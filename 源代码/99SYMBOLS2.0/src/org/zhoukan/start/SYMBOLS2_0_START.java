package org.zhoukan.start;

import org.zhoukan.jms.SYMBOLSListenerMessage;
import org.zhoukan.util.ConnectionPool;

public class SYMBOLS2_0_START {

	public static void main(String[] args) {
		new SYMBOLSListenerMessage();
		ConnectionPool.initConnection();
	}
}
