package com.zk.kotlinapplication.kotlin

/**
 * author: ZK.
 * date:   On 2018/3/26.
 *  descrption: Kotlin的基本数据类型
 */

class BaseDataType {


    /**
     * =============比较两个对象================
     *
     * Kotlin中没有基本的数据类型。只有封装的数字类型，你每定义一个变量，其实Kotlin帮你封装一个对象，
     * 这样可以保证不会出现空指针，数字类型也一样。所以比较两个数字时，就有比较数据大小和比较两个对象的区别了。
     *
     * 在Kotlin中，三个等号===表示比较对象地址，两个== 表示比较两个值大小
     *
     */

    fun compare() {
        val a: Int = 100;

        println(a == a) // true, 值相等，对象地址相等


    }


}