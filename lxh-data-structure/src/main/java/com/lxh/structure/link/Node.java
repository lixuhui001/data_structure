package com.lxh.structure.link;

/**
 * @Auther: LiXuHui
 * @Date: 2019/7/17/017 13:49
 * @Description:
 */
public class Node<T> {
    public T data;

    public Node<T> next;

    public Node<T> pre;

    public Node<T> getPre() {
        return pre;
    }

    public void setPre(Node<T> pre) {
        this.pre = pre;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> next() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
