package Bank_sytem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank_main {
	// 用户
	List<Person> mes = new ArrayList<Person>();
	// 卡号
	ArrayList<String> ckid_Array = new ArrayList<String>();

	// 开户方法
	public void creatAdmin() {
		Scanner in = new Scanner(System.in);
		// Person p1 = new Person();
		System.out.print("你选择的是开户业务,");
		System.out.println("创建您的账户名：");
		String name_ = in.next();
		// p1.setName(name_);
		System.out.println("请输入你要创建的卡号：");
		String id_ = in.next();
		ckid_Array.add(id_);
		// System.out.println(ckid_Array.size());
		// ckid_Array.add(obj.getId());
		// p1.setId(id_);
		System.out.println("请输入你要存入的金额：");
		Long money_ = in.nextLong();
		// p1.setMoney(money_);
		// System.out.println(mes);
		Person p = new Person(id_, name_, money_);
		System.out.println(p.toString());
		mes.add(p);
	}

	// 存钱的方法
	public void saveMoney() {
		System.out.print("你选择的是存款业务");
		System.out.println("请输入您的卡号：");
		Scanner in = new Scanner(System.in);
		String id_c = in.next();

		// 判断卡号是存在
		if (ckid_Array.contains(id_c)) {
			System.out.println("用户存在");

			System.out.println(ckid_Array.size());
			for (int i = 0; i < ckid_Array.size(); i++) {
				Person obj = (Person) mes.get(i);
				// System.out.println(obj.getId());
				if (id_c.equals(obj.getId())) {
					System.out.println("请输入你要存的金额:");
					Long money_c = in.nextLong();
					Long monye_y = obj.getMoney();
					Long new_money = money_c + monye_y;
					obj.setMoney(new_money);
					System.out.println("你的余额为：" + new_money);
				} else {
					continue;
				}
			}

		} else {
			System.out.println("用户不存在");
		}
	}

	// 取款方法
	public void drawMoney() {
		System.out.println("你选择的是取款业务");
		System.out.println("请输入您的卡号：");
		System.out.println(ckid_Array);
		Scanner in = new Scanner(System.in);
		String id_c = in.next();

		if (ckid_Array.contains(id_c)) {

			System.out.println("用户存在");

			for (int i = 0; i < ckid_Array.size(); i++) {
				Person obj = (Person) mes.get(i);

				if (id_c.equals(obj.getId())) {
					System.out.println("请输入你要取的金额:");
					Long money_q = in.nextLong();

					Long monye_y = obj.getMoney();
					if (money_q > monye_y) {
						System.out.println("余额不足");
					} else {
						Long new_money = monye_y - money_q;
						obj.setMoney(new_money);
						System.out.println("你的余额为：" + new_money);
					}

				} else {
					continue;
				}
			}
		} else {
			System.out.println("用户不存在");
		}
	}

	// 转账方法
	public void transforAcount() {
		System.out.print("你选择的是转账业务");
		System.out.println("请输入您转出的卡号：");
		System.out.println(ckid_Array);
		Scanner in = new Scanner(System.in);
		String id_zmy = in.next();
		System.out.println("请输入您要转入的卡号：");
		String id_zyou = in.next();

		//首先判断卡号是否存在
		if (ckid_Array.contains(id_zmy) && ckid_Array.contains(id_zyou)) {

			System.out.println("用户存在");
			Long money_zhuan = null;// 转账的金额初始为null;

			// 转账人的业务
			for (int i = 0; i < ckid_Array.size(); i++) {
				Person obj = (Person) mes.get(i);
				if (id_zmy.equals(obj.getId())) {
					System.out.println("请输入你要转的金额:");
					money_zhuan = in.nextLong();
					// 获取转账人当前的金额
					Long monye_zy = obj.getMoney();
					// 判断当前金额是否可以转账
					if (money_zhuan > monye_zy) {
						System.out.println("余额不足");
					} else {

						Long new_money = monye_zy - money_zhuan;
						obj.setMoney(new_money);
						System.out.println("你的余额为：" + new_money);
					}

				} else {
					continue;
				}
			}

			// 收款人的业务
			for (int j = 0; j < ckid_Array.size(); j++) {
				Person obj = (Person) mes.get(j);
				if (id_zyou.equals(obj.getId())) {
					Long monye_zy = obj.getMoney();
					Long new_money = money_zhuan + monye_zy;
					obj.setMoney(new_money);
				} else {
					continue;
				}
			}
		} else {
			System.out.println("用户不存在");
		}
	}

	// 查询所有的方法
	public void findAll() {
		System.out.println("你选择的业务是查询");
		System.out.println(mes);
	}
	
	//按账号查询用户信息的方法
	public void findById(){
		System.out.print("你选择的是查询个人信息业务");
		System.out.println("请输入您的卡号：");
		System.out.println(ckid_Array);
		Scanner in = new Scanner(System.in);
		String id_c = in.next();
		if (ckid_Array.contains(id_c)) {
			System.out.println("用户存在");

			for (int i = 0; i < ckid_Array.size(); i++) {
				Person obj = (Person) mes.get(i);
				if (id_c.equals(obj.getId())) {
						System.out.println(obj);
					}
				else {
					continue;
					}
				}
			}
		else{
			System.out.println("用户不存在,查询失败");
		}
	}
	
	
	public static void main(String[] args) {
		Bank_main bm = new Bank_main();
		System.out.println("*******欢迎来到银行系统，请选择您要办理的业务*******");

		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.print("1-开户" + "****" + "2-存款" + "****" + "3-取款"+"****"+"4-转账" + "****" + "5-查询" + "****" + "6-查询全部" );
		
			int item = in.nextInt();

			if (item == 1) {
				// 存款业务
				bm.creatAdmin();
			} else if (item == 2) {
				// 存款业务
				bm.saveMoney();
			}

			else if (item == 3) {
				// 取款业务
				bm.drawMoney();

			} else if (item == 4) {
				// 转账业务
				bm.transforAcount();
			} else if (item == 5) {
				//查询单个用户信息
				bm.findById();
			} else if(item==6){
				//查询全部
				bm.findAll();
			}else{
				System.out.println("你的输入有误请重新选择");
			}
		}
	}
}
