package com.lxh.structure.link;

/**
 * @Auther: LiXuHui
 * @Date: 2019/7/17/017 13:50
 * @Description:
 */
public class LinkList
{
    private Link first;

    public Link getFirst()
    {
        return first;
    }

    public void setFirst(Link first)
    {
        this.first = first;
    }

    public void insert(int value)
    {
        Link link = new Link(value);
        if (first != null)
        {
            link.setNext(first);
        }
        first = link;
    }

    public void disploy()
    {
        Link currentLink = first;
        while (currentLink != null)
        {
            System.out.print(currentLink.getData() + " ");
            currentLink=currentLink.getNext();
        }
    }

    public Link find(int value)
    {
        Link currentLink = first;
        while (currentLink != null)
        {
            if (value == currentLink.getData())
            {
                return currentLink;
            }
            currentLink = currentLink.getNext();
        }
        return null;
    }

    public void insert(int value, int pos)
    {
        if (pos == 0)
        {
            insert(value);
        }
        else
        {
            Link currentLink = first;
            for (int i = 0; i < pos - 1; i++)
            {
                currentLink = currentLink.getNext();
            }
            Link link = new Link(value);
            link.setNext(currentLink.getNext());
            currentLink.setNext(link);
        }
    }

    public void delete(int value)
    {
        Link currentList = first;
        Link ago = first;

        while (currentList.getData() != value)
        {
            if (currentList.getNext() == null)
            {
                return;
            }
            ago = currentList;
            currentList = currentList.getNext();
        }
        if (currentList == first)
        {
            first = first.getNext();
        }
        else
        {
            ago.setNext(currentList.getNext());
        }
    }

    public static void main(String[] args)
    {
        LinkList linkList = new LinkList();

        linkList.insert(40);
        linkList.insert(12);
        linkList.insert(23);
        linkList.insert(10);

        linkList.disploy();
        System.out.println("-----------------------");
        System.out.println("" + linkList.find(40).getData());
        System.out.println("-----------------------");
        linkList.insert(20, 1);
        linkList.disploy();
        System.out.println("-----------------------");
        linkList.delete(12);
        linkList.disploy();
        System.out.println("-----------------------");

    }

}
