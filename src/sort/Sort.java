package sort;

import javax.swing.JFrame;
import javax.swing.JPanel;



public interface Sort {
final static int MAXSIZE = 100;
    /**
     * 排序全部数据，默认为降序
     * */
    void sort(int[] unsortedArray);

    /**
     * 按降序排序
     * */
    void sortDesc(int[] unsortedArray);

    /**
     * 按升序排序
     * */
    void sortInc(int[] unsortedArray);
    
   
}