import java.util.Date;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class DonVi {
    private LinkedList<NhanVien> list;
    private int soNV;
    private String tenDonVi;
    
    
    public DonVi(String tenDonVi) {
    	
    }
    
    // Các phương thức getter và setter
    public int getSoNV() {
		return soNV;
	}

	public void setSoNV(int soNV) {
		this.soNV = soNV;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}
    
    
    //Ngoài ra
    
    public String getTruongDonVi(){
    // Tìm kiếm trong list i = 1:soNV
    // Nếu list.get(i).chucVu = "Chu tich" or "Giam doc" or "Truong phong"
    // ==> Lấy
    }
    
    

	String getPhoDonVi(){
    //Tìm kiếm trong list
    // Nếu list.get(i).ChucVu = "Pho chu tich" or "Pho giam doc" or "Pho phong"
    // ==> Lấy
    }
    
    void themNhanVien(NhanVien nv){
        
    // list.add(nv);    

    // tăng số nhân viên lên 1
    
    }
    
    public xoaNhanVien(NhanVien nv)
    {
    	
    }
    
    public String toString() {
    	//chuyển các thông tin cơ bản của đơn vị thành xâu
    }
    
    
    public NhanVien[] timKiemTheoHoTen(String s){} 
    
    public NhanVien[] timKiemTheoChucVu(String s){} 
    
    public NhanVien[] timKiemTheoNgaySinh(Date d){}
    
    public NhanVien timKiemTheoMSNV(String s){}
    
}
