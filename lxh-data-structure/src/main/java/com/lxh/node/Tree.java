package com.lxh.node;

/**
 * @Auther: LiXuHui
 * @Date: 2019/7/18/018 15:46
 * @Description:
 */
public class Tree
{
    private Node root;

    public Node getRoot()
    {
        return root;
    }

    public void setRoot(Node root)
    {
        this.root = root;
    }

    public void insert(int keyData, int otherData)
    {
        Node node = new Node(keyData, otherData);

        if (root == null)
        {
            root = node;
        }
        else
        {
            Node currentNode = root;
            Node parrentNode = root;
            while (true)
            {
                parrentNode = currentNode;
                if (keyData > currentNode.getKeyData())
                {
                    currentNode = currentNode.getRightNode();
                    if (currentNode == null)
                    {
                        parrentNode.setRightNode(node);
                        break;
                    }
                }
                else
                {
                    currentNode = currentNode.getLeftNode();
                    if (currentNode == null)
                    {
                        parrentNode.setLeftNode(node);
                        break;
                    }
                }
            }
        }
    }

    public Node find(int keyData)
    {
        Node currentNode = root;

        while (currentNode.getKeyData() != keyData)
        {
            if (keyData > currentNode.getKeyData())
            {
                currentNode = currentNode.getRightNode();
            }
            else
            {
                currentNode = currentNode.getLeftNode();
            }
            if (currentNode == null)
            {
                return null;
            }
        }
        return currentNode;

    }

    public void change(int keyData, int newOterDate)
    {
        Node node = find(keyData);
        node.setOtherData(newOterDate);
    }


    public void preOderTree(Node node)
    {
        if (node != null)
        {
            node.display();
            preOderTree(node.getLeftNode());
            preOderTree(node.getRightNode());
        }
    }

    public void inOderTree(Node node)
    {
        if (node != null)
        {
            inOderTree(node.getLeftNode());
            node.display();
            inOderTree(node.getRightNode());
        }
    }

    public void endOderTree(Node node)
    {
        if (node != null)
        {
            endOderTree(node.getLeftNode());
            endOderTree(node.getRightNode());
            node.display();
        }
    }

    public static void main(String[] args)
    {
        Tree tree = new Tree();
        tree.insert(80, 80);
        tree.insert(49, 49);
        tree.insert(42, 42);
        tree.insert(30, 30);
        tree.insert(45, 45);
        tree.insert(90, 90);
        tree.insert(150, 150);
        tree.insert(130, 130);
        tree.insert(82, 82);

        tree.endOderTree(tree.getRoot());

    }
}
