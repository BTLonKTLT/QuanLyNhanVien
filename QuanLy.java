
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class QuanLy {
    LinkedList<DonVi> list;
    int soDV;
    
    public QuanLy(){
        // Đọc dữ liệu từ file vào
        // Đọc đơn vị
        // Nếu đơn vị chưa tồn tại -> Tạo 1 DonVi mới, soDV++;
        // Đơn vị đã tồn tại
        // Gọi phương thức themNhanVien(NhanVien nv) của DonVi
    }
    
    public String thongTinCoBan(){
        //Tên chủ tịch
        //tên các công ty con và giám đốc, phó giám đốc tương ứng
        //tên các phòng ban và trưởng, phó phòng tương ứng
        //tổng số nhân viên của công ty
    }
    
    public String timKiemTheoHoTen(String s){} 
    
    public String timKiemTheoChucVu(String s){} 
    
    public String timKiemTheoNgaySinh(Date d){}
    
    public String timKiemTheoMSNV(String s){}
    
    public String tinhTrangLamViec(String MSNV){} 

    public String thongTinDonVi(String TenDonVi){} 
    
    public void themNhanVien(NhanVien nv, DonVi dv){} 
    
    public void capNhatThongTin(NhanVien nv, DonVi dv){} 
    
    public void exit(){} 
    
    public static void main(String [] args){
        //switch case -> chọn 1 trong các chức năng
        
    	Scanner input = new Scanner(System.in);
		String choice;
		while(true)
		{
			System.out.println("Quản lý nhân sự BK Corporation");
			System.out.println("---------------------------------");
			System.out.println("1. Thông tin cơ bản");
			System.out.println("2. Tìm kiếm thông tin nhân viên");
			System.out.println("3. Hiển thị tình trạng làm việc của nhân viên");
			System.out.println("4. Hiển thị tình trạng của một đơn vị");
			System.out.println("5. Thêm nhân viên mới");
			System.out.println("6. Cập nhật thông tin nhân viên");
			System.out.println("7. Thoát");
			System.out.print("Chọn 1 trong các chức năng sau: "); 
			choice = input.nextLine();
			
			switch(choice.charAt(0))
			{
			case '1': //Thông tin cơ bản
				
				break;
			case '2': //Tìm kiếm thông tin nhân viên
				
	
				break;
			case '3': //Hiển thị tình trạng làm việc của nhân viên
				
				break;
			case '4': //Hiển thị tình trạng của một đơn vị
				
				break;
			case '5': //Thêm nhân viên mới
				
				break;
			case '6': //Cập nhật thông tin nhân viên
				
				break;
			case '7': //Thoát
				
				break;
			
				
			}
			choice = input.nextLine();
		
    }
}
