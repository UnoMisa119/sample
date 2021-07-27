import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 */

/**
 * @author ekusi
 *
 */
public class ffff {

	public static Connection connect() throws SQLException,
	InstantiationException {

	                Connection cnx = null;
	                String url,username = null,password = null;


	                url = "jdbc:mysql://localhost:3306/item";
	                username = "root";
	                password = "";

	                try{
	         Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	                 cnx =DriverManager.getConnection(url, username, password);
	                 //System.out.println("connected");
	                }
	                catch (ClassNotFoundException e) {
	                e.printStackTrace();

	        } catch (IllegalAccessException e) {
	                        // TODO 自動生成された catch ブロック
	                        e.printStackTrace();
	                }

	                return cnx;
	        }


	        public static void FetchData() throws Exception{
	                Connection cnx = connect();
	                String sql = "select*from shouhin;";

	                try {
	                java.sql.Statement st= cnx.createStatement();
	                ResultSet rs = st.executeQuery(sql);

	                while(rs.next()){
	                	System.out.println("商品番号 = " + rs.getInt(1) + "\t" + " " + "商品名 = " + rs.getString(2) + "\n" + "在庫数 = "
	    						+ rs.getInt(4) + "個" + "\t" + " " + "価格 = " + rs.getInt(3) + "円" + "\n" +"売り上げ"+rs.getInt(5)+"円");

	                }
	                }catch (SQLException e) {

	                        e.printStackTrace();
	                }
	        }

	        public static void zaiko(int ItemI) throws Exception {

				Vector vec = new Vector();
	                        Connection cnx = connect();
	                        cnx.setAutoCommit(false);
		                String sql;
				ResultSet rs;
				PreparedStatement st = null;

		          try {

				sql = "select*from shouhin;";
		                st= cnx.prepareStatement(sql);
		                rs = st.executeQuery(sql);

				int aaa = 0;
		                while(rs.next()){

					vec.add(rs.getInt(1)) ;
					aaa++;
					vec.add(rs.getString(2)) ;
					aaa++;
					vec.add(rs.getInt(3)) ;
					aaa++;
					vec.add(rs.getInt(4)) ;
					aaa++;
					vec.add(rs.getInt(5)) ;
                    aaa++;
		                }

		    		int a = 0;
		    		int b = 0;
		    		int c = 0;
		    		if (ItemI == 1) {

		    			a = (int) vec.get(3)-1;
		    			b = (int) vec.get(0);
                        c = (int) vec.get(4)+110;


		    		} else if (ItemI == 2) {
		    			a = (int) vec.get(8)-1;
		    			b = (int) vec.get(5);
		    			c = (int) vec.get(9)+120;

		    		} else if (ItemI == 3) {
		    			a = (int) vec.get(13)-1;
		    			b = (int) vec.get(10);
		    			c = (int) vec.get(14)+130;
		    		} else if (ItemI == 4) {
		    			a = (int) vec.get(18)-1;
		    			b = (int) vec.get(15);
		    			c = (int) vec.get(19)+140;
		    		} else if (ItemI == 5) {
		    			a = (int) vec.get(23)-1;
		    			b = (int) vec.get(20);
		    			c = (int) vec.get(24)+200;
		    		}

		    		/********** updating table goods stock ****************/

		    			sql = "UPDATE shouhin SET zaiko=? , uriage= ?   where number=?  ";
		    			st = cnx.prepareStatement(sql);

			    		st.setInt(1,a);
			    		st.setInt(2,c);
			    		st.setInt(3,b);
			    		st.executeUpdate();
			    		cnx.commit();








		    	    }catch (SQLException e) {

		    		e.printStackTrace();
		    	    }
		    	}








	/**
	 * @param args
	 */
	public static void money(String[] args)throws Exception  {
		int tenYen;
		int fiftyYen;
		int hundredYen;
		int fiveHundredYen;
		int thousandYen;
		//現在の金額
		int nowMoney=0;
		boolean a = true;
		String[] dri =  {"ポカリ","レッドブル","コーラ","お茶","水"};
		int[] nedan =  {110,120,130,150,200};

		// TODO 自動生成されたメソッド・スタブ

		while(true)LABEL1:{

		System.out.println("\n金額の数を入力してください。");
		try {
		System.out.print("\n10  円-->");
		BufferedReader ten = new BufferedReader(new InputStreamReader(System.in));

		String aaa;

			aaa = ten.readLine();


		 tenYen=Integer.parseInt(aaa);

		System.out.print("50  円-->");
		BufferedReader fifty= new BufferedReader(new InputStreamReader(System.in));

		String bbb=fifty.readLine();
		 fiftyYen=Integer.parseInt(bbb);
		 System.out.print("100 円-->");
		BufferedReader handred= new BufferedReader(new InputStreamReader(System.in));

		String ccc=handred.readLine();
		hundredYen=Integer.parseInt(ccc);

		System.out.print("500 円-->");
		BufferedReader fiveHundred= new BufferedReader(new InputStreamReader(System.in));

		String ddd=fiveHundred.readLine();
		fiveHundredYen=Integer.parseInt(ddd);


		System.out.print("1000円-->");
		BufferedReader thousand= new BufferedReader(new InputStreamReader(System.in));

		String eee=thousand.readLine();
		thousandYen=Integer.parseInt(eee);

		nowMoney=(10*tenYen)+(50*fiftyYen)+(100*hundredYen)+(500*fiveHundredYen)+(1000*thousandYen);
		System.out.println("合計-->"+nowMoney+"円");


		if(nowMoney>1990){
			System.out.println("金額が上限を超えたので投入金額を全額返却しました。もう一度入力してください。\n\n");
			continue;

		}else if(nowMoney<110){
			System.out.println("購入額に満たしていません。追加金額を入力してください。\n\n");
			continue;

		}else{

		System.out.println("購入可能金額です。");
		FetchData();
		}










		//商品を表示




while(true)LAVEL2:{

	try{

		System.out.println("商品を選択してください");
		System.out.print("-->");
		BufferedReader item= new BufferedReader(new InputStreamReader(System.in));

		String eee1=item.readLine();
		int itemI=Integer.parseInt(eee1);




		zaiko(itemI);

		switch(itemI){


		case 1:
			if(nowMoney<nedan[0]){
				System.out.println("金額が足りていません。");

				System.out.println(nowMoney+"円を返却しました。");
				System.out.println("金銭投入に戻ります。");

				break LABEL1;
			}



				else{
					nowMoney=nowMoney-nedan[0];

					System.out.println(dri[0]+"を購入しました。");
					System.out.println("お釣りは"+nowMoney+"円です。");
break;
				}

		case 2:
			if(nowMoney<nedan[1]){
				System.out.println("金額が足りていません。");
				System.out.println(nowMoney+"円を返却しました。");
				System.out.println("金銭投入に戻ります。");
				break LABEL1;
			}
				else{
					nowMoney=nowMoney-nedan[1];

					System.out.println(dri[1]+"を購入しました。");
					System.out.println("お釣りは"+nowMoney+"円です。");

					break;
			}
       case 3:
	if(nowMoney<nedan[2]){
		System.out.println("金額が足りていません。");
		System.out.println(nowMoney+"円を返却しました。");
		System.out.println("金銭投入に戻ります。");
		break LABEL1;
	}
		else{
			nowMoney=nowMoney-nedan[2];
			System.out.println(dri[2]+"を購入しました。");
			System.out.println("お釣りは"+nowMoney+"円です。");

			break;
	}
       case 4:
			if(nowMoney<nedan[3]){
				System.out.println("金額が足りていません。");
				System.out.println(nowMoney+"円を返却しました。");
				System.out.println("金銭投入に戻ります。");
				break LABEL1;
			}
				else{
					nowMoney=nowMoney-nedan[3];
					System.out.println(dri[3]+"を購入しました。");
					System.out.println("お釣りは"+nowMoney+"円です。");

					break;
			}

       case 5:
	if(nowMoney<nedan[4]){
		System.out.println("金額が足りていません。");
		System.out.println(nowMoney+"円を返却しました。");
		System.out.println("金銭投入に戻ります。");
		break LABEL1;
	}
		else{
			nowMoney=nowMoney-nedan[4];
			System.out.println(dri[4]+"を購入しました。");
			System.out.println("お釣りは"+nowMoney+"円です。");

			break;

	}
       case 6:
    	   System.out.println("金銭返却が選ばれました。");
	       System.out.println(nowMoney+"円を返却します。");
	       System.out.println("モード選択画面に戻ります。");
	       maina.main(args);


       default:
    	   System.out.println("不正な入力です。もう一度入力してください。\n\n");
    	   break LAVEL2;

   	}
}catch (Exception e) {
	System.out.println("不正入力です。もう一度やり直してください。");
	break LAVEL2;



}





while(true)LAVEL3:{
	try{
	System.out.println("もう一度購入しますか？");
	System.out.print("Y:購入 N:終了==>");
	BufferedReader count= new BufferedReader(new InputStreamReader(System.in));

	String fff1=count.readLine();


	switch(fff1){

	case "Y":
	case "y":
		System.out.println("購入が選択されました。");
		FetchData();


		break LAVEL2;


	case "N":
	case "n":
		System.out.println("終了が選択されました。");
		System.out.println("お釣りは"+nowMoney+"円を返却します。");
		System.out.println("ご利用ありがとうございました。");
		break;

	default:
		System.out.println("不正な入力です。もう一度入力してください。\n\n");
		break LAVEL3;

	}break;






}catch (Exception e) {
	System.out.println("不正入力です。もう一度やり直してください。");
	break LAVEL3;
}
}
break;
}



	}catch (Exception e) {
		System.out.println("不正入力です。もう一度やり直してください。");
		break LABEL1;


	}break;
}
	}




	}










