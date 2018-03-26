package com.zk.kotlinapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.zk.kotlinapplication.kotlin.Person

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Person("ZK").printlnName();

        var name: String = "小明" //定义字符串
        var age = 24  //定义int 类型 默认
        var no: Long = 12345678978 //定义long类型

        Log.d("====", "姓名:$name")
        Log.d("====", "年龄：$age")
        Log.d("====", "手机号：$no")

        var x = 5;
        var y = 10;
        if (x in 1..y)
            Log.d("====", "x在y的范围内")

        var intArray: IntArray = intArrayOf(2, 3, 4, 5, 6)
        if (x in 0..intArray.lastIndex)
            Log.d("====", "x在数组长度范围内")

        println(sum3(5, 6))

        vars(1, 2, 3, 4, 5)

        println(sumLambda(5, 6))

        println(eStr)
        println(fStr)

    }


    //================函数的定义=====================================

    fun sum1(a: Int, b: Int): Int { //Int参数，返回值是Int
        return a + b
    }

    fun sum2(a: Int, b: Int) = a + b


    public fun sum3(a: Int, b: Int): Int = a + b

    fun printSum1(a: Int, b: Int): Unit {//无返回值的函数
        print(a + b);
    }

    public fun printSum2(a: Int, b: Int) {//如果返回的是Unit类型，可以省略（对于public）也是一样
        print(a + b)
    }

    //================可变长参数=========================================

    fun vars(vararg params: Int) {
        for (param in params) {
            print(param);
        }
    }

    //=================lambda============================================

    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }


    /**
     * =================定义常量与变量=====================================
     *
     *  可变变量定义：var关键字
     *
     *  var <标识符> :<类型> = <初始化值>
     *
     *  不可变量定义： val关键字，只能赋值一次的变量（类似与java中的final修饰的变量）
     *
     *   val <标识符> ：<类型> = <初始化值>
     *
     */

    var a: Int = 1
    var b = 1

    val c: Int = 1
    val d = 1;
    //val f: Int 不能在方法外部定义未初始化的用val修饰的变量


    fun assignment() {
        b += 1
        // d +=1;会报错，因为d是val修饰且已经初始化
        val f: Int
        f = 1;
    }


    /**
     *  $表示一个变量名或者变量值
     *
     *  $varName 表示变量值
     *
     *  ${varName.fun()}表示变量的方法返回值
     *
     */
    var e = 1

    var eStr = "e is $e"

    var f = 2;
    var fStr = "${eStr.replace("is", "was")},but now is $f"


    /**
     * ===================Null检查机制===============================
     */

    //类型后面加？表示可为空
    var gStr: String? = "123"

    //抛出空指针异常
    val gInt = gStr!!.toInt()

    //不作处理返回null
    val gInt1 = gStr?.toInt()

    //age为空返回1
    val gInt2 = gStr?.toInt() ?: -1

    //类型后面加？表示可为空。当一个引用可为null时，对应的类型声明必须明确标记为null
    fun parseInt(str: String): Int? {
        //  。。。。
        return null;
    }

    fun nullMethod(strs: Array<String>) {
        if (strs.size < 2) {
            println("Two Integer expected");
            return
        }
        var x = parseInt(strs[0])
        var y = parseInt(strs[1])

        //直接使用x*y会导致错误，因为可能为null。“Operactor call correctResponds  to a dot-qualified call x.times(y) which is not allowed on a nullable  receiver 'x'”
        if (x != null && y != null) {
            //在进行null值检查后，x 和y的类型会被自动转换为非null变量
            print(x * y)
        }
    }


    /**
     * =================类型检测及自动类型转换==========================
     *
     * 可以使用is运算符检测一个表达式是否某类型的一个实例（类似于java的instanceof关键字）
     */
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            //做过类型判断后，obj会被系统自动转换为String类型
            return obj.length
        }
        //这里的obj仍然是Any类型
        return null;


        /* *
         if (obj !is String)
              return  null;
             //在这个分支“中”，“obj”的类型自动转换为‘String’
          return  obj.length*/
    }


    /**
     * =====================区间==========================================
     *
     * 区间表达式使用的是操作符  “..”
     *
     * 辅以 in 和！in形成
     *
     */

    fun range() {
        for (i in 1..4) println(i); //输出 “1234” 等同于 i >=1 && i <= 10

        for (i in 4..1) println(i)

        //使用step指定步长
        for (i in 1..4 step 2) println(i) //输出“13”

        for (i in 4 downTo 1 step 2) println(i) //输出“42"

        //使用until排除结束元素
        for (i in 1 until 10) println(i)  // i in [1,10)


    }


}
