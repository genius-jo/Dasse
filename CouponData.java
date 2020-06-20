package com.example.dasse;
/*************************************************
 * 프로그램명 : CouponData.java
 * 작성자 : 2016039077 전현성 2016039066 조광식
 * 작성일 : 2020.05.28
 * 프로그램설명 : 쿠폰 정보들의 객체 생성
 *************************************************/

/*********************************************  2016039077 전현성 2016039066 조광식 ***********************************************/


public class CouponData {

    private String imgId;                //이미지
    private String storeLocation;     //상점위치 저장
    private String foodInfo;          //상품정보 저장
    private String oldPrice;          //이전가격 저장
    private String discountPrice;     //할인가격 저장
    private String menuName;          //메뉴이름 저장
    private String storeName;         //가게이름 저장


    public CouponData(){

    }

    public CouponData(String imgId, String storeLocation, String foodInfo, String oldPrice, String discountPrice, String menuName, String storeName) {
        // TODO Auto-generated constructor stub
        //생성자함수로 전달받은 Member의 정보를 멤버변수에 저장
        this.storeName = storeName;
        this.menuName = menuName;
        this.oldPrice = oldPrice;
        this.discountPrice = discountPrice;
        this.foodInfo = foodInfo;
        this.storeLocation = storeLocation;
        this.imgId = imgId;

    }

    // get, set 함수 구현


    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setFoodInfo(String foodInfo) {
        this.foodInfo = foodInfo;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public void setImgId(String imgId) { this.imgId = imgId; }

    public String getStoreName() {
        return storeName;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public String getFoodInfo() {
        return foodInfo;
    }

    public String getStoreLocation() { return storeLocation; }

    public int getImgId() {return Integer.parseInt(imgId);}

}

/*********************************************  2016039077 전현성 2016039066 조광식 ***********************************************/