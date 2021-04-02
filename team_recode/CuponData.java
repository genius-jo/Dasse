/* **********************************************
 * 프로그램명 : CuponData.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.05.25
 *프로그램 설명 : 쿠폰 데이터를 저장하는 클래스
 ************************************************/
package com.example.dasse;

//Cupon의 정보를 저장하기 위한 클래스

public class CuponData {
    String storeName;         //이름 저장
    String cuponName;          //쿠폰이름 저장
    int imgId;                //상품 이미지의 리소스 아이디

    public CuponData(String storeName, String cuponName,  int imgId) {
        // TODO Auto-generated constructor stub
        //생성자함수로 전달받은 Cupon의 정보를 멤버변수에 저장.
        this.storeName = storeName;
        this.cuponName = cuponName;
        this.imgId = imgId;
    }

    //getter , setter 메소드
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setCuponName(String menuName) {
        this.cuponName = menuName;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getCuponName() {
        return cuponName;
    }

    public int getImgId() {
        return imgId;
    }
}
