package com.tanpang.day10_28;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
import java.util.ArrayList;
public class _3 {
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if(len==0){
            return 0;
        }
        int answer=0;
            for(int i=0;i<len;i++){
                if(array[i]>array[i+1]){
                    answer = array[i+1];
                    break;
                }
            }
        
        return answer;
    }
}