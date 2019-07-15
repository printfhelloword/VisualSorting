package data;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
	final private int MAXSIZE = 100;  //数据大小
	
	public List<Integer> data = new ArrayList<>();//用于排序数组
	
	
	private void orderData() {       //顺序数组
		data.clear();
		
		
		for(int i=0; i < MAXSIZE; i++)
			data.add(i+1);
		Collections.shuffle(data);   //打乱数组
	}
	private void randomData() {
		data.clear();   //清除数据
		
		for(int i=0;i < MAXSIZE; i++)
			data.add((int)(Math.random()*MAXSIZE+1)) ;
	
		
	}
	public void randData(boolean flag) {  //选择随机数组或 顺序数组
		if(flag)
			randomData();
		else
			orderData();
	}
	public void shuffleData() {
		
			Collections.shuffle(data); 
			
	}
	public int[] getArray() {
		int[] array = data.stream().mapToInt(Integer::intValue).toArray();
		/* 将integer转化为int[]，使用java8新特性*/

		return Arrays.copyOf(array, array.length);
	}
	

}
