package my.day07.exam01;

import java.awt.Menu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu extends AbstractMenu {
    Scanner scan = new Scanner(System.in);

    public Menu next() {
        switch (scan.nextLine()) {
            case "1":
                createMovie();
                return this;
            case "2":
                printAllMovie();
                return this;
            case "b":
                return prevMenu;
        }
        return this; // 기본적으로 현재 메뉴로 유지
    }

    private void createMovie() throws IOException {
        System.out.print("영화 제목: ");
        String title = scan.nextLine();
        System.out.print("장르: ");
        String genre = scan.nextLine();

        Movie movie = new Movie(title, genre);

        try {
            movie.save();
            System.out.println("영화가 추가되었습니다.");
        } catch (IOException e) {
            System.out.println("영화 추가 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    private void printAllMovie() {
        try {
            ArrayList<Movie> movies = Movie.findAll();
            System.out.println("----- 영화 목록 -----");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
            System.out.println("---------------------");
        } catch (IOException e) {
            System.out.println("영화 목록을 불러오는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
