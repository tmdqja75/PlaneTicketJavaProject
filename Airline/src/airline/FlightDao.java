package airline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.MysqlConnect;

public class FlightDao {
	private MysqlConnect dbconn;

	public FlightDao() {
		dbconn = MysqlConnect.getInstance();
	}

	public void insert(Flight p) {
		// 1. db연결
		Connection conn = dbconn.getConn();

		// 2. sql
		String sql = "insert into Flight(flight_id, airline, start_time, arrival_time, starting_point, destination,"
				+ "remnantCount, flight_price) values(?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getFlight_id());
			pstmt.setString(2, p.getAirline());
			pstmt.setString(3, p.getStartTime());
			pstmt.setString(4, p.getArrivalTime());
			pstmt.setString(5, p.getStartingPoint());
			pstmt.setString(6, p.getDestination());
			pstmt.setInt(7, p.getRemnantCount());
			pstmt.setInt(8, p.getFlightPrice());

			int cnt = pstmt.executeUpdate();
            System.out.println(cnt + " 줄 추가됨");
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

	public ArrayList<Flight> selectByFlightId(String flight_id) {
		ArrayList<Flight> list = new ArrayList<Flight>();
		
		ResultSet rs = null;
		// db연결
		Connection conn = dbconn.getConn();
		// sql 문 작성
		String sql = "select * from flight where flight_id=?";

		try {
			// preparedstmt 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ?매칭
			pstmt.setString(1, flight_id);

			// sql 실행
			rs = pstmt.executeQuery();// 검색한 결과를 ResultSet으로 반환

			while (rs.next()) {
				list.add(new Flight(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getInt(7), rs.getInt(8)));
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
	
	public ArrayList<Flight> selectBystartingPoint(String startingPoint) {
		ArrayList<Flight> list = new ArrayList<Flight>();
		ResultSet rs = null;
		// db연결
		Connection conn = dbconn.getConn();
		// sql 문 작성
		String sql = "select * from flight where starting_point = ?";

		try {
			// preparedstmt 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ?매칭
			pstmt.setString(1, startingPoint);

			// sql 실행
			rs = pstmt.executeQuery();// 검색한 결과를 ResultSet으로 반환

			while (rs.next()) {
				list.add(new Flight(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getInt(7), rs.getInt(8)));
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
	
	public ArrayList<Flight> selectByDestination(String destination) {
		ArrayList<Flight> list = new ArrayList<Flight>();
		ResultSet rs = null;
		// db연결
		Connection conn = dbconn.getConn();
		// sql 문 작성
		String sql = "select * from flight where destination = ?";

		try {
			// preparedstmt 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ?매칭
			pstmt.setString(1, destination);

			// sql 실행
			rs = pstmt.executeQuery();// 검색한 결과를 ResultSet으로 반환

			while (rs.next()) {
				list.add(new Flight(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getInt(7), rs.getInt(8)));
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
	
	
	public ArrayList<Flight> selectByPlace(String startingPoint, String destination) {
		ArrayList<Flight> list = new ArrayList<Flight>();
		ResultSet rs = null;
		// db연결
		Connection conn = dbconn.getConn();
		// sql 문 작성
		String sql = "select * from flight where starting_point = ? and destination = ?";

		try {
			// preparedstmt 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ?매칭
			pstmt.setString(1, startingPoint);
			pstmt.setString(2, destination);

			// sql 실행
			rs = pstmt.executeQuery();// 검색한 결과를 ResultSet으로 반환

			while (rs.next()) {
				list.add(new Flight(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getInt(7), rs.getInt(8)));
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

	public ArrayList<Flight> selectByDay(String day) {
		ArrayList<Flight> list = new ArrayList<Flight>();
		
		ResultSet rs = null;
		// db연결
		Connection conn = dbconn.getConn();
		// sql 문 작성
		String sql = "select * from flight where date(start_time) = ?";

		try {
			// preparedstmt 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ?매칭
			pstmt.setString(1, day);

			// sql 실행
			rs = pstmt.executeQuery();// 검색한 결과를 ResultSet으로 반환

			while (rs.next()) {
				list.add(new Flight(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getInt(7), rs.getInt(8)));
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
	
	// 고객용
	public ArrayList<Flight> selectByPlaceAndDay(String startingPoint,String destination,String day) {
		ArrayList<Flight> list = new ArrayList<Flight>();
		ResultSet rs = null;
		// db연결
		Connection conn = dbconn.getConn();
		// sql 문 작성
		String sql = "select * from flight where date(start_time) = ? and starting_point = ? and destination = ?";

		try {
			// preparedstmt 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// ?매칭
			pstmt.setString(1, day);
			pstmt.setString(2, startingPoint);
			pstmt.setString(3, destination);

			// sql 실행
			rs = pstmt.executeQuery();// 검색한 결과를 ResultSet으로 반환

			while (rs.next()) {
				list.add(new Flight(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getInt(7), rs.getInt(8)));
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
	
	
	public ArrayList<Flight> selectAll() {
		ArrayList<Flight> list = new ArrayList<Flight>();
		ResultSet rs = null;
		Connection conn = dbconn.getConn();
		String sql = "select * from flight order by flight_id";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Flight(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getInt(7), rs.getInt(8)));
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

	
	public void update(Flight p) {// 
		Connection conn = dbconn.getConn();
		String sql = "update flight set airline=?, start_time=?, arrival_time=?, starting_point=?, destination=?, remnantCount=?, flight_price=? where flight_id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getAirline());
			pstmt.setString(2, p.getStartTime());
			pstmt.setString(3, p.getArrivalTime());
			pstmt.setString(4, p.getStartingPoint());
			pstmt.setString(5, p.getDestination());
			pstmt.setInt(6, p.getRemnantCount());
			pstmt.setInt(7, p.getFlightPrice());
			pstmt.setString(8, p.getFlight_id());

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
	
	// 시간 수정
	public void updateTime(String startTime, String arrivalTime, String flight_id) {
		Connection conn = dbconn.getConn();
		String sql = "update flight set start_time=? ,arrival_time=? where flight_id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, startTime);
			pstmt.setString(2, arrivalTime);
			pstmt.setString(3, flight_id);

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
	
	// 장소 수정
	public void updatePlace(String startingPoint, String destination, String flight_id) {
		Connection conn = dbconn.getConn();
		String sql = "update flight set starting_point=? ,destination=? where flight_id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, startingPoint);
			pstmt.setString(2, destination);
			pstmt.setString(3, flight_id);

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

	// 잔여석 수정
	public void updateRemnantCount(int remnantCount, String flight_id) {
		Connection conn = dbconn.getConn();
		String sql = "update flight set remnantCount=? where flight_id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, remnantCount);
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
	
	// 가격 수정
		public void updateFlightPrice(int flightPrice,String flight_id) {
			Connection conn = dbconn.getConn();
			String sql = "update flight set flight_price=? where flight_id=?";

			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, flightPrice);
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

	public boolean delete(String flight_id) {
		Connection conn = dbconn.getConn();
		String sql = "delete from flight where flight_id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, flight_id);

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
}