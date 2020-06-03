/* **********************************************
 * 프로그램명 : MemberData.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.05.20
 *프로그램 설명 : 가게 데이터를 저장하는 클래스
 ************************************************/
package com.example.dasse;

//Member의 정보를 저장하기 위한 클래스.

public class MemberData {
    String storeName;         //가게이름 저장
    String menuName;          //메뉴이름 저장
    String oldPrice;          //이전가격 저장
    String discountPrice;     //할인가격 저장
    String foodInfo;          //상품정보 저장
    String storeLocation;     //상점위치 저장
    int imgId;                //상품 이미지의 리소스 아이디

    public MemberData(String storeName, String menuName, String oldPrice, String discountPrice, String foodInfo, String storeLocation, int imgId) {
        // TODO Auto-generated constructor stub
        this.storeName = storeName;
        this.menuName = menuName;
        this.oldPrice = oldPrice;
        this.discountPrice = discountPrice;
        this.foodInfo = foodInfo;
        this.storeLocation = storeLocation;
        this.imgId = imgId;
    }

    //getter , setter
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

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

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

    public int getImgId() {
        return imgId;
    }

}