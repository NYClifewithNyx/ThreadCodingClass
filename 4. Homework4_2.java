import java.util.ArrayList; //ArrayList 사용하겠다고 넣어줌
import java.util.List;
import java.util.Scanner; //Scanner 사용하겠다고 넣어줌
import java.util.Collections; //Max 찾으려고 넣었는데 음...

public class Main { //모든 메써드는 클래스 안에 있어야한다
    public static void main(String[] args) { //여기서 코드가 실행

        Scanner sc = new Scanner(System.in);
        int choice;
        String studentName; //학생 이름
        int studentScore;  //학생 점수
        String studentGrade = ""; //학생 등급
        int studentIDNo; //학생 학번
        String yn;

        ArrayList<String> studentNameList = new ArrayList<>();
        ArrayList<Integer> studentScoreList = new ArrayList<>();
        ArrayList<String> studentGradeList = new ArrayList<>();
        ArrayList<Integer> studentIDNoList = new ArrayList<>();

        while (true) {
            System.out.println("\n==================================================");
            System.out.println("===========\uD83D\uDC69\u200D\uD83C\uDF93고등학생 성적 관리 프로그램\uD83D\uDD70\uFE0F===========");
            System.out.println("==================================================\n");
            System.out.println("1. 학생 등록");
            System.out.println("2. 학생 목록 조회");
            System.out.println("3. 성적 및 평균 계산");
            System.out.println("4. 등급 조회");
            System.out.println("5. 최고 점수 조회");
            System.out.println("6. 종료");
            System.out.println("\n---------------------------------------------------");
            System.out.println("메뉴를 선택하세요:");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: //1. 학생 등록
                    while (true) {
                        System.out.println("\n[1. 학생 등록]");
                        System.out.print("이름을 입력하세요 : ");
                        studentName = sc.nextLine();

                        System.out.print("성적을 입력하세요 (0 ~ 100) : "); //점수를 0과 ~ 100 사이로 제한해야함
                        while (true) {
                                studentScore = sc.nextInt();
                                sc.nextLine();
                                if (studentScore > 100 || studentScore < 0) {
                                    System.out.println("\n점수가 0점 밑이거나 100점을 넘을 수 없습니다");
                                    System.out.println("다시 입력해 주십시오");
                                }
                                else {
                                    if (studentScore >= 0 && studentScore < 60) {
                                        studentGrade = "F";
                                    }
                                    else if (studentScore >= 60 && studentScore < 70) {
                                        studentGrade = "D";
                                    }
                                    else if (studentScore >= 70 && studentScore < 80) {
                                        studentGrade = "C";
                                    }
                                    else if (studentScore >= 80 && studentScore < 90) {
                                        studentGrade = "B";
                                    }
                                    else if (studentScore >= 90 && studentScore < 95) {
                                        studentGrade = "A";
                                    }
                                    else if (studentScore >= 95 && studentScore <= 100) {
                                        studentGrade = "S";
                                    }
                                    break;
                                }
                            }

                        System.out.println("\n아래 학생을 등록합니까?");
                        System.out.println("이름: " + studentName + " / " + "점수: " + studentScore);

                        System.out.println("\n1. 네 / 2. 아니오 (1. Y / 2. N)");
                        yn = sc.nextLine();

                        if (yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes") || yn.equals("네") || yn.equals("1")) {
                            studentNameList.add(studentName);
                            studentScoreList.add(studentScore);
                            studentGradeList.add(studentGrade);
                            studentIDNoList.add(studentNameList.size());
                            System.out.println("\n등록 되었습니다");
                            System.out.println("학생 번호는 " + studentNameList.size() + "번 입니다"); //이걸 .size로 할지 다시 좀 더 고민
                        } else {
                            System.out.println("등록을 취소했습니다\n");
                            System.out.println("계속 등록하시겠습니까?\n");
                            System.out.println("1. 네 / 2. 아니오 (1. Y / 2. N)");
                            yn = sc.nextLine();

                            if (yn.equalsIgnoreCase("N") || yn.equals("2") || yn.equals("아니오") || yn.equalsIgnoreCase("no")) {
                                break;
                            }
                        }
                        System.out.println("\n계속 등록하시겠습니까?");
                        System.out.println("1. 네 / 2. 아니오 (1. Y / 2. N)");
                        yn = sc.nextLine();

                        if (yn.equalsIgnoreCase("N") || yn.equals("2") || yn.equals("아니오") || yn.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                    break;

                case 2://2. 학생 목록 조회
                    System.out.println("\n[2. 학생 목록 조회]");
                    System.out.println("지금까지 등록된 학생 목록을 불러옵니다.\n");
                    studentIDNo = studentNameList.size();

                    if (studentIDNo == 0) {
                        System.out.println("아직 등록된 학생이 없습니다");
                        //여기선 try catch가 먹히지 않고 그냥 리스트가 나오지 않음. 에러가 아니라서 그런듯

                    } else {

                        for (int i = 0; i < studentIDNo; i++) {
                            System.out.println("ID 번호 : " + studentIDNoList.get(i));
                            System.out.println("학생 이름 : " + studentNameList.get(i));
                            System.out.println("학생 점수 : " + studentScoreList.get(i) + "\n");
                        }
                    }

                    System.out.print("\n메뉴로 돌아갑니다. 엔터를 누르세요");
                    yn = sc.nextLine();
                    break;

                case 3://3. 성적 및 평균 계산
                    System.out.println("\n[3. 성적 및 평균 계산]");
                    System.out.println("지금까지 등록된 학생들의 총 점수 합과 평균을 냅니다.\n");
                    studentIDNo = studentScoreList.size();
                    int sum = 0;
                    int average = 0; //double로 하려고 했다가 별로 의미가 없는 것 같아서

                    /*if (studentIDNo == 0) {
                        System.out.println("아직 등록된 학생이 없습니다. 학생들을 먼저 등록해주세요");
                    } else {*/

                        try {
                        System.out.println("등록된 학생의 수 : " + studentIDNo);
                        System.out.print("등록된 성적들 : ");

                        for (int i = 0; i < studentIDNo; i++) {
                            System.out.print(studentScoreList.get(i) + " / "); //어떻게 해서든 " / "를 학생 수보다 1개 적게 돌리려고 했는데 잘 안됨
                            sum += studentScoreList.get(i);
                        }

                        System.out.println("\n성적의 총 합 : " + sum);
                        average = divide(sum, studentIDNo);
                        System.out.println("전체 성적 평균 : " +  average);

                        int askii;
                        askii = divide(average, 10);

                        System.out.print("[");
                        for (int i = 1; i <= askii; i++) {
                            System.out.print("*");
                        }
                        for (askii = askii; askii < 10; askii++) {
                            System.out.print("-");
                        }
                        System.out.println("]");

                        } catch (Exception e) {
                        System.out.println("\n학생을 등록한 후 시도해주세요. 에러 코드: " + e.getMessage());
                        //학생이 없어서 0으로 나눔으로 에러코드 나는 것 유일하게 시도. if/else가 더 깔끔하긴 함
                        }

                    System.out.print("\n메뉴로 돌아갑니다. 엔터를 누르세요");
                    yn = sc.nextLine();
                    break;

                case 4://4. 등급 조회
                    System.out.println("\n[4. 등급 조회]");
                    System.out.println("지금까지 등록된 학생들의 점수 등급을 보여줍니다.\n");
                    /*for (String j : studentGradeList) {
                        System.out.print(j);
                    }*/
                    studentIDNo = studentIDNoList.size();
                    if (studentIDNo == 0) {
                        System.out.println("아직 등록된 학생이 없습니다.");

                    } else {

                        for (int i = 0; i < studentIDNo; i++) {
                            System.out.println(studentIDNoList.get(i) + ". " + studentNameList.get(i) + " (" + studentScoreList.get(i) + "점)" + " → " + studentGradeList.get(i));
                        }
                    }
                    System.out.print("\n메뉴로 돌아갑니다. 엔터를 누르세요");
                    yn = sc.nextLine();
                    break;
                    
                case 5: //5. 최고 점수 조회
                    System.out.println("\n[5. 최고 점수 조회]");
                    System.out.println("지금까지 등록된 학생들 중 최고 점수를 보여줍니다.\n");

                    try {
                        int max = Collections.max(studentScoreList);
                        int index = studentScoreList.indexOf(max);
                        System.out.println(studentIDNoList.get(index) + ". " + studentNameList.get(index) + " (" + studentScoreList.get(index) + "점)" + " → " + studentGradeList.get(index));
                    }
                    catch (Exception e) {
                    System.out.println("\n학생을 등록한 후 시도해주세요. 에러 코드: " + e.getMessage());
                    }

                    System.out.println("\n메뉴로 돌아갑니다. 엔터를 누르세요");
                    yn = sc.nextLine();
                    break;

                case 6: //종료
                    question();
                    yn = sc.nextLine();

                    if (yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes") || yn.equals("네") || yn.equals("1")) {
                        System.out.println("\n프로그램을 종료합니다");
                        System.exit(0);
                    }
                    break;

            }
        }
    }

    public static int divide(int number1, int number2) {
        int result = number1 / number2;
        return result;
    }

    public static void question () {
        System.out.println("\n프로그램을 종료하시겠습니까?");
        System.out.println("1. 네 / 2. 아니오 (1. Y / 2. N)");
    }

}
