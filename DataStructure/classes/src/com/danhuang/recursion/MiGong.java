package com.danhuang.recursion;

public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //挡板
        map[3][1] = map[3][2] = 1;

        //输出地图
        System.out.println("地图情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

//        setWay(map, 1, 1);
        setWay2(map, 1, 1);
        //输出新的地图，小球走过并标识过的递归
        System.out.println("新地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 1.map表示地图
     * 2.i，j表示哪个位置开始找（1，1）
     * 3.如果小球能走到map[6][5]则说明炸找到通路
     * 4.约定：当map[i][j]为0表示改点没有走过，当为1时表示墙，如果为2表示通路，可以走
     * 3表示该点已经走过，但是走不通
     * 5.在走迷宫时，需要确定一个策略（方法） 下->右->上->左
     * 如果找到通路就返回true否则就返回false
     */
    //使用递归回溯来给小球找路
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路已经找到ok
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个点还没有走过
                //按照策略下->右->上->左
                map[i][j] = 2;//假定该点是可以走通的
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左
                    return true;
                } else {
                    //说明该点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j] != 0,可能是1，2，3
                return false;
            }
        }
    }

    //修改找路策略，改成上->右->下->左
    public static boolean setWay2(int[][] map, int i, int j) {

        if (map[6][5] == 2) {//通路已经找到ok
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个点还没有走过
                //按照策略下->右->上->左
                map[i][j] = 2;//假定该点是可以走通的
                if (setWay2(map, i - 1, j)) {//向上
                    return true;
                } else if (setWay2(map, i, j + 1)) {//向右
                    return true;
                } else if (setWay2(map, i + 1, j)) {//向下
                    return true;
                } else if (setWay2(map, i, j - 1)) {//向左
                    return true;
                } else {
                    //说明该点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j] != 0,可能是1，2，3
                return false;
            }
        }
    }


}
