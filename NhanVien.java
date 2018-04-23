import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
                
                //Thêm nhân viên vào đơn vị
                this.tenDonVi = list.get(i);                              
                list.get(i).themNhanVien(this);
                
                test = 1; //Nếu đã tồn tại thì đánh dấu.
                
            } 
        }
        if (test == 0){
                
                DonVi donVi = new DonVi(tenDonVi);
                list.add(donVi);
                this.tenDonVi = donVi;
                
                //Thêm nhân viên và đơn vị
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
    
    public boolean edit(NhanVien nv, int properties, LinkedList<DonVi> list) throws ParseException
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
        
        
        String hoSua = null;
        String tenSua = null;
        String tenDonViSua = null;
        String chucVuSua = null;
        Date ngaySinhSua = null;
        String queQuanSua = null;
        String diaChiSua = null;
        String emailSua = null;
        String SDTSua = null;
        
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        
        //Kiểm tra xem cần sửa thành phần nào
        
        if ((properties & _HOTEN) !=0 ){
                       
            System.out.print("Sua ho thanh: ");
            hoSua = input.nextLine();
            
            System.out.print("Sua ten thanh: ");
            tenSua = input.nextLine();
           
        }
        
        if ((properties & _TENDONVI) !=0 ){
                       
            System.out.print("Sua don vi thanh: ");
            tenDonViSua = input.nextLine();
            
        }
        
        if ((properties & _CHUCVU) !=0 ){
                       
            System.out.print("Sua chuc vu thanh: ");
            chucVuSua = input.nextLine();
           
        }
        
        if ((properties & _NGAYSINH) !=0 ){
                       
            System.out.print("Sua ngay sinh thanh: ");
            String d = input.nextLine();
            ngaySinhSua = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(d).getTime());
                       
        }
        
        if ((properties & _QUEQUAN) !=0 ){
                       
            System.out.print("Sua que quan thanh: ");
            queQuanSua = input.nextLine();
           
        }
        if ((properties & _DIACHI) !=0 ){
                       
            System.out.print("Sua dia chi thanh: ");
            diaChiSua = input.nextLine();
           
        }
        
        if ((properties & _EMAIL) !=0 ){
                       
            System.out.print("Sua email thanh: ");
            emailSua = input.nextLine();
           
        }
        
        if ((properties & _SDT) !=0 ){
                       
            System.out.print("Sua SDT thanh: ");
            SDTSua = input.nextLine();
           
        }
        
        //Tạo nhân viên mới
        NhanVien nvsua = new NhanVien(list, nv.MSNV, hoSua, tenSua, tenDonViSua, chucVuSua, ngaySinhSua,
                                      queQuanSua, diaChiSua, emailSua, SDTSua, nv.ngayBatDauLV, nv.ngayLamViec);
 
        //Sửa trong file (Thêm nhân viên mới vào file)
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm");
        
        try{
            File f = new File("ThongTinNhanVien.txt");
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter out = new BufferedWriter(fw);
            
            out.write(nv.MSNV); out.newLine();                      
            out.write(hoSua); out.newLine();            
            out.write(tenSua); out.newLine();           
            out.write(tenDonViSua); out.newLine();         
            out.write(chucVuSua); out.newLine();                                   
            out.write(formatter1.format(ngaySinhSua)); out.newLine();          
            out.write(queQuanSua); out.newLine();           
            out.write(diaChiSua); out.newLine();            
            out.write(emailSua); out.newLine();            
            out.write(SDTSua); out.newLine();           
            out.write(formatter1.format(nv.ngayBatDauLV)); out.newLine();
            
            int i;
            for (i=0;i<nv.ngayLamViec.size();i++){
                String s = "";
                s += formatter1.format(nv.ngayLamViec.get(i).getNgay()) + ", ";
                s += formatter2.format(nv.ngayLamViec.get(i).getThoiGianDen()) + ", ";
                s += formatter2.format(nv.ngayLamViec.get(i).getThoiGianVe());
                
                out.write(s); out.newLine();                              
            }                       
        }
        catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
                      
        //Xoá nhân viên cũ trong file
        
        ArrayList<String> lines = new ArrayList();
        String line = null;
        
        try{
            File f = new File("ThongTinNhanVien.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            while((line = br.readLine()) != null){
                if (line.contains(nv.MSNV)){
                    line = line.replace(nv.MSNV, "");
                    lines.add(line);
                    
                    int count = 30;
                    while (count>1){
                        line = br.readLine();
                        String s = line;
                        line = line.replace(s, "");
                        lines.add(line);    
                        count--;
                    }         
                }
                lines.add(line);
                }
            fr.close();
            br.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
            flag = false;
        }
                    
                
        try{
            File f = new File("ThongTinNhanVien.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter out = new BufferedWriter(fw);
            
            int i;
            for(i=0;i<lines.size();i++){
                out.write(lines.get(i));
                if (!lines.get(i).equals("")) out.newLine();            
            }
            
            out.flush();
            out.close();
        }        
        catch(Exception ex){
            ex.printStackTrace();
            flag = false;
        }
        
        //Xoá nhân viên cũ trong DonVi
        int i;
        for (i=0;i<list.size();i++)
            if (list.get(i).getTenDonVi().equals(nv.tenDonVi.getTenDonVi()))
                list.get(i).xoaNhanVien(nv);
                   
        //Trả về kết quả đã kiểm tra được chưa
        return flag;
    
    }
    
}