# PosApp
## 자바 swing gui를 이용하여 Pos 구현
-------
## 프로젝트 계획
> PosApp은 미용실에서 사용할 수 있는 포스기의 기본적인 기능을 구현하였습니다. 직원이 가게를 운영하면서 편의성을 제공합니다.
> 회원관리 , 접수, 예약, 매출 관리 등을 데이터베이스를 통해 저장 및 조회 할 수 있습니다.
--------
## 구현 기능
> #### 로그인
>> 관리자 계정에 맞는 아이디와 비밀번호 입력시에만 접속하도록 구상
> #### 접수
>> 전화번호 뒷자리로 해당 회원을 조회
>> 조회된 회원을 더블클릭 시 주문 화면으로 전환
>> 메뉴를 선택할때마다 테이블에 자동으로 금액과 메뉴명을 추가
>> 테이블에 추가 된 메뉴의 합계를 출력
>> 받은돈입력 시 거스름돈을 계산
> #### 예약
>> 담당자와 예약자의 이름을 입력한 후 콤보박스에서 시간을 설정하여 등록 버튼을 누르면 해당하는 담당자의 시간에 예약자의 이름이 입력되도록 구현
>> 테이블에 담당자의 이름이 존재하지 않을 경우 새로운 행을 추가
>> 테이블에 담당자의 이름이 존재할 경우 해당 행에 예약 시간에 해당하는 위치에 예약자의 이름이 입력
> #### 회원등록
>> 회원의 정보를 등록하는 화면 구현
> #### 매출
>> 매출 조회 버튼 클릭시 금일 회원들의 이용목록과 금액 출력
>> 금일 매출의 총 합계를 출력
-------------------------
