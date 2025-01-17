package com.lxh.structure.node;

/**
 * @Auther: LiXuHui
 * @Date: 2019/7/18/018 15:44
 * @Description:
 */
public class Node
{
    private int keyData;

    private int otherData;

    private Node leftNode;

    private Node rightNode;

    public Node(int keyData, int otherData)
    {
        this.keyData = keyData;
        this.otherData = otherData;
    }

    public int getKeyData()
    {
        return keyData;
    }

    public void setKeyData(int keyData)
    {
        this.keyData = keyData;
    }

    public int getOtherData()
    {
        return otherData;
    }

    public void setOtherData(int otherData)
    {
        this.otherData = otherData;
    }

    public Node getLeftNode()
    {
        return leftNode;
    }

    public void setLeftNode(Node leftNode)
    {
        this.leftNode = leftNode;
    }

    public Node getRightNode()
    {
        return rightNode;
    }

    public void setRightNode(Node rightNode)
    {
        this.rightNode = rightNode;
    }

    public void display()
    {
        System.out.println(keyData + "," + otherData);
    }
}
