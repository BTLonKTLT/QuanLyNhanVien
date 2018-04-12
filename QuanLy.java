
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class QuanLy {
    static LinkedList<DonVi> list;
    static int soDV;
    
//    public QuanLy(){
//        // Đọc dữ liệu từ file vào
//        // Đọc đơn vị
//        // Nếu đơn vị chưa tồn tại -> Tạo 1 DonVi mới, soDV++;
//        // Đơn vị đã tồn tại
//        // Gọi phương thức themNhanVien(NhanVien nv) của DonVi
//    }
    
    public static String thongTinCoBan(){
        //Tên chủ tịch
        //tên các công ty con và giám đốc, phó giám đốc tương ứng
        //tên các phòng ban và trưởng, phó phòng tương ứng
        //tổng số nhân viên của công ty
    }
    
    public static DonVi timKiemDonVi(String tenDonVi){
    	//tìm kiếm đơn vị theo tên
    	//trả về tham chiếu đến đơn vị đó, không tìm thấy thì trả về null
    }
    
    public static String timKiemTheoHoTen(String hoVaTen){
    	//Trả về các nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng DonVi.timKiemTheoHoTen() để tìm kiếm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên
    	
    }
    
    public static String timKiemTheoChucVu(String s){
    	//Trả về các nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng DonVi.timKiemTheoChucVu() để tìm kiếm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên 
    }
    
    public static String timKiemTheoNgaySinh(Date d){
    	//Trả về các nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng DonVi.timKiemTheoNgaySinh() để tìm kiếm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên
    }
    
    public static NhanVien timKiemMSNV(String msnv)
    {
    	//dùng DonVi.timKiemTheoMSNV() để tìm kiếm
    }
    public static String timKiemTheoMSNV(String s){
    	//Trả về nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng timKiemMSNV để tìm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên
    }
    
    public static String tinhTrangLamViec(String MSNV){
    	//Trả về, thông tin cơ bản và tình trạng làm việc của nhân viên
    	//Nếu không tồn tại nhân viên, trả về "Không tìm thấy"
    	//Dùng DonVi.timKiemTheoMSNV() để tìm nhân viên, rồi dùng NhanVien.toString(), NhanVien.soGioThieuHut()
    } 

    public static String thongTinDonVi(String TenDonVi){
    	//trả về xâu chứa thông tin của 1 đơn vị, dùng timKiemDonVi để tìm kiếm, dùng DonVi.toString()
    	//nếu không tồn tại đơn vị, trả về "Không tồn tại đơn vị"
    }
    
    public static String thongTinDonVi(DonVi donVi){
    	//trả về xâu chứa thông tin của 1 đơn vị, dùng DonVi.toString()
    	//nếu không tồn tại đơn vị, trả về "Không tồn tại đơn vị"
    }
    
    public static void themNhanVien(NhanVien nv, String tenDonVi){} 
    
    public static void capNhatThongTin(NhanVien nv, DonVi dv){} 
    
    public static void init()
    {
    	//đọc dữ liệu từ file
    	//đặt giờ bắt đầu làm việc, kết thúc làm việc trong NgayLamViec
    }
    
    
    static void clear()
    {
    	String os = System.getProperty("os.name");
    	if (os.contains("Windows"))
    	{
    		Runtime.getRuntime().exec("cls");
    	}
    	else
    	{
    		Runtime.getRuntime().exec("clear");
    	}
    }
    
    public static void main(String [] args){
        
    	init();
    	
    	
    	//switch case -> chọn 1 trong các chức năng
        
    	Scanner input = new Scanner(System.in);
		String choice;
		while(true)
		{
			
			clear();
			
			System.out.println("Quản lý nhân sự BK Corporation");
			System.out.println("---------------------------------");
			System.out.println("1. Thông tin cơ bản");
			System.out.println("2. Tìm kiếm thông tin nhân viên");
			System.out.println("3. Hiển thị tình trạng làm việc của nhân viên");
			System.out.println("4. Hiển thị tình trạng của một đơn vị");
			System.out.println("5. Thêm nhân viên mới");
			System.out.println("6. Cập nhật thông tin nhân viên");
			System.out.println("7. Thoát");
			System.out.print("Lựa chọn của bạn: "); 
			choice = input.nextLine();
			
			clear();
			switch(choice.charAt(0))
			{
			case '1': //Thông tin cơ bản
				
				break;
			case '2': //Tìm kiếm thông tin nhân viên
				while(true) {
					System.out.println("___________Tìm kiếm nhân viên___________");
					System.out.println("1. Tìm theo họ tên");
					System.out.println("2. Tìm theo chức vụ");
					System.out.println("3. Tìm theo ngày sinh");
					System.out.println("4. Tìm theo mã số nhân viên");
					System.out.println("5. Trở lại");
					System.out.print("Lựa chọn của bạn: "); 
					choice = input.nextLine();
					switch(choice.charAt(0))
					{
					case '1':
						System.out.println("___________Tìm kiếm nhân viên theo họ tên___________");
						System.out.print("Nhập họ tên: ");
						String hoVaTen = input.nextLine();
						System.out.println(timKiemTheoHoTen(hoVaTen));
						break;
					case '2':
						System.out.println("___________Tìm kiếm nhân viên theo chức vụ___________");
						System.out.print("Nhập chức vụ: ");
						String chucVu = input.nextLine();
						System.out.println(timKiemTheoChucVu(chucVu));
						break;
					case '3':
						System.out.println("___________Tìm kiếm nhân viên theo ngày sinh___________");
						System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
						SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy")
						try{
							Date ngaySinh = format.parse(input.nextLine());
						
							System.out.println(timKiemTheoNgaySinh(ngaySinh));
						}
						catch(ParseException e)
						{
							System.out.println("Ngày sinh không đúng định dạng");
						}
						break;
					case '4':
						System.out.println("___________Tìm kiếm nhân viên theo mã số___________");
						System.out.print("Nhập mã số nhân viên: ");
						String maSoNhanVien = input.nextLine();
						System.out.println(timKiemTheoMSNV(maSoNhanVien));
						break;
					}
					if (choice.charAt(0) == '5')
						break;
					choice = input.nextLine();
				}
				
				break;
			case '3': //Hiển thị tình trạng làm việc của nhân viên
				System.out.println("___________Hiển thị tình trạng làm việc của nhân viên___________");
				System.out.println("Nhập mã nhân viên: ");
				String maNhanVien = input.nextLine();
				System.out.println(tinhTrangLamViec(maNhanVien));
				
				break;
			case '4': //Hiển thị tình trạng của một đơn vị
				System.out.println("___________Hiển thị tình trạng của một đơn vị___________");
				int i = 1;
				for(DonVi dv : list)
				{
					System.out.println(i + ", " + dv.getTenDonVi());
					i++;
				}
				
				System.out.println("------------------");
				System.out.print("Chọn đơn vị số: ");
				
				try
				{
					i = input.nextInt();
					if (i <= soDV)
						System.out.println(thongTinDonVi(list.get(i)));
					else
						System.out.println("Không hợp lệ");
				}
				catch(InputMismatchException e)
				{
					System.out.println("Không hợp lệ");
				}
				
				
				break;
			case '5': //Thêm nhân viên mới
				System.out.println("___________Thêm nhân viên mới___________");
				NhanVien nv = new NhanVien(list);
				
				break;
			case '6': //Cập nhật thông tin nhân viên
				System.out.println("Nhập mã nhân viên: ");
				maNhanVien = input.nextLine();
				nv = timKiemMSNV(maNhanVien);
				if (nv == null)
				{
					System.out.println("Không tồn tại");
				}
				else
				{
					System.out.println(nv.toString());
					System.out.println("-------------------------");
					System.out.println("1. Sửa họ tên");
					System.out.println("2. Sửa đơn vị");
					System.out.println("3. Sửa chức vụ");
					System.out.println("4. Sửa ngày sinh");
					System.out.println("5. Sửa quê quán");
					System.out.println("6. Sửa địa chỉ");
					System.out.println("7. Sửa email");
					System.out.println("8. Sửa số điện thoại");
					
					System.out.print("Các mục bạn muốn sửa (VD: 12345): "); 
					choice = input.nextLine();
					int properties = 0;
					for(i = 1; i <= 8; i++)
					{
						if (choice.contains(Integer.toString(i)))
						{
							properties = properties | (1<<(i-1));
						}
					}
					if (nv.edit(properties, list) == true)
					{
						System.out.println("Cập nhật thành công");
					}
					else
					{
						System.out.println("Cập nhật thất bại");
					}
					
				}
				break;
			case '7': //Thoát
				System.exit(0);
				break;
			
				
			}
			choice = input.nextLine();
		
		}
    }

}
