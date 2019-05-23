package com.nicolas.common.test;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.alibaba.dubbo.demo.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-04-29 15:17
 */
public class LinkReversel {

    public static void main(String[] args) {
        NodeDemo node1 = new NodeDemo(1);
        NodeDemo node2 = new NodeDemo(5);
        NodeDemo node3 = new NodeDemo(33);
        NodeDemo node4 = new NodeDemo(2);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        NodeDemo h = node1;
        while(h != null){
            System.out.println("args = [" + h.getData() + "]");
            h =h.getNext();
        }

//        node1 = reversel(node1);
        node1 = reversel2(node1);

        NodeDemo head1 = node1;
        while(head1 != null){
            System.out.println("args s = [" + head1.getData() + "]");
            head1 =head1.getNext();
        }

    }

    private static NodeDemo reversel(NodeDemo head) {
        if (head == null)
            return head;
        NodeDemo pre = head;
        NodeDemo current = head.getNext();
        NodeDemo temp ;
        while(current != null){
            temp = current.getNext();
            current.setNext(pre);
            pre = current;
            current = temp;
        }
        head.setNext(null);

        return pre;
    }


    public static NodeDemo reversel2(NodeDemo head){
        if (head == null || head.getNext() == null)
            return head;

        NodeDemo reHead = reversel2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return  reHead;
    }

}

class NodeDemo {
    private int Data;// 数据域
    private NodeDemo Next;// 指针域

    public NodeDemo(int Data) {
        // super();
        this.Data = Data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int Data) {
        this.Data = Data;
    }

    public NodeDemo getNext() {
        return Next;
    }

    public void setNext(NodeDemo next) {
        Next = next;
    }
}
