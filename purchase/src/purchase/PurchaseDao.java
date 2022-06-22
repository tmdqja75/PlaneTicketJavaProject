package purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.MysqlConnect;

public class PurchaseDao {
	private MysqlConnect dbconn;

	public PurchaseDao() {
		dbconn = MysqlConnect.getInstance();
	}

	// 1. 상품조회 product table의 모든정보를 list로 반환
	public ArrayList<Product> printProducts() {
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();

		Connection conn = dbconn.getConn();

		String sql = "select * from product"; // product table의 모든정보를 출력하게 해두었음. product class 구현에 따라서 변경할것
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getInt(9)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

	// 2. 여행상품 구매
	public void purchase(Reservation r) {
		Connection conn = dbconn.getConn();

		String sql = "insert into purchaseinfo(customer_id, customer_pwd, product_number, ticket_count, isPay) values(?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getCustomer_id());
			pstmt.setString(2, r.getCustomer_pwd());
			pstmt.setString(3, r.getProduct_number());
			pstmt.setInt(4, r.getTicket_count());
			pstmt.setBoolean(5, r.isPay());
			
			for (int i = 0; i<r.getTicket_count();i++) { // Ticker_count만큼 db에 추가
			pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	// 2.1 구매한 내역이 있는지 확인해서 비밀번호 리턴
		public String checkIsbuy(String customer_id) {
			ResultSet rs = null;
			Connection conn = dbconn.getConn();
			String sql = "select customer_pwd from purchaseInfo where customer_id = ?";
			
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, customer_id);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					return rs.getString(1);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} return "";
			
			
		}

	// 3. 예매확인 - 구매자 id를 입력으로 받아서 해당 id에 해당하는 리스트 반환
	public ArrayList<Reservation> search(String customer_id, String customer_pwd) {
		ResultSet rs = null;
		ArrayList<Reservation> list = new ArrayList<Reservation>();

		Connection conn = dbconn.getConn();

		String sql = "select num, customer_id, product_number, ticket_count, passport_id, isPay	from purchaseInfo where customer_id = ? and customer_pwd = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_id);
			pstmt.setString(2, customer_pwd);

			rs = pstmt.executeQuery();

			while (rs.next()) {// 비밀번호 부분은 **** 로 출력
				list.add(new Reservation(rs.getInt(1), rs.getString(2), "****", rs.getString(3), rs.getInt(4),
						rs.getInt(5), rs.getBoolean(6)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

	// 4. 결제
	public boolean updateIspay(String id) {
		Connection conn = dbconn.getConn();

		String sql = "update purchaseinfo set isPay = True where customer_id = ?";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				return true;
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}



	// 4.1 결제 여부 확인
	public boolean checkIspay(String id) {
		Connection conn = dbconn.getConn();
		ResultSet rs = null;

		String sql = "select isPay from purchaseinfo where customer_id = ?";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getBoolean(1) == false) {
				return false;
				}
				
				}
			
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;

	}

	// 5. 결제 취소
	public boolean cancelIspay(String id, String pwd) {
		Connection conn = dbconn.getConn();

		String sql = "update purchaseinfo set isPay = False where customer_id = ? and customer_pwd = ? and isPay = True";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	// 6. 예매 취소
	public boolean cancelReservation(String id, String pwd) {
		Connection conn = dbconn.getConn();

		String sql = "delete from purchaseinfo where customer_id = ? and customer_pwd = ? and isPay = False";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	// 해외여행 상품인지 확인
	public boolean checkAbroad(String s) {
		Connection conn = dbconn.getConn();

		String sql = "select flight_type from product where flight_id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				boolean flag = rs.getBoolean(1);
				if (flag) {
					return true;
				}
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	// id로 product_number 조회(좌석수 처리관련)
	public String searchProductNumber(String id) {
		Connection conn = dbconn.getConn();

		String sql = "select product_number from purchaseInfo where customer_id = ?";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String number = rs.getString(1);
				return number;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	// productnumber로 flightid 조회(좌석수 처리를 위해)
	public String searchFlightId(String number) {
		Connection conn = dbconn.getConn();

		String sql = "select flight_id from product where product_number = ?";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.executeQuery();

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String fid = rs.getString(1);
				return fid;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	// customer id로 ticket number 조회(좌석수 처리를 위해)
	public int getTicketNumber(String id) {
		Connection conn = dbconn.getConn();

		String sql = "select ticket_count from purchaseInfo where customer_id = ?";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int number = rs.getInt(1);
				return number;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

//	 6. 좌석수 처리(-) , 결제시 적용
	public boolean minusSeat(String id) {
		String number = searchProductNumber(id); // 입력된 id로부터 productnumber 받아옴
		int ticket_count = getTicketNumber(id); // Ticket 갯수
		String flight_id = searchFlightId(number); // productnumber를 통해 flight_id 받아옴
		int count = checkSeat(flight_id); // 잔여석
		if (count - ticket_count >= 0) { // 구매할 티켓 개수가 잔여석보다 작아야함
			Connection conn = dbconn.getConn();

			String sql = "update flight set remnantCount = (remnantCount - ?) where flight_id = ?"; // 잔여석 - 티켓결제수

			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ticket_count);
				pstmt.setString(2, flight_id);
				int cnt = pstmt.executeUpdate();
				if (cnt > 0) {
					return true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("잔여석 부족");
			return false;
		}
		return false;

	}

	// 7. 좌석수 처리(+) , 결제 취소시 적용
	public void plusSeat(String id) {
		String number = searchProductNumber(id); // id로 productnumber받아옴
		int ticket_count = getTicketNumber(id); // Ticket 갯수
		String flight_id = searchFlightId(number); // productnumber로 flight_id 받아옴

		Connection conn = dbconn.getConn();

		String sql = "update flight set remnantCount = (remnantCount + ?) where flight_id = ?"; // 잔여석 + 티켓 결제취소수

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ticket_count);
			pstmt.setString(2, flight_id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 좌석수 처리(-) 일때 잔여좌석이 -가 되면 안되므로 잔여석확인추가
	public int checkSeat(String flight_id) {
		Connection conn = dbconn.getConn();

		String sql = "select remnantCount from flight where flight_id = ?";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, flight_id);
			pstmt.executeQuery();

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int number = rs.getInt(1);
				return number;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}
}
