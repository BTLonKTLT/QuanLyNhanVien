import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Date;
import java.util.Scanner;

public class NhanVien {
    
    private final String MSNV;
    private final String ho;
    private final String ten;
    private final DonVi tenDonVi;
    private final String chucVu;
    private final Date ngaySinh;
    private final String queQuan;
    private final String diaChi;
    private final String email;
    private final String SDT;
    private final Date ngayBatDauLV;
    private final LinkedList<NgayLamViec> ngayLamViec;
    
    private static int soNhanVien = 0;
    public static int  _HOTEN = 0b1, _TENDONVI = 0b10, _CHUCVU = 0b100, _NGAYSINH = 0b1000; 
    public static int  _QUEQUAN = 0b10000, _DIACHI = 0b100000, _EMAIL = 0b1000000, _SDT = 0b10000000; 
    
    
    //Phương thức khởi tạo nhiều tham số
    public NhanVien(String MSNV, String ho, String ten, String tenDonVi, 
                    String chucVu, Date ngaySinh, String queQuan, String diaChi, String email, String SDT, 
                    Date ngayBatDauLV, LinkedList<NgayLamViec> ngayLamViec)
    {
    	//duyệt list, nếu đã tồn tại đơn vị: gán cho tenDonVi, thêm nhân viên vào đơn vị đó. 
        //Nếu không có, tạo 1 đơn vị mới, rồi thêm vào đơn vị đó
    	
        DonVi dv = new DonVi(tenDonVi);
        
        this.MSNV = MSNV;
        this.ho = ho;
        this.ten = ten;
        this.tenDonVi = dv;
        this.chucVu = chucVu;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.diaChi = diaChi;
        this.email = email;
        this.SDT = SDT;
        this.ngayBatDauLV = ngayBatDauLV;
        this.ngayLamViec = ngayLamViec;
                
        soNhanVien++;    
                
        }
                 
       
    //Phương thức khởi tạo ít tham số, nhập từ bàn phím các dữ liệu
    public NhanVien() throws ParseException
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
      
            soNhanVien++;
            
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
            
            LinkedList<NgayLamViec> ngayLamViec = new LinkedList();
            
            DonVi dv = new DonVi(tenDonVi);
        
            this.MSNV = MSNV;
            this.ho = ho;
            this.ten = ten;
            this.tenDonVi = dv;
            this.chucVu = chucVu;
            this.ngaySinh = ngaySinh;
            this.queQuan = queQuan;
            this.diaChi = diaChi;
            this.email = email;
            this.SDT = SDT;
            this.ngayBatDauLV = ngayBatDauLV;
            this.ngayLamViec = ngayLamViec;
                                        	
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
    
    public int soGioThieuHut(){
        //Giả sử ngày làm việc 8 tiếng từ 8:30 đến 17:30
        //đọc từng dòng của ngayLamViec -> tính số giờ thiếu hụt
        //Tính tổng 
        
        int i;
        float hours = 0;
        
        for (i=0;i<ngayLamViec.size();i++){            
            hours += ngayLamViec.get(i).thoiGian();                        
        }
        
        return Math.abs((int) Math.ceil(hours));
                               
    }  
    
    //trả về xâu thông tin gồm thông tin làm việc trong tháng hiện tại và số giờ thiếu hụt
    public String thongTinLamViec(){
        String s = "";
        int i;
        
        for (i=0;i<ngayLamViec.size();i++)
            s += ngayLamViec.get(i).toString();
        
        s += "So gio thieu hut: " + soGioThieuHut() + " gio \n";
        
        return s;
    }
    
    @Override
    public String toString(){
        
        String s = "";
        s += "Ma so nhan vien: " + this.getMSNV() + "\n";
        s += "Ho ten nhan vien: " + this.getHo() + " " + this.getTen() + "\n";
        s += "Don vi: " + this.getTenDonVi().getTenDonVi() + "\n";
        s += "Chuc vu: " + this.getChucVu() + "\n";        
        String d;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        d = formatter.format(ngaySinh);
        s += "Ngay thang nam sinh: " + d + "\n";
        s += "Que quan: " + this.getQueQuan() + "\n";
        s += "Dia chi: " + this.getDiaChi() + "\n";
        s += "Email: " + this.getEmail() + "\n";
        s += "SDT: " + this.getSDT() + "\n";
        s += "---------------------\n";
        
        return s;
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
        
        
        String hoSua = nv.getHo();
        String tenSua = nv.getTen();
        String tenDonViSua = nv.getTenDonVi().getTenDonVi();
        String chucVuSua = nv.getChucVu();
        Date ngaySinhSua = nv.getNgaySinh();
        String queQuanSua = nv.getQueQuan();
        String diaChiSua = nv.getDiaChi();
        String emailSua = nv.getEmail();
        String SDTSua = nv.getSDT();
        
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
        NhanVien nvsua = new NhanVien(nv.MSNV, hoSua, tenSua, tenDonViSua, chucVuSua, ngaySinhSua,
                                      queQuanSua, diaChiSua, emailSua, SDTSua, nv.ngayBatDauLV, nv.ngayLamViec);
 
        //Xoá nhân viên cũ trong file
        
        ArrayList<String> lines = new ArrayList();
        String line1, line2;
        
        try{
            File f = new File("ThongTinNhanVien.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            while((line1 = br.readLine()) != null){
                if (line1.contains(nv.getMSNV())){
                    line1 = line1.replace(line1, "");
                    lines.add(line1);  
                    while((line2 = br.readLine()) != null && line2.substring(0,2).compareTo("NV")!=0){                       
                            line2 = line2.replace(line2, "");
                            lines.add(line2);
                        }
                    if (line2 != null && line2.substring(0,2).compareTo("NV")==0)
                        lines.add(line2);
                    }
                lines.add(line1);
                }
                       
            fr.close();
            br.close();
        }
        catch(IOException ex){
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
        catch(IOException ex){
            flag = false;
        }
        
        //Xoá nhân viên cũ trong DonVi
        int i;
        for (i=0;i<list.size();i++)
            if (list.get(i).getTenDonVi().equals(nv.tenDonVi.getTenDonVi()))
                list.get(i).xoaNhanVien(nv);
        
        //Thêm nhân viên mới vào DonVi
        for (i=0;i<list.size();i++)
            if (list.get(i).getTenDonVi().equals(nvsua.tenDonVi.getTenDonVi()))
                list.get(i).themNhanVien(nvsua);
        
        //Sửa trong file (Thêm nhân viên mới vào file)
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm");
        
        try{
            File f = new File("ThongTinNhanVien.txt");
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter out = new BufferedWriter(fw);
            
            out.write(nvsua.MSNV); out.newLine();                      
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

            for (i=0;i<nv.ngayLamViec.size();i++){
                String s = "";
                s += formatter1.format(nv.ngayLamViec.get(i).getNgay()) + ", ";
                s += formatter2.format(nv.ngayLamViec.get(i).getThoiGianDen()) + ", ";
                s += formatter2.format(nv.ngayLamViec.get(i).getThoiGianVe());
                
                out.write(s); out.newLine();                              
            }                       
            out.flush();
            out.close();
        }
        catch (IOException e){
            flag = false;
        }        
                   
        //Trả về kết quả đã kiểm tra được chưa
        return flag;
    
    }
    
}