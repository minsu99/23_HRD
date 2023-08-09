package my.day05.exam11;

import static java.lang.System.out;

import java.util.Scanner;
public class SchoolApp {

	// Person 사람 객체를 담는 1차원 배열 30개 선언
    Person persons[] = new Person[30];
    int count;


    /**
     * 메인 메뉴를 보여주는 메소드*
     */
    public void mainMenu() {
        out.println("---------------Main Menu--------------");
        out.println("|1. 등록  2. 검색 3. 삭제 4.출력 5. 종료|");
        out.println("--------------------------------------");
        out.println("번호를 입력하세요=>");
        out.println("--------------------------------------");
    }//----------

    public void subMenu() {
        out.println("---------------Sub Menu--------------");
        out.println("| 1.학생  2. 강사 3. 직원 4. 상위메뉴  |");
        out.println("--------------------------------------");
        out.println("번호를 입력하세요=>");
        out.println("--------------------------------------");
    }

    public void register() {
        //서브 메뉴 출력...케이스 별로 로직 수행
        Scanner sc = new Scanner(System.in);
        outer:

        while (true) {
            subMenu();
            int no = 0;
            no = sc.nextInt();
            switch (no) {
                case 1: //학생
                    Student st = new Student();
                    st.inputInfo();//학생정보를 입력받음.
                    addPerson(st);//등록된 객체를 배열에 저장한다.
                    break;
                case 2: //교사
                    Teacher tc = new Teacher();
                    tc.inputInfo();
                    addPerson(tc);
                    break;
                case 3: //직원
                    Staff sf = new Staff();
                    sf.inputInfo();
                    addPerson(sf);
                    break;
                case 4://상위 메뉴
                    break outer; //레이블 지정된 반복문을 이탈

                default:
                    out.println("지원되지 않는 메뉴번호입니다.");
            }
        }//while----
    }//register()------------------

    public void addPerson(Person p) {
        if (count < persons.length) {
            persons[count++] = p;
        } else {
            out.println("30명 정원 초과 되었어요!");
        }
    }

    /**
     * 배열에 저장된 사람의 모든 정보 출력
     */
    public String printAll() {
        String str = "";
        for (int i = 0; i < count; i++) {
            if (persons[i] instanceof Student) {
                str += "\n---학생정보---\n";
            } else if (persons[i] instanceof Teacher) {
                str += "\n---교사정보---\n";
            } else {
                str += "\n---직원정보---\n";
            }
            str += persons[i].personInfo();
        }
        out.println(str);
        return str;
    }//printAll()-------


    /**이름으로 등록된 사람 검색하는 메소드*/
    public String findPerson(String name){
        for(int i=0;i<count;i++){
            String pname=persons[i].getName();
            //배열에 저장된 사람의 이름을 꺼내온다.
            if(name.equals(pname)){
                //검색하는 사람의 이름과 동일하다면...
                persons[i].printAll();//그 사람 정보 출력
                return persons[i].personInfo();
                //awt와 연계하기 위해 문자열로 정보를 반환
            }//if--
        }//for----------
        out.println(name+"이란 사람 없어요!");
        return name+"이란 사람 없어요";

    }//findPerson()---------------


    /**이름으로 삭제하는 메소드*/
    public String removePerson(String name){
        for(int i=0;i<count;i++){
            String pname=persons[i].getName();
            if(name.equals(pname)){
                for(int j = i; j<count; j++){
                    persons[j]=persons[j+1];
                }
                count--;
                out.println(name+"님 정보가 삭제됐어요!");
                return name+"님 정보 삭제";
            }//if-------
        }//for---
        out.println(name+"님은 없어요!");
        return name+"님 없어요!";

    }//removePerson()-------------


    public static void main(String[] args) {

        SchoolApp schoolApp = new SchoolApp();
        Scanner sc = new Scanner(System.in);
        while (true) {

            schoolApp.mainMenu();
            //메뉴 번호 입력
            int no = 0;
            no = sc.nextInt();

            switch(no){
                case 1://등록
                    schoolApp.register();
                    break;
                case 2://검색
                    out.println("검색할 사람 이름=>");
                    String name=sc.next();
                    out.println("--"+name+"님을 검색합니다.--");
                    schoolApp.findPerson(name);
                    break;
                case 3://삭제
                    out.println("삭제할 사람 이름=>");
                    name=sc.next();
                    schoolApp.removePerson(name);
                    break;
                case 4://출력
                    schoolApp.printAll();
                    break;
                case 5://종료
                    out.println("Bye Bye~~");
                    System.exit(0);
                    break;
                default:
                    out.println("지원되지 않는 메뉴번호입니다.");

            }//switch----

        }
    }
}