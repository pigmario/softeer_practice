import java.util.*;

public class GarageGame {
    public static void main(String args[])
    {
        // 입력받아서 큐만들기
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine()); // 차고지 수(<=4)

        List<Queue<Integer>> chargoList = new ArrayList<>();
        for(int i=0 ; i<3*N ; i++){
            String lineData = sc.nextLine();

            String[] partDatas = lineData.split(" ");
            for(int j=0 ; j<partDatas.length ; j++){
                Queue<Integer> queue;
                if(i == 0) {
                    queue = new LinkedList<>();
                    chargoList.add(queue);
                } else queue = chargoList.get(j);

                queue.add(Integer.parseInt(partDatas[j]));
            }
        }

        for(int k=0 ; k<chargoList.size() ; k++){
            System.out.println("k : " + k);
            System.out.println(chargoList.get(k).toString());
        }
    }
}
