package sort;

import javax.swing.JFrame;
import javax.swing.JPanel;

import show.DrawGraph;

public class SortAdapter implements Sort {

	
	public static boolean OPEANDRAW=true;//是否画图选择
	

	@Override
	public void sort(int[] unsortedArray) {
		sortDesc(unsortedArray);
	}

	@Override
	public void sortDesc(int[] unsortedArray) {

	}

	@Override
	public void sortInc(int[] unsortedArray) {

	}

	protected static boolean less(int i, int j) { // 比较两个元素大小

		if (i < j) {
			return true;
		}
		return false;
	}

	
	
}