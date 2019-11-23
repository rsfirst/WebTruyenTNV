
package model;


public class Product{
    private long productID;
    private long categoryID;
    private String productName;
    private String productImage;
    private double productPrice;
    private String productDescription;
    private String sdt;
    private double dientich;
    private String hoten;
    private String vitri;
    private String ngaydang;
    private String hinhthuc;
    
    public Product()
    {
    }

    public Product(long productID, long categoryID, String productName, String productImage, double productPrice, String productDescription, String sdt, double dientich, String hoten, String vitri) 
    {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.sdt = sdt;
        this.dientich = dientich;
        this.hoten = hoten;
        this.vitri = vitri;
    }

    public Product(long productID, long categoryID, String productName, String productImage, double productPrice, String productDescription, String sdt, double dientich, String hoten, String vitri, String ngaydang) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.sdt = sdt;
        this.dientich = dientich;
        this.hoten = hoten;
        this.vitri = vitri;
        this.ngaydang = ngaydang;
    }

    public Product(long productID, long categoryID, String productName, String productImage, double productPrice, String productDescription, String sdt, double dientich, String hoten, String vitri, String ngaydang, String hinhthuc) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.sdt = sdt;
        this.dientich = dientich;
        this.hoten = hoten;
        this.vitri = vitri;
        this.ngaydang = ngaydang;
        this.hinhthuc = hinhthuc;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }
    
    public String getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(String ngaydang) {
        this.ngaydang = ngaydang;
    }
    
    
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public double getDientich() {
        return dientich;
    }

    public void setDientich(double dientich) {
        this.dientich = dientich;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }
    
    
    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    

}
