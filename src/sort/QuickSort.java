package sort;

import java.util.Arrays;

import javax.swing.JPanel;

import data.Data;
import show.DrawGraph;

public class QuickSort extends SortAdapter {
	private static DrawGraph draw = new DrawGraph();
	
	public void reDraw(int[] arr) {
		draw.getData(arr,-1,-1);
		draw.repaint();
	}
	public QuickSort(JPanel panel) {
    panel.add(draw);
    	
	}
	

	@Override
	public void sort(int[] unsortedArray) {
		// TODO Auto-generated method stub
		sortDesc(unsortedArray);
	}

	@Override
	public void sortDesc(int[] unsortedArray) {

		qSortDesc(unsortedArray, 0, unsortedArray.length - 1);
		draw.getData(unsortedArray,-1,-1);
		draw.repaint();
	}

	@Override
	public void sortInc(int[] unsortedArray) {

		qSortInc(unsortedArray, 0, unsortedArray.length - 1);
		draw.getData(unsortedArray,-1,-1);
		draw.repaint();
	}

	private void qSortInc(int[] arr, int l, int h) {

		if (l < h) {
			int pivot = incPartition(arr, l, h);
			qSortInc(arr, l, pivot - 1);
			qSortInc(arr, pivot + 1, h);
		}

	}

	// 拆分元素
	private int descPartition(int[] arr, int l, int h) {

		int pivot = arr[l];
		int index = l;

		while (l < h) {

			while (l < h && arr[h] <= pivot) {
				--h;
			}

			while (l < h && arr[l] >= pivot) {
				++l;
			}
			exch(arr, l, h);

		}
		exch(arr, index, l);
		return l;

	}

	private void qSortDesc(int[] arr, int l, int h) {

		if (l < h) {
			int pivot = descPartition(arr, l, h);
			qSortDesc(arr, l, pivot - 1);
			qSortDesc(arr, pivot + 1, h);
		}

	}

	private int incPartition(int[] arr, int l, int h) {

		int pivot = arr[l];
		int index = l;

		while (l < h) {

			while (l < h && arr[h] >= pivot) {
				--h;
			}

			while (l < h && arr[l] <= pivot) {
				++l;
			}
			exch(arr, l, h);

		}
		exch(arr, index, l);
		return l;

	}

	protected static void exch(int[] a, int i, int j) { // 交换元素
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		// 交换数组后重绘图像
		if (OPEANDRAW) {
			draw.getData(a,i,j);
			draw.repaint();

			try {

				Thread.sleep(100);
			} catch (Exception e) {
				System.exit(0);// 退出程序
			}
		}
	}

}
