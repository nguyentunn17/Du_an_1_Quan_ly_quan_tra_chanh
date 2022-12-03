package domainmodels;

public class DanhMuc {
//Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
//	IdTL UNIQUEIDENTIFIER,
//	MaDM VARCHAR(30) UNIQUE,
//	TenDM NVARCHAR(50) DEFAULT NULL,
//	TrangThai INT DEFAULT 0

    private String id;
    private String idTL;
    private String maDM;
    private String tenDM;
    private Integer trangThai;

    public DanhMuc(String id, String idTL, String maDM, String tenDM, Integer trangThai) {
        this.id = id;
        this.idTL = idTL;
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.trangThai = trangThai;
    }

    public DanhMuc() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTL() {
        return idTL;
    }

    public void setIdTL(String idTL) {
        this.idTL = idTL;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
