//OOP-e01-박지연

public class E01{
    public static void main(String[] args) {
        // 첫 번째 함수 실행 예제
        int maxResult = findMax(22, 3, 7);
        System.out.println("가장 큰 정수는: " + maxResult);

        // 두 번째 함수 실행 예제
        int n = 7;
        int factorialResult = factorial(n);
        System.out.println(n + " 팩토리얼은: " + factorialResult);
    }

    // 첫 번째 함수: 세 정수 중 가장 큰 정수 반환
    public static int findMax(int num1, int num2, int num3) {
        int max = num1;
        if (num2 > max) {
            max = num2;
        }
        if (num3 > max) {
            max = num3;
        }
        return max;
    }

    // 두 번째 함수: n 팩토리얼 계산
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}


