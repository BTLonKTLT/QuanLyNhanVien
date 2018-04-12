
import java.util.LinkedList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class NhanVien {
    private String MSNV;
    private String ho;
    private String ten;
    private DonVi tenDonVi;
    private String chucVu;
    private Date ngaySinh;
    private String queQuan;
    private String diaChi;
    private String email;
    private String SDT;
    private Date ngayBatDauLV;
    private LinkedList<NgayLamViec> ngayLamViec;
    
    private static int soNhanVien = 0;
    public static final int  _HOTEN = 0b1, _TENDONVI = 0b10, _CHUCVU = 0b100, _NGAYSINH = 0b1000, _QUEQUAN = 0b10000, _DIACHI = 0b100000, _EMAIL = 0b1000000, _SDT = 0b10000000; 
    //public NhanVien(String data){} // Lấy dữ liệu từ file txt
    
    //Phương thức khởi tạo nhiều tham số
    public NhanVien(LinkedList<DonVi> list, String MSNV, String ho, String ten, String tenDonVi, String chucVu, Date ngaySinh, String queQuan, String diaChi, String email, String SDT, Date ngayBatDauLV, LinkedList<NgayLamViec> ngayLamViec)
    {
    	//duyệt list, nếu đã tồn tại đơn vị: gán cho tenDonVi, thêm nhân viên vào đơn vị đó. Nếu không có, tạo 1 đơn vị mới, rồi thêm vào đơn vị đó
    	soNhanVien++;
    }
    //Phương thức khởi tạo ít tham số, nhập từ bàn phím các dữ liệu
    public NhanVien(LinkedList<DonVi> list)
	{
		Scanner input = new Scanner(System.in);
		// Nhập dữ liệu từ bàn phím các thông tin: họ tên, ngày sinh, đơn vị, chức vụ, quê quán, địa chỉ, email,
		//số điên thoại, ngày bắt đầu làm việc
		//cấp mã số nhân viên tự động dựa theo soNhanVien hiện tại 
		//gọi đến phương thức khởi tạo phía trên
		
		
	}
    
    // Các phương thức getter và setter

    public int soGioThieuHut(){
        //Giả sử ngày làm việc 8 tiếng từ 8:30 đến 17:30
        //đọc từng dòng của ngayLamViec -> tính số giờ thiếu hụt
        //Tính tổng 
    }  
    
    public String toString(){
    // Hiển thị thông tin cơ bản của nhân viên
    }
    
    public boolean edit(int properties, LinkedList<DonVi> list)
    {
    	//properties là biến cờ các thuộc tính cần sửa: _HOTEN, _TENDONVI, _CHUCVU_NGAYSINH, _QUEQUAN, _DIACHI, _EMAIL, _SDT
    	// (properties & _HOTEN) != 0 ----> cần sửa họ tên
    	// (properties & _TENDONVI) != 0 ----> cần sửa tên đơn vị 
    	//.......
  
    	//Dùng Scanner để nhập từ bàn phím dữ liệu thay thế
    	//Dùng phương thức khởi tạo nhiều tham số, tạo đối tượng nhân viên thay thế
    	//Xóa nhân viên này khỏi list của DonVi
    	//Sửa trong file
    	//Trả về true nếu sửa thành công, false nếu thất bại

    }
    
}
