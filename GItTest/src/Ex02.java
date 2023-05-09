
public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("안녕하세용옹옹");
        
        int num =1 ;
        for(int i = 0; i<10; i++) {
        	num *= (i+1); 
        }
        System.out.println("10팩토리얼 : "+num);
        
		int num1 = 10;
		// 정수현 7f라는 데이터를 담는 num2 선언
		float num2 = 7f;
		
		System.out.println(num1/num2);
		//정수형 실수형 연산하면 실수형으로 나오게된다.
		
		//+ : 연결 연산 
		int num3 = 10 ;
		String num4 = "7";
		System.out.println(num3+num4+num2);
        
        
	}

}
