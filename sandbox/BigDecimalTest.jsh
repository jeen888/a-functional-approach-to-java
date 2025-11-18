// 일반 double 타입
double d1 = 0.1;
double d2 = 0.2;
System.out.println("0.1 + 0.2 (double): " + (d1 + d2)); 
// 결과: 0.30000000000000004 (정확히 0.3이 아님)

// 생성 시 문자열("0.1")을 사용해야 double의 오차를 방지할 수 있습니다.
BigDecimal bd1 = new BigDecimal("0.1");
BigDecimal bd2 = new BigDecimal("0.2");

// 덧셈 연산은 add() 메서드를 사용
BigDecimal sum = bd1.add(bd2);
System.out.println("0.1 + 0.2 (BigDecimal): " + sum); // 결과: 0.3 (정확함)

// 10을 3으로 나누는 연산
BigDecimal num = new BigDecimal("10");
BigDecimal div = new BigDecimal("3");

try {
    // ⚠️ 오류 발생: 나누어 떨어지지 않는 경우 RoundingMode가 없으면 ArithmeticException 발생
    BigDecimal resultError = num.divide(div); 
} catch (ArithmeticException e) {
    System.out.println("\n오류: 나누어 떨어지지 않아 예외 발생 -> RoundingMode 지정 필요");
}

// ✅ 올바른 나눗셈: 소수점 2자리(Scale: 2)까지 표현하고, 3번째 자리에서 반올림(HALF_UP)
BigDecimal result = num.divide(
    div, 
    2,              // Scale: 소수점 이하 두 자리까지
    RoundingMode.HALF_UP // Rounding Mode: 반올림
);

System.out.println("10 / 3 (Scale=2, HALF_UP): " + result); // 결과: 3.33
System.out.println(Objects.hash("가", "나", "다"));

/exit