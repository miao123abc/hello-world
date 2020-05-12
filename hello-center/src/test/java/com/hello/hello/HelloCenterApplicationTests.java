package com.hello.hello;

import com.hello.hello.leetCode.sort.IArraySort;
import com.hello.hello.leetCode.sort.MergeSort;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class HelloCenterApplicationTests {

//    @Autowired
//    private IArraySort iArraySort;

    @Test
    public void contextLoads() {
        IArraySort mergeSort = new MergeSort();
        int[] sourseArray = {1,5,6,3,2,7};
        int[] sortArray = mergeSort.sort(sourseArray);
        System.out.println("sortArray = " + Arrays.toString(sortArray));
    }

}
