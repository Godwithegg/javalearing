import java.util.*;
//全排序 输入 abc 输出abc全排序
public class Main{

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String line;
        while(in.hasNext()){
            line = in.next();
            char[] c = line.toCharArray();
            Arrays.sort(c);
            line="";
            for (char c1 : c) {
                line+=c1;
            }
            int[] visit = new int[line.length()];
            List<List<Character>> list = new ArrayList<>();
            allSort(list,line,visit,new ArrayList<>());
            for (int i =0;i<list.size();i++) {
                List<Character> s = list.get(i);
                for (Character ch : s) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    static void allSort(List<List<Character>> list,String line,int[] visit,ArrayList<Character> temp){

        if(temp.size() == line.length()){
            list.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=0;i<line.length();i++){
            if(visit[i]==1)continue;
            visit[i]=1;
            temp.add(line.charAt(i));
            allSort(list, line, visit,temp );
            visit[i]=0;
            temp.remove(temp.size()-1);
        }
    }




}