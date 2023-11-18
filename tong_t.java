package do_an_test;



import java.util.Scanner;

public  class tong_t {
	public static void main(String[] args) {
		cocc cc;//= new cocc();
		cocc .haha();
		
	}

	
}
class  cocc{
	public static  void haha() {
		DANHSACH ncc ;//= new DANHSACH();
		DANHSACH1 pn;// = new DANHSACH1();
		DANHSACH9 ctpn;// = new DANHSACH2();
		System.out.println("**************************");
		System.out.println("*    MÀN HÌNH CHÍNH      *");
		System.out.println("* 1. nhà cung cấp         *");
		System.out.println("* 2. Phiếu nhập          *");
		System.out.println("* 3. Chi tiết phiếu nhập *");
		System.out.println("*************************");
		
		Scanner sc = new Scanner(System.in);
		int chose=sc.nextInt();
		switch (chose) {
			case 1: 
				DANHSACH.goi1();
				break;
			case 2:
				DANHSACH1.goi2();
				break;
			case 3:
				DANHSACH9.goi9();
				break;
			case 0:
                System.exit(0); // Thoát khỏi chương trình
                break;
            default:
                System.out.println("Lua chon khong hop le. Vui long chon lai.");
                //break;
		} 
	}
}