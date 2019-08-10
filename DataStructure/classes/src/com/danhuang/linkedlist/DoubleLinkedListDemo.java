package com.danhuang.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //进行双向链表测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
        HeroNode2 hero5 = new HeroNode2(4,"公孙胜","入云龙");
        //修改
        doubleLinkedList.update(hero5);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的情况");
        doubleLinkedList.list();
    }
}

//创建一个双向链表类
class DoubleLinkedList{
    //初始化一个头结点,头结点不要动
    private HeroNode2 head = new HeroNode2();

    public HeroNode2 getHead() {
        return head;
    }

    // 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
    // 只是 节点类型改成 HeroNode2
    public void update(HeroNode2 newHeroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while(temp != null){

            if(temp.no == newHeroNode.no){
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{//没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    // 从双向链表中删除一个节点,
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点
    // 2 找到后，自我删除即可
    public void del(int no) {

        //判断当前聊表是否为空
        if(head.next == null) {//空链表
            System.out.println("链表为空，无法删除");
            return ;
        }
        HeroNode2 temp = head.next;  //辅助指针
        boolean flag = false; // 标志是否找到待删除节点的
        while(temp != null){

            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            if(temp.next != null){//如果temp不是最后一个节点
                temp.next.pre = temp.pre;
            }
            temp.pre.next = temp.next;
        }else{
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

    // 添加一个节点到双向链表的最后.
    public void add(HeroNode2 heroNode){

        //因为head节点不能动，因此我们需要一个辅助节点temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while(temp.next != null){
            temp = temp.next;
        }
        //连接
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //遍历双向链表的方法
    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while(temp != null) {//判断是否到链表最后
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }

}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点，默认为null
    public HeroNode2 pre;//指向前一个节点，默认为null

    public HeroNode2(){

    }
    //构造器
    public HeroNode2(int hNo,String hName,String hNickname){
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }

    //为了显示方便，我们重写toString

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

