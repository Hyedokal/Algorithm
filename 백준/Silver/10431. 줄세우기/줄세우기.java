import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

//    우선 아무나 한 명을 뽑아 줄의 맨 앞에 세운다.
//    그리고 그 다음부터는 학생이 한 명씩 줄의 맨 뒤에 서면서 다음 과정을 거친다.
//    자기 앞에 자기보다 키가 큰 학생이 없다면 그냥 그 자리에 서고 차례가 끝난다.
//    자기 앞에 자기보다 키가 큰 학생이 한 명 이상 있다면 그중 가장 앞에 있는 학생(A)의 바로 앞에 선다.
//    이때, A부터 그 뒤의 모든 학생들은 공간을 만들기 위해 한 발씩 뒤로 물러서게 된다.
//    이 과정을 반복하면 결국 오름차순으로 줄을 설 수가 있다.
//    아이들의 키가 주어지고, 어떤 순서로 아이들이 줄서기를 할 지 주어진다.
//    위의 방법을 마지막 학생까지 시행하여 줄서기가 끝났을 때 학생들이 총 몇 번 뒤로 물러서게 될까?

    static int P; //테케 수
    static List<Integer> line; //줄 서는 자료구조
    static int count; //뒤로 물러난 걸음 수의 총합.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        P = Integer.parseInt(br.readLine());
        //테케 수만큼 반복문을 돌린다.
        for(int p=1; p<=P; p++){
            line = new ArrayList<>(); //줄 리스트 초기화
            count = 0;  //정답 초기화
            String[] s = br.readLine().split(" ");
            //s[0]은 테케 번호니까 무시
            //규칙대로 줄을 세운다.
            //줄 세우고 나면 오름차순이 될 것이다. (즉 작은 키일수록 앞에 있다.)
            for(int i=1; i<s.length; i++){
                int height = Integer.parseInt(s[i]);
                if(i==1) line.add(height);  //첫번째는 일단 앞에 세운다.
                else{
                    //일단 내가 제일 큰 사람인지 검사하고, 그렇다면 그냥 맨 뒤에 세운다.
                    if(line.get(line.size()-1) <= height) line.add(height);
                    else{
                        //앞에 자기보다 키 큰 학생이 한 명 이상 있다면, 그 중 가장 앞에 있는 학생의 바로 앞에 선다.
                        //따라서 맨 앞부터 순회한다.
                        for(int j=0; j<line.size(); j++){
                            if(line.get(j) > height){ //키 큰 학생이 있다면..
                                line.add(j, height); //height를 j인덱스에 저장(끼워 넣는다).
                                //끼워넣고 나면 내 뒤에 있는 사람 수만큼 걸음 수가 밀려난다.
                                //즉 내가 현재 j인덱스(j+1번째)에 서 있으므로,
                                //(j+2)번째부터 끝까지인 친구들은 한 칸씩 뒤로 물러난 것이다.
                                count += line.size() - (j+1);
                                break;
                            }
                        }
                    }
                }
            }
            //정답 출력
            System.out.println(p + " " + count);
        }


    }
}
