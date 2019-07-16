package com.lxh.stack;

/**
 * @Auther: LiXuHui
 * @Date: 2019/7/16/016 16:03
 * @Description:
 */
public class MyStack
{
    private int maxSize;

    private long[] arr;

    private int top;

    // 构造方法
    public MyStack(int size)
    {
        maxSize = size;
        arr = new long[maxSize];
        top = -1;
    }

    // 压入数据
    public void push(long value)
    {
        arr[++top] = value;
    }

    // 弹出数据
    public long pop()
    {
        return arr[top--];
    }

    // 访问栈顶元素
    public long peek()
    {
        return arr[top];
    }

    // 栈是否为空
    public boolean isEmpty()
    {
        return (top == -1);
    }

    // 栈是否满了
    public boolean isFull()
    {
        return (top == maxSize - 1);
    }

    public static void main(String[] args)
    {
        MyStack ms = new MyStack(10);
        ms.push(40);
        ms.push(30);
        ms.push(20);
        ms.push(10);
        ms.push(-10);
        ms.push(-20);
        System.out.println(ms.peek());

        while (!ms.isEmpty())
        {
            System.out.println(ms.pop());
        }
    }
}
