import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Date;
import java.util.Scanner;

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
    public static final int  _HOTEN = 0b1, _TENDONVI = 0b10, _CHUCVU = 0b100, _NGAYSINH = 0b1000; 
    public static final int  _QUEQUAN = 0b10000, _DIACHI = 0b100000, _EMAIL = 0b1000000, _SDT = 0b10000000; 
    
    
    //Phương thức khởi tạo nhiều tham số
    public NhanVien(LinkedList<DonVi> list, String MSNV, String ho, String ten, String tenDonVi, 
                    String chucVu, Date ngaySinh, String queQuan, String diaChi, String email, String SDT, 
                    Date ngayBatDauLV, LinkedList<NgayLamViec> ngayLamViec)
    {
    	//duyệt list, nếu đã tồn tại đơn vị: gán cho tenDonVi, thêm nhân viên vào đơn vị đó. 
        //Nếu không có, tạo 1 đơn vị mới, rồi thêm vào đơn vị đó
    	
        this.MSNV = MSNV;
        this.ho = ho;
        this.ten = ten;
        this.chucVu = chucVu;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.diaChi = diaChi;
        this.email = email;
        this.SDT = SDT;
        this.ngayBatDauLV = ngayBatDauLV;
        this.ngayLamViec = ngayLamViec;
        
        int i;
        int test = 0; //Kiểm tra xem có tồn tại đơn vị chưa.
        
        for (i=0;i<list.size();i++){
            
            if (list.get(i).getTenDonVi().equals(tenDonVi)){
                
                this.tenDonVi = list.get(i);                              
                list.get(i).themNhanVien(this);
                
                test = 1; //Nếu đã tồn tại thì đánh dấu.
                
            } 
        }
        if (test == 0){
                
                DonVi donVi = new DonVi(tenDonVi);
                list.add(donVi);
                this.tenDonVi = donVi;
                
                donVi.themNhanVien(this); 
        }
           
        soNhanVien++;    
                
        }
                 
       
    //Phương thức khởi tạo ít tham số, nhập từ bàn phím các dữ liệu
    public NhanVien(LinkedList<DonVi> list) throws ParseException
	{
		
		// Nhập dữ liệu từ bàn phím các thông tin: họ tên, ngày sinh, đơn vị, chức vụ, quê quán, địa chỉ, email,
		//số điên thoại, ngày bắt đầu làm việc
		//cấp mã số nhân viên tự động dựa theo soNhanVien hiện tại 
		//gọi đến phương thức khởi tạo phía trên
            
            String MSNV; 
            String ho; 
            String ten; 
            String tenDonVi; 
            String chucVu; 
            Date ngaySinh;
            String queQuan; 
            String diaChi; 
            String email; 
            String SDT; 
            Date ngayBatDauLV;
      
            Scanner input = new Scanner(System.in);
            
            MSNV = "NV" + soNhanVien;
            
            System.out.print("Ho: "); ho = input.nextLine();
            
            System.out.print("Ten: "); ten = input.nextLine();
            
            System.out.print("Don vi: "); tenDonVi = input.nextLine();
            
            System.out.print("Chuc vu: "); chucVu = input.nextLine();
            
            System.out.print("Ngay thang nam sinh: "); String s1 = input.nextLine();
            ngaySinh = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(s1).getTime());
            
            System.out.print("Que quan: "); queQuan = input.nextLine();
            
            System.out.print("Dia chi: "); diaChi = input.nextLine();
            
            System.out.print("Email: "); email = input.nextLine();
            
            System.out.print("SDT: "); SDT = input.nextLine();
            
            System.out.print("Ngay bat dau lam viec: "); String s2 = input.nextLine();
            ngayBatDauLV = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(s2).getTime());
            
            LinkedList<NgayLamViec> ngayLamViec = new LinkedList<>();
            
            NhanVien nv = new NhanVien(list, MSNV, ho, ten, tenDonVi, chucVu, ngaySinh, queQuan, diaChi, 
                     email, SDT, ngayBatDauLV, ngayLamViec);
            	
	}
    
    // Các phương thức getter và setter

    public String getMSNV() {
        return MSNV;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public DonVi getTenDonVi() {
        return tenDonVi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getSDT() {
        return SDT;
    }

    public Date getNgayBatDauLV() {
        return ngayBatDauLV;
    }

    public LinkedList<NgayLamViec> getNgayLamViec() {
        return ngayLamViec;
    }

    public static int getSoNhanVien() {
        return soNhanVien;
    }

    public void setMSNV(String MSNV) {
        this.MSNV = MSNV;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTenDonVi(DonVi tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setNgayBatDauLV(Date ngayBatDauLV) {
        this.ngayBatDauLV = ngayBatDauLV;
    }

    public void setNgayLamViec(LinkedList<NgayLamViec> ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public static void setSoNhanVien(int soNhanVien) {
        NhanVien.soNhanVien = soNhanVien;
    }
    
    
    public int soGioThieuHut(){
        //Giả sử ngày làm việc 8 tiếng từ 8:30 đến 17:30
        //đọc từng dòng của ngayLamViec -> tính số giờ thiếu hụt
        //Tính tổng 
        
        int i;
        float hours = 0;
        
        for (i=0;i<ngayLamViec.size();i++){            
            hours += ngayLamViec.get(i).thoiGian();                        
        }
        
        return (int) Math.ceil(hours);
                               
    }  
    
    public void toString(NhanVien nv){
       
        System.out.println("Ma so nhan vien: " + nv.getMSNV());
        System.out.println("Ho ten nhan vien: " + nv.getHo() + " " + nv.getTen());
        System.out.println("Don vi: " + nv.getTenDonVi().getTenDonVi());
        System.out.println("Chuc vu: " + nv.getChucVu());
        System.out.println("Ngay thang nam sinh: " + nv.getNgaySinh());
        System.out.println("Que quan: " + nv.getQueQuan());
        System.out.println("Dia chi: " + nv.getDiaChi());
        System.out.println("Email: " + nv.getEmail());
        System.out.println("SDT: " + nv.getSDT());
       
    }
    
    public boolean edit(int properties, LinkedList<DonVi> list) throws ParseException
    {
    	//properties là biến cờ các thuộc tính cần sửa:_HOTEN, _TENDONVI, _CHUCVU, _NGAYSINH, _QUEQUAN, _DIACHI, _EMAIL, _SDT
    	// (properties & _HOTEN) != 0 ----> cần sửa họ tên
    	// (properties & _TENDONVI) != 0 ----> cần sửa tên đơn vị 
    	//.......
  
    	//Dùng Scanner để nhập từ bàn phím dữ liệu thay thế
    	//Dùng phương thức khởi tạo nhiều tham số, tạo đối tượng nhân viên thay thế
    	//Xóa nhân viên này khỏi list của DonVi
    	//Sửa trong file
    	//Trả về true nếu sửa thành công, false nếu thất bại
        
        String MSNV;
        String ho;
        String ten;
        DonVi tenDonVi;
        String chucVu;
        Date ngaySinh;
        String queQuan;
        String diaChi;
        String email;
        String SDT;
        
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        
        if ((properties & _HOTEN) !=0 ){
                       
            System.out.print("Sua ho: ");
            ho = input.nextLine();
            
            System.out.print("Sua ten: ");
            ten = input.nextLine();
           
        }
        
        if ((properties & _TENDONVI) !=0 ){
                       
            System.out.print("Sua don vi: ");
            String dv = input.nextLine();
            tenDonVi = new DonVi(dv);
            
        }
        
        if ((properties & _CHUCVU) !=0 ){
                       
            System.out.print("Sua chuc vu: ");
            chucVu = input.nextLine();
           
        }
        
        if ((properties & _NGAYSINH) !=0 ){
                       
            System.out.print("Sua ngay sinh: ");
            String d = input.nextLine();
            ngaySinh = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(d).getTime());
                       
        }
        
        if ((properties & _QUEQUAN) !=0 ){
                       
            System.out.print("Sua que quan: ");
            queQuan = input.nextLine();
           
        }
        if ((properties & _DIACHI) !=0 ){
                       
            System.out.print("Sua dia chi: ");
            diaChi = input.nextLine();
           
        }
        
        if ((properties & _EMAIL) !=0 ){
                       
            System.out.print("Sua email: ");
            email = input.nextLine();
           
        }
        
        if ((properties & _SDT) !=0 ){
                       
            System.out.print("Sua SDT: ");
            SDT = input.nextLine();
           
        }
        
        //list.get(_SDT)
        
        

    }
    
}