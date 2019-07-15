package sort;

import javax.swing.JPanel;

import show.DrawGraph;

public class ShellSort extends SortAdapter {
	private static DrawGraph draw=new DrawGraph();

	public void reDraw(int[] arr) {
		draw.getData(arr,-1,-1);
		draw.repaint();
	}
	public ShellSort(JPanel panel) {
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
		int h=1;
		while(h<n/3) {
			h=3*n+1;
		}
		while(h>=1) {
			for(int i=h;i<n;i++) {
				for(int j=i;j>=h&&less(unsortedArray[j-h],unsortedArray[j]);j-=h)
					exch(unsortedArray,j,j-h);
			}
			h=h/3;
		}
		draw.getData(unsortedArray,-1,-1);
		draw.repaint();
	}

	@Override
	public void sortInc(int[] unsortedArray) {
		int n=unsortedArray.length;
		int h=1;
		while(h<n/3) {
			h=3*n+1;
		}
		while(h>=1) {
			for(int i=h;i<n;i++) {
				for(int j=i;j>=h&&less(unsortedArray[j],unsortedArray[j-h]);j-=h)
					exch(unsortedArray,j,j-h);
			}
			h=h/3;
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

				Thread.sleep(100);
			} catch (Exception e) {
				System.exit(0);// 退出程序
			}
		}
	}

}
