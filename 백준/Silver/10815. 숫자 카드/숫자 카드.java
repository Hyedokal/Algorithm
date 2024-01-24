import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static int[] numCards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str); // 가지고 있는 숫자 카드 수
        numCards = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            numCards[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(numCards); //숫자 카드 정렬

        M = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        for(int i=0; i<M; i++){
            int toFind = Integer.parseInt(s[i]);
            System.out.print(binarySearch(numCards, toFind) + " ");
        }
    }

    static int binarySearch(int[] arr, int target){
        int start = 0;  //시작 값의 인덱스
        int end = N-1; //끝 값의 인덱스
        int mid;  //중간 값의 인덱스

        while(start <= end){
            mid = (start+end)/2;
            //값을 찾으면 1을 리턴.
            if(arr[mid] == target) return 1;
            else if(arr[mid] > target) { // 중간 값이 찾는 값보다 크면...
                end = mid-1;
            } else{ //중간 값이 찾는 값보다 작으면..
                start = mid+1;
            }
        }
        return 0;
    }
}