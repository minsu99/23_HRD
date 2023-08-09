package my.day05.exam6;

import java.util.ArrayList;

public class GameCharacterTest {

	public static void main(String[] args) {
		Wizard w = new Wizard();
		
		w.name = "간달프";
		w.hp = 999;
		w.mp = 500;
		w.punch();
		w.fireball();
		
		Knight k = new Knight();
		k.name = "나이트";
		k.hp = 900;
		k.stamina = 500;
		k.punch();
		k.slash();
		
		Helper h = new Helper();
		h.name = "djdjdj";
		h.hp = 2;
		h.hpp = 900000;
		h.punch();
		h.RIP();
		
		
		ArrayList<Novice> gamelist = new ArrayList<Novice>();
		// 다형성 (매우중요)
		gamelist.add(k);
		gamelist.add(new Novice());
		gamelist.add(w);
		
		// 내부적으로 반복자객체 
		// 강제형변환
		for(Novice n : gamelist) {
			n.punch();
			if (n instanceof Knight) {
				((Knight) n).slash();
			}else if(n instanceof Wizard) {
				((Wizard)n).fireball();
			}
			
			
		}
	}

}
class Novice {
	String name;
	int hp;
	
	void punch() {
		
		System.out.printf("%s (HP: %d)의 펀치 \n", name, hp);
	}
}

class Wizard extends Novice {
	
	int mp;
	
	void fireball() {
		super.punch();
		  
		System.out.printf("%s (HP: %d)의 파이어볼  \n", name, mp);
	}
}

class Knight extends Novice{
	
	int stamina;
	
	void slash() {
		super.punch();
		System.out.printf("%s (HP: %d)의 스킬공격  \n", name, stamina);
	}
	
}

class Helper extends Novice{
	int hpp;
	
	void RIP() {
		System.out.printf("%s (HP: %d)의 생명구원  \n", name, hpp);
	}
}
