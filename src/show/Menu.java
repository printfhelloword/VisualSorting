package show;

import data.Data;
import sort.QuickSort;
import sort.InsertSort;
import sort.ShellSort;
import sort.SortAdapter;
import sort.Sort;

public class Menu {
	private boolean rand = false; // 是否使用随机数据
	private boolean order = false; // 默认顺序排序

	Data data = new Data();
	InsertSort sort1;
	ShellSort sort2;
	QuickSort sort3;
	StartDraw thread1 = new StartDraw();
	StartDraw thread2 = new StartDraw();
	StartDraw thread3 = new StartDraw();
	App app;

	public Menu(App app) {
		this.app=app;
		setData();
		this.sort1 = new InsertSort(app.panelSort1);
		this.sort2 = new ShellSort(app.panelSort2);
		this.sort3 = new QuickSort(app.panelSort3);

		prepareDraw();
	}

	// 设置随机
	public void setRand(boolean rand) {
		this.rand = rand;
	}

	// 设置打乱
	public void setShuffle() {

		data.shuffleData();
	}

	// 设置逆序 顺序
	public void setOrder(boolean order) {
		this.order = order;
	}
    //改变数据源
	public void setData() {
		data.randData(rand);

	}

	// 准备排序
	public void prepareDraw() {
		sort1.reDraw(data.getArray());
		sort2.reDraw(data.getArray());
		sort3.reDraw(data.getArray());
	}

	/* 得到要求数据 开始排序功能 */
	public void start() {

		thread1.setFunction(sort1, data.getArray(), order);
		thread2.setFunction(sort2, data.getArray(), order);
		thread3.setFunction(sort3, data.getArray(), order);
		thread1.start();
		thread2.start();
		thread3.start();
	}

	/* 返回排序时间 */
	public double[] getSortTime() {
		SortAdapter.OPEANDRAW = false; // 关闭画图
		double[] time = new double[3];
		// 排序1时间
		long startTime1 = System.nanoTime();
		sort1.sortDesc(data.getArray());
		long endTime1 = System.nanoTime();
		time[0] = (double) ((endTime1 - startTime1) / 1000) / 1000;
		// 排序2时间
		long startTime2 = System.nanoTime();
		sort2.sortDesc(data.getArray());
		long endTime2 = System.nanoTime();
		time[1] = (double) ((endTime2 - startTime2) / 1000) / 1000;
		// 排序3时间
		long startTime3 = System.nanoTime();
		sort3.sortDesc(data.getArray());
		long endTime3 = System.nanoTime();
		time[2] = (double) ((endTime3 - startTime3) / 1000) / 1000;

		SortAdapter.OPEANDRAW = true; // 打开画图
		return time;
	}
	public static void main(String[] args) {
		
	}
	

}
