package cn.hnust;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class DBTest {

	public static void main(String[] args) {
		try {
			DBConnection b =new DBConnection();
			String sql = "insert into question(id, question, optA, optB, optC, optD, answer) values('t1','1919骞�,銆婃柊闈掑勾銆嬫潅蹇楀彂琛ㄣ�婃垜鐨勯┈鍏嬫�濅富涔夎銆嬩竴鏂�,绯荤粺鍦颁粙缁嶄簡椹厠鎬濅富涔夌殑鍞墿鍙茶銆佹斂娌荤粡娴庡鍜岀瀛︾ぞ浼氫富涔夌殑鍩烘湰鍘熺悊銆傝繖绡囨枃绔犵殑浣滆�呮槸____銆�','闄堢嫭绉�','鏉庡ぇ閽�','鏉庤揪','璧靛獩')";
			
			b.execute(sql);
			ResultSet rs = b.executeQuery("select * from question");
			
			ArrayList<Question> list = new ArrayList();
			while(rs.next()){
				String id = rs.getString(1);
				String question = rs.getString(2);
			    String optA = rs.getString(3);
				String optB = rs.getString(4);
				String optC = rs.getString(5);
				String optD = rs.getString(6);
				String answer = rs.getString(7);
				Question t = new Question(id, question, optA, optB, optC, optD, answer);
				list.add(t);
			}
			b.close();
			Random r = new Random();
			int j=0;
			int[] ques= {-1,-1,-1,-1};
			while(j<4) {
				int randnumber = r.nextInt(list.size());
				System.out.println(randnumber);
				//if not exist 
				ques[j] = randnumber;
				j++;
			}
			
			for(int k=0;k<4;k++) {
				Question s = list.get(k);
				System.out.println(s.getId());
				System.out.println(s.getQuestion());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
