import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuanLy {
    static LinkedList<DonVi> list;
    static int soDV;
    
    public static String thongTinCoBan(){
        //Tên chủ tịch
        //tên các công ty con và giám đốc, phó giám đốc tương ứng
        //tên các phòng ban và trưởng, phó phòng tương ứng
        //tổng số nhân viên của công ty
        
        int i;
        String s = null;
        
        for (i=0;i<list.size();i++){
            if (list.get(i).getTenDonVi().equals("BK Corporation"))
                s = "Chu tich: " + list.get(i).getTruongDonVi() + "\n";
            //if (list.get(i).getTenDonVi().equals(""))
        }
        
        return s;
    }
    
    public static DonVi timKiemDonVi(String tenDonVi){
    	//tìm kiếm đơn vị theo tên
    	//trả về tham chiếu đến đơn vị đó, không tìm thấy thì trả về null
        int i; 
        
        for (i=0;i<list.size();i++)
            if (list.get(i).getTenDonVi().equals(tenDonVi))               
                return list.get(i);
        
        return null;        
    }
    
    public static String timKiemTheoHoTen(String hoVaTen){
    	//Trả về các nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng DonVi.timKiemTheoHoTen() để tìm kiếm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên
        
        String s = "";
        LinkedList<NhanVien> listnv;           
        int i;
        
        for (i=0;i<list.size();i++){
            //Lấy ra 1ist NhanVien có họ tên này trong từng đơn vị 
            listnv = list.get(i).timKiemTheoHoTen(hoVaTen);
            
            //trả về xâu thông tin
            int j;
            for (j=0;j<listnv.size();j++)
                s += listnv.get(i).toString();           
        }
        
        if (s.equals(""))
            s = "Khong tim thay!";
        
        return s;          	
    }
    
    public static String timKiemTheoChucVu(String s){
    	//Trả về các nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng DonVi.timKiemTheoChucVu() để tìm kiếm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên 
        
        String s1 = "";
        LinkedList<NhanVien> listnv;           
        int i;
        
        for (i=0;i<list.size();i++){
            //Lấy ra 1ist NhanVien có chức vụ này trong từng đơn vị 
            listnv = list.get(i).timKiemTheoChucVu(s);
            
            //trả về xâu thông tin
            int j;
            for (j=0;j<listnv.size();j++)
                s1 += listnv.get(i).toString();           
        }
        
        if (s1.equals(""))
            s1 = "Khong tim thay!";
        
        return s1;
    }
    
    public static String timKiemTheoNgaySinh(Date d){
    	//Trả về các nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng DonVi.timKiemTheoNgaySinh() để tìm kiếm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên
        
        String s = "";
        LinkedList<NhanVien> listnv;           
        int i;
        
        for (i=0;i<list.size();i++){
            //Lấy ra 1ist NhanVien có ngày sinh này trong từng đơn vị 
            listnv = list.get(i).timKiemTheoNgaySinh(d);
            
            //trả về xâu thông tin
            int j;
            for (j=0;j<listnv.size();j++)
                s += listnv.get(i).toString();           
        }
        
        if (s.equals(""))
            s = "Khong tim thay!";
        return s;
        
    }
    
    public static NhanVien timKiemMSNV(String msnv)
    {
    	//dùng DonVi.timKiemTheoMSNV() để tìm kiếm
        int i;
        NhanVien nv = null;
        for (i=0;i<list.size();i++)
            nv = list.get(i).timKiemTheoMSNV(msnv);
        
        return nv;
    }
    
    public static String timKiemTheoMSNV(String s){
    	//Trả về nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng timKiemMSNV để tìm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên
        
        String s1 = "";   
        NhanVien nv;
        int i;
        
        for (i=0;i<list.size();i++){
            //Lấy ra nhân viên có MSNV này 
            nv = list.get(i).timKiemTheoMSNV(s);
            
            //trả về xâu thông tin
            s1 += nv.toString();
        }
        
        if (s1.equals(""))
            s1 = "Khong tim thay!";
        return s1;
        
    }
    
    public static String tinhTrangLamViec(String MSNV){
    	//Trả về, thông tin cơ bản và tình trạng làm việc của nhân viên
    	//Nếu không tồn tại nhân viên, trả về "Không tìm thấy"
    	//Dùng DonVi.timKiemTheoMSNV() để tìm nhân viên, rồi dùng NhanVien.thongTinLamViec(), NhanVien.soGioThieuHut()
        String s = "";
        NhanVien nv;
        int i;
        
        for (i=0;i<list.size();i++){
            //Lấy ra nhân viên có MSNV này 
            nv = list.get(i).timKiemTheoMSNV(s);
            
            //trả về xâu thông tin
            s += nv.thongTinLamViec();
        }
        
        if (s.equals(""))
            s = "Khong tim thay!";
        
        return s;
    } 

    public static String thongTinDonVi(String tenDonVi){
    	//trả về xâu chứa thông tin của 1 đơn vị, dùng timKiemDonVi để tìm kiếm, dùng DonVi.toString()
    	//nếu không tồn tại đơn vị, trả về "Không tồn tại đơn vị"
        String s = "";
        DonVi dv;           
        int i;
        
        for (i=0;i<list.size();i++){
            //Lấy ra đơn vị có tên đơn vị này
            dv = QuanLy.timKiemDonVi(tenDonVi);
            
            //trả về xâu thông tin
            s = dv.toString();
        }
        
        if (s.equals(""))
            s = "Khong tim thay!";
        
        return s;
    }
    
    public static String thongTinDonVi(DonVi donVi){
    	//trả về xâu chứa thông tin của 1 đơn vị, dùng DonVi.toString()
    	//nếu không tồn tại đơn vị, trả về "Không tồn tại đơn vị"
        String s = "";
        DonVi dv;           
        int i;
        
        for (i=0;i<list.size();i++){
            //Lấy ra đơn vị có tên đơn vị này
            dv = QuanLy.timKiemDonVi(donVi.getTenDonVi());
            
            //trả về xâu thông tin
            s = dv.toString();
        }
        
        if (s.equals(""))
            s = "Khong tim thay!";
        return s;
    }
    
    public static void themNhanVien(NhanVien nv, String tenDonVi){} 
    
    public static void capNhatThongTin(NhanVien nv, DonVi dv){} 
    
    public static void init() throws FileNotFoundException
    {
    	//đọc dữ liệu từ file
    	//đặt giờ bắt đầu làm việc, kết thúc làm việc trong NgayLamViec
        File f = new File("ThongTinNhanVien.txt");
        FileReader fr = new FileReader(f);
        
        
        
        
        
    }
    
    
    static void clear() throws IOException
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
    
    public static void main(String [] args) throws java.text.ParseException, IOException{
        
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
						SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
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
					if (nv.edit(nv, properties, list) == true)
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