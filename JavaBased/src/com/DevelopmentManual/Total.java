package com.DevelopmentManual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 作者: xhd
 * 创建时间: 2019/8/30 15:03
 * 版本: V1.0
 */
public class Total {
    //创建线程安全的ArrayList
    //1.
     static List<String> synList1 = Collections.synchronizedList(new ArrayList<>());
    //2.
    static List<String> synList2=new CopyOnWriteArrayList<>();
}
