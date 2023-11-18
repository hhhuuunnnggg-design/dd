package do_an_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chitietphieunhap_t {
    public static void main(String[] args) {
        DANHSACH9.goi9();
    }
}

class chitiet9 {
    private int machitietphieunhap;
    private int masanpham;
    private static int soluong;
    private static float dongia;
    private float thanhtien;

    public chitiet9() {
    }

    public chitiet9(int machitietphieunhap, int masanpham, int soluong, float dongia) {
        this.machitietphieunhap = machitietphieunhap;
        this.masanpham = masanpham;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = soluong * dongia;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã chi tiết phiếu nhập: ");
        machitietphieunhap = sc.nextInt();
        System.out.println("Nhập mã sản phẩm: ");
        masanpham = sc.nextInt();
        System.out.println("Nhập số lượng: ");
        soluong = sc.nextInt();
        System.out.println("Nhập Đơn giá: ");
        dongia = sc.nextFloat();
        thanhtien = soluong * dongia;
    }

    public void xuat() {
        System.out.println("*******************************");
        System.out.println("Mã chi tiết phiếu nhập: " + machitietphieunhap);
        System.out.println("Mã sản phẩm :" + masanpham);
        System.out.println("Số lượng " + soluong);
        System.out.println("Đơn giá " + dongia);
        System.out.println("Thành tiền: " + thanhtien);
    }

    /*public void xuat10000000000() {
        System.out.println("Mã chi tiết phiếu nhập: " + machitietphieunhap);
    }
*/
    public int getMachitietphieunhap() {
        return machitietphieunhap;
    }

    public void setMachitietphieunhap(int machitietphieunhap) {
        this.machitietphieunhap = machitietphieunhap;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public static float getThanhtien() {
        return dongia*soluong;
    }
}

class DANHSACH9 {
    private static int n;
     static chitiet9[] ct9;
    private static int max = 50;

    private static int tongSoLuong;
    private static float tongThanhTien;
    private static Map<Integer, chitiet9> maCTPNMap;
    

    static {
        n = 0;
        ct9 = new chitiet9[max];
        maCTPNMap = new HashMap<>();
    }

    public static float getThanhTien() {
        float tongTien = 0;
        for (int i = 0; i < n; i++) {
            tongTien += ct9[i].getThanhtien();
        }
        return tongTien;
    }

    public static void codecung9(chitiet9 ct2) {
        if (n < max) {
            if (!kiemTraTrungMa(ct2.getMachitietphieunhap())) {
                DANHSACH9.ct9[n] = ct2;
                n++;

                tongSoLuong += ct2.getSoluong();
                tongThanhTien += ct2.getThanhtien();

                maCTPNMap.put(ct2.getMachitietphieunhap(), ct2);
                System.out.println("Đã thêm thành công");
            } else {
                System.out.println("Mã chi tiết phiếu nhập đã tồn tại. Không thể thêm mới.");
            }
        } else {
            System.out.println("Danh sách đã đầy");
        }
    }

    public static void lay_tong1() {
        System.out.println("Tổng số lượng: " + tongSoLuong);
        System.out.println("Tổng thành tiền: " + tongThanhTien);
    }

    public static void thongKeNangCao() {
        System.out.println("Tổng số lượng: " + tongSoLuong);
        System.out.println("Tổng thành tiền: " + tongThanhTien);
    }

    public static void xuatds() {
        if (n == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }

        for (int i = 0; i < n; i++) {
            ct9[i].xuat();
        }
    }

    public static void themds(int maphieunhap) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================");
        chitiet9 newct2 = new chitiet9();
        newct2.nhap();

        newct2.setMachitietphieunhap(maphieunhap);

        boolean kt = kiemTraTrungMa(newct2.getMachitietphieunhap());

        while (kt) {
            System.out.println("Mã chi tiết phiếu nhập đã tồn tại. Vui lòng nhập lại.");
            newct2.nhap();
            kt = kiemTraTrungMa(newct2.getMachitietphieunhap());
        }

        if (n < max) {
            ct9[n] = newct2;
            n++;

            tongSoLuong += newct2.getSoluong();
            tongThanhTien += newct2.getThanhtien();
            System.out.println("Đã thêm thành công");
        } else {
            System.out.println("Danh sách đã đầy");
        }
    }

    private static boolean kiemTraTrungMa(int ma) {
        for (int i = 0; i < n; i++) {
            if (ct9[i].getMachitietphieunhap() == ma) {
                return true;
            }
        }
        return false;
    }

    public static void xoads() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("Nhập mã cần xóa");
        int cc = sc.nextInt();
        boolean kt1 = false;
        for (int i = 0; i < n; i++) {
            if (ct9[i].getMachitietphieunhap() == cc) {
                for (int j = i; j < n; j++) {
                    ct9[j] = ct9[j + 1];
                }
                n--;
                kt1 = true;
                System.out.println("Mã chi tiết  phiếu nhập đã được xóa");
                break;
            }
        }
        if (!kt1) {
            System.out.println("Không tìm thấy mã phiếu nhập");
        }
    }

    public static void timkiemds1() {
        while (true) {
            System.out.println("1.Tìm kiếm theo mã ");
            System.out.println("2.Tìm kiếm theo số lượng");
            System.out.println("3. back ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("==================================");
                    System.out.print("Nhập mã chi tiết phiếu nhập cần tìm kiếm: ");
                    int ma = sc.nextInt();
                    boolean thayma = false;

                    for (int i = 0; i < n; i++) {
                        if (ct9[i].getMachitietphieunhap() == ma) {
                            System.out.println("Đã tìm thấy:");
                            thayma = true;
                            ct9[i].xuat();
                            break;
                        }
                    }

                    if (!thayma) {
                        System.out.println("Không tìm thấy mã chi tiết phiếu nhập");
                    }

                    break;

                case 2:
                    System.out.print("Nhập giá trị số lượng cần tìm kiếm: ");
                    int soLuongCanTim = sc.nextInt();
                    boolean coChiTiet = false;

                    System.out.println("Các chi tiết phiếu nhập có số lượng lớn hơn " + soLuongCanTim + ":");

                    for (int j = 0; j < n; j++) {
                        if (ct9[j].getSoluong() > soLuongCanTim) {
                            ct9[j].xuat();
                            coChiTiet = true;
                        }
                    }

                    if (!coChiTiet) {
                        System.out.println("Không có số lượng lớn hơn " + soLuongCanTim);
                    }

                    break;
                case 3:
                    goi9();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
    }

    public static void tongtien1() {
        float tongtien = 0;
        for (int i = 0; i < n; i++) {
            tongtien += ct9[i].getThanhtien();
        }
        System.out.println(tongtien);
    }

    public static void goi9() {
        DANHSACH9.codecung9(new chitiet9(1254, 125, 5, 100));
        DANHSACH9.codecung9(new chitiet9(15421, 415, 3, 125));
        DANHSACH9.codecung9(new chitiet9(9, 102, 5, 50));
        DANHSACH9.codecung9(new chitiet9(20, 145, 7, 200));
        DANHSACH9.codecung9(new chitiet9(300, 115, 6, 375));

        while (true) {
            System.out.println("====Menu====");
            System.out.println("1. Thêm phiếu chi tiết ");
            System.out.println("2. Xóa phiếu nhập chi tiết");
            System.out.println("3. Tìm kiếm phiếu nhập chi tiết");
            System.out.println("4. Xuất danh sách phiếu nhập chi tiết ");
            System.out.println("5. Thống kê");
            System.out.println("6. Quay về màn hình chính ");
            System.out.println("0. Thoát");
            System.out.print("Chọn thao tác: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    DANHSACH9.themds(choice);
                    break;
                case 2:
                    DANHSACH9.xoads();
                    break;
                case 3:
                    DANHSACH9.timkiemds1();
                    break;
                case 4:
                    DANHSACH9.xuatds();
                    break;
                case 5:
                    DANHSACH9.thongKeNangCao();
                    break;
                case 6:
                    cocc cc = new cocc();
                    cc.haha();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }
}


