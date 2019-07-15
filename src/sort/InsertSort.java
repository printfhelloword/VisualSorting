package sort;

import javax.swing.JPanel;

import show.App;
import show.DrawGraph;

public class InsertSort extends SortAdapter {

	private static DrawGraph draw=new DrawGraph();
	public void reDraw(int[] arr) {//准备图像
		draw.getData(arr,-1,-1);
		draw.repaint();
	}
    public InsertSort(JPanel panel){

    	panel.add(draw);
    	
    }
   
	@Override
	public void sort(int[] unsortedArray) {
		// TODO Auto-generated method stub
		sortDesc(unsortedArray);
	}

	@Override
	public void sortDesc(int[] unsortedArray) {
		int n=unsortedArray.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0 && less(unsortedArray[j-1], unsortedArray[j]); j--) {
				exch(unsortedArray, j, j - 1);
				
			}
		}
		
		draw.getData(unsortedArray,-1,-1);
		draw.repaint();


	}

	@Override
	public void sortInc(int[] unsortedArray) {
		int n=unsortedArray.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0 && less(unsortedArray[j], unsortedArray[j-1]); j--) {
				exch(unsortedArray, j, j - 1);
				
			}
		}
		
		draw.getData(unsortedArray,-1,-1);
		draw.repaint();
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

				Thread.sleep(70);
			} catch (Exception e) {
				System.exit(0);// 退出程序
			}
		}
	}

}
