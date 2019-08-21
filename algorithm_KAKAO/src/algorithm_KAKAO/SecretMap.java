package algorithm_KAKAO;

public class SecretMap {

	public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        
        arr1 = new int[]{9, 20, 28, 18, 11};
        arr2 = new int[]{30, 1, 21, 17, 28};
        printArr(decodeScreetMap(5, arr1, arr2));
        
        arr1 = new int[]{46, 33, 33 ,22, 31, 50};
        arr2 = new int[]{27 ,56, 19, 14, 14, 10};
        printArr(decodeScreetMap(6, arr1, arr2));
    }
    
    /**
     * 입력받은 arr1, arr2의 각 int를 or연산 처리 
     * -> bynaryString으로 변환 -> 출력형태에 맞게 문자열  replace
     * @param n
     * @param arr1
     * @param arr2
     * @return
     */
    public static String[] decodeScreetMap(int n, int[] arr1, int[] arr2) {
        String[] retArr = new String[n];
        for(int i = 0; i < n; i++) {
            retArr[i] = Integer.toBinaryString(arr1[i]|arr2[i])
                    .replace("0", " ")  //0은 공백
                    .replace("1", "#"); //1은 # 으로 변환
        }
        return retArr;
    }
    
    /**
     * 배열을 입력받아 println
     * @param arr
     */
    public static void printArr(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for(String str: arr) {
            sb.append(", \""+str+"\"");
        }
        System.out.println(sb.toString().replaceFirst(", ", ""));
    }



}

/*
 * if(imsi1.length() == n1) {
 * 
 * } else { //4 < 5 imsi3 = imsi2.concat(imsi1); //문자열 붙이기
 * System.out.println(imsi3); array3[i] = Integer.parseInt(imsi3);
 * System.out.println(array3[i]); }
 */