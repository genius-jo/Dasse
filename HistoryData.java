package com.example.dasse;

/*************************************************
 * 프로그램명 : HistoryData.java
 * 작성자 : 2016039077 전현성 2016039066 조광식
 * 작성일 : 2020.06.06
 * 프로그램설명 : 사용된 쿠폰 정보들의 객체 생성
 *************************************************/

/*********************************************  2016039077 전현성 2016039066조광식 ***********************************************/


public class HistoryData {

    private String imgId;                //이미지
    private String storeLocation;     //상점위치 저장
    private String foodInfo;          //상품정보 저장
    private String oldPrice;          //이전가격 저장
    private String discountPrice;     //할인가격 저장
    private String menuName;          //메뉴이름 저장
    private String storeName;         //가게이름 저장
    private String usedTime;          //이용시간 저장


    public HistoryData(){

    }

    public HistoryData(String imgId, String storeLocation, String foodInfo, String oldPrice, String discountPrice, String menuName, String storeName, String usedTime) {
        // TODO Auto-generated constructor stub
        // 생성자
        this.storeName = storeName;
        this.menuName = menuName;
        this.oldPrice = oldPrice;
        this.discountPrice = discountPrice;
        this.foodInfo = foodInfo;
        this.storeLocation = storeLocation;
        this.imgId = imgId;
        this.usedTime = usedTime;

    }

    //get, set 구현

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

    public void setUsedTime(String usedTime) {
        this.usedTime = usedTime;
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

    public String getUsedTime() { return usedTime; }

    public int getImgId() {return Integer.parseInt(imgId);}

}

/*********************************************  2016039077 전현성 2016039066조광식 ***********************************************/