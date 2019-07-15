package show;

import sort.Sort;

public class StartDraw implements Runnable {
	private Thread t;
	//设置初始参数
	private Sort sort;
	private int[] data;
	private boolean order;
	String str = new String();

	void setFunction(Sort sort, int[] data, boolean order) {
		this.sort = sort;
		this.data = data;
		this.order=order;
	}

	public void run() {
		
		synchronized(this) {   //使用互斥锁
			if(order) {
			sort.sortInc(data);
			}
			else {
				sort.sortDesc(data);
			}
	         
	            try {
	               
	               Thread.sleep(10);
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         }
		}
	public void start() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

}