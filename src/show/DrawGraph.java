package show;

import java.util.Arrays;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class DrawGraph extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private static int WIDTH=300;
	//标记交换数组
	int mark1;
	int mark2;
	int[] data = new int [100];                    // 数组数据
	                     
	
	public void getData(int[] data,int i,int j){
		this.data = data;
		this.mark1=i;
		this.mark2=j;
		
	}
	 public DrawGraph() {
		// TODO Auto-generated constructor stub
	}
	 public DrawGraph(int[] data) {
		 this.data = Arrays.copyOf(data, data.length);
	 }
	@Override
     public void paint(Graphics graphics) {
         // 必须先调用父类的paint方法
        super.paint(graphics);
        for(int i=0; i<100; i++) {
        	if(i==mark1||i==mark2)
        		graphics.setColor(new Color(123, 0, 244));
        	else
        		graphics.setColor(new Color(53, 164, 203));
     	   graphics.fillRect(WIDTH+i*8-200, (200-data[i])*2-160, 7, data[i]*2);
        }
     }
	

}
